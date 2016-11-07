package commands;

import mx.com.nmp.ms.sivad.catalogo.domain.CalidadLey;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.service.CalidadLeyService;
import org.crsh.cli.*;
import org.crsh.command.BaseCommand;
import org.crsh.command.InvocationContext;
import org.crsh.text.Color;
import org.crsh.text.Decoration;
import org.crsh.text.Style;
import org.crsh.text.ui.BorderStyle;
import org.crsh.text.ui.LabelElement;
import org.crsh.text.ui.Overflow;
import org.crsh.text.ui.TableElement;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Usage("Administra operaciones del cat\u00e1logo Calidades Ley.")
public class calidadLey extends BaseCommand {

    private TableElement table;

    /**
     * Obtiene el bean del contexto de spring para interarctuar con el API, clase CalidadLeyService
     *
     * @return CalidadLeyService
     */
    private CalidadLeyService getController() {
        BeanFactory factory = (BeanFactory) this.context.getAttributes().get("spring.beanfactory");
        return (CalidadLeyService) factory.getBean(CalidadLeyService.class);
    }

    /**
     * Crea el header de la tabla con los elementos.
     *
     * @return TableElement
     */
    private TableElement getTable() {
        TableElement table = new TableElement()
            .separator(BorderStyle.DASHED)
            .overflow(Overflow.HIDDEN)
            .rightCellPadding(1);
        table.row(
            new LabelElement("Abreviatura").style(Style.style(Decoration.bold).foreground(Color.black).background(Color.white)),
            new LabelElement("Etiqueta").style(Style.style(Decoration.bold).foreground(Color.black).background(Color.white))
        );

        return table;
    }

    /**
     * Modifica un elemento del catalogo.
     *
     * @param context     coontexto del objeto.
     * @param abreviatura nueva abreviatura que sera asignada al elemento.
     * @param etiqueta    nueva etiqueta que sera asignada al elemento.
     */
    @Command
    @Usage("Modifica los datos del elemento del cat\u00e1logo mediante la Abreviatura")
    public void modificar(InvocationContext<Object> context,
                          @Usage("Elemento a Modificar") @Required @Option(names = {"m", "abreviaturaActual"}) String abreviaturaActual,
                          @Usage("Abreviatura") @Option(names = {"a", "abreviatura"}) String abreviatura,
                          @Usage("Etiqueta") @Option(names = {"e", "etiqueta"}) String etiqueta) throws Exception {

        CalidadLey calidadLeyModificar = new CalidadLey();

        if (ObjectUtils.isEmpty(abreviatura) && ObjectUtils.isEmpty(etiqueta)) {
            context.provide(new LabelElement("\nSe requiere al menos un elemento [Abreviatura, Etiqueta] para realizar la operaci\u00f3n \n"));
        } else {
            try {
                calidadLeyModificar.setAbreviatura(abreviatura);
                calidadLeyModificar.setEtiqueta(etiqueta);

                CalidadLey calidadLey = this.getController().update(abreviaturaActual, calidadLeyModificar);

                table = getTable();
                table.row(
                    new LabelElement(calidadLey.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(calidadLey.getEtiqueta()).style(Style.style(Color.yellow))
                );

                context.provide(new LabelElement("\nEl elemento con abreviatura ["+abreviaturaActual+"] ha sido modificado:\n"));
                context.provide(table);
            } catch (CatalogoNotFoundException e) {
                context.provide(new LabelElement("\nEl elemento del cat\u00e1logo con abreviatura [" + abreviaturaActual + "] no existe.\n"));
            } catch (DataIntegrityViolationException e) {
                context.provide(new LabelElement("\nEl elemento con abreviatura [" + abreviaturaActual + "] ya existe.\n"));
            }

        }

    }


    /**
     * Obtiene los elementos del catalogo.
     *
     * @param context contexto del objeto.
     */
    @Command
    @Usage("Muestra los elementos del cat\u00e1logo.")
    public void elementos(InvocationContext<Object> context) {

        try {
            List<CalidadLey> lstCalidadLey = this.getController().findAll();

            table = getTable();
            for (CalidadLey calidadLey : lstCalidadLey) {
                table.row(
                    new LabelElement(calidadLey.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(calidadLey.getEtiqueta()).style(Style.style(Color.yellow))
                );
            }

            context.provide(new LabelElement("\nElementos del cat\u00e1logo:\n"));
            context.provide(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Obtiene los elementos del catalogo.
     *
     * @param context contexto del objeto.
     */
    @Command
    @Usage("Muestra un elemento del cat\u00e1logo.")
    public void elemento(InvocationContext<Object> context,
                         @Usage("Abreviatura del elemento.") @Required @Argument String abreviatura) throws Exception {

        try {
            CalidadLey calidadLey = this.getController().obtenerElementoAbreviatura(abreviatura);

            table = getTable();
            table.row(
                new LabelElement(calidadLey.getAbreviatura()).style(Style.style(Color.green)),
                new LabelElement(calidadLey.getEtiqueta()).style(Style.style(Color.yellow))
            );
            context.provide(new LabelElement("\nElemento del cat\u00e1logo:\n"));
            context.provide(table);

        } catch (CatalogoNotFoundException e) {
            context.provide(new LabelElement("\nEl elemento con Abrevitura [" + abreviatura + "] no existe.\n"));
        } catch (Exception e) {
            context.provide("\nOcurrio una error al realizar la operaci\u00f3n.\n");
        }
    }

    /**
     * Elimina elemento del catalogo por abreviatura.
     *
     * @param abreviatura del elemento a eliminar.
     * @return String.
     */
    @Command
    @Usage("Elimina un elemento del cat\u00e1go por abreviatura.")
    public String eliminar(
        @Usage("Abreviatura del cat\u00e1logo.") @Required @Argument String abreviatura) {
        try {
            this.getController().delete(abreviatura);
            return "\nEl elemento con abreviatura [" + abreviatura + "] fue eliminado exitosamente.\n";
        } catch (CatalogoNotFoundException e) {
            return "\nEl elemento del cat\u00e1logo con abreviatura [" + abreviatura + "] no existe.\n";
        }
    }

    /**
     * Agrega elemento de catalogo de tipo CalidadLey.
     *
     * @param context     contexto del objeto.
     * @param abreviatura abreviatura del elemento.
     * @param etiqueta    etiqueta del elemento.
     */
    @Command
    @Usage("Agrega un elemento al cat\u00e1logo de tipo CondicionPrenda.")
    public void agregar(InvocationContext<Object> context,
                        @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                        @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta) throws Exception {
        try {
            CalidadLey calidadLey = new CalidadLey();
            calidadLey.setAbreviatura(abreviatura);
            calidadLey.setEtiqueta(etiqueta);

            this.getController().save(calidadLey);

            table = getTable();
            table.row(
                new LabelElement(calidadLey.getAbreviatura()).style(Style.style(Color.green)),
                new LabelElement(calidadLey.getEtiqueta()).style(Style.style(Color.yellow))
            );

            context.provide(new LabelElement("\nEl elemento con abreviatura ["+abreviatura+"] fue agregado correctamente.\n"));
            context.provide(table);
        } catch (DataIntegrityViolationException e) {
            context.provide(new LabelElement("\nEl elemento con Abrevitura [" + abreviatura + "] ya existe.\n"));
        } catch (Exception e) {
            context.provide("\nOcurrio una error al realizar la operaci\u00f3n");
        }
    }
}
