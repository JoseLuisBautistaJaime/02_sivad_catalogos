package commands;

import mx.com.nmp.ms.sivad.catalogo.domain.MotivoBajaPrestamo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.service.MotivoBajaPrestamoService;
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

/**
 * Clase que contiene los comandos para ejecutar las operaciones de catalogo mediante SSH.
 */

@Usage("Administra operaciones del cat\u00e1logo Motivos de Baja de Prestamo.")
public class motBajaPrestamo extends BaseCommand {

    private TableElement table;

    /**
     * Obtiene el bean del contexto de spring para interarctuar con el API, clase MotivoBajaPrestamo
     *
     * @return MotivoBajaPrestamoService
     */
    private MotivoBajaPrestamoService getController() {
        BeanFactory factory = (BeanFactory) this.context.getAttributes().get("spring.beanfactory");
        return factory.getBean(MotivoBajaPrestamoService.class);
    }

    /**
     * Crea el header de la tabla.
     *
     * @return Tabla
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
     * Elimina elemento del catalogo por abreviatura.
     *
     * @param abreviatura del elemento a eliminar.
     * @return String.
     */
    @Command
    @Usage("Elimina un elemento del cat\u00e1logo por la abreviatura.")
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
     * Agrega elemento de catalogo de tipo CondicionPrenda.
     *
     * @param context     contexto del objeto
     * @param abreviatura Abreviatura del elemento
     * @param etiqueta    Etiqueta del elemento
     */
    @Command
    @Usage("Agrega un elemento al cat\u00e1logo.")
    public void agregar(InvocationContext<Object> context,
                        @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                        @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta) throws Exception {
        try {
            MotivoBajaPrestamo motivoBajaPrestamo = new MotivoBajaPrestamo();
            motivoBajaPrestamo.setAbreviatura(abreviatura);
            motivoBajaPrestamo.setEtiqueta(etiqueta);

            this.getController().save(motivoBajaPrestamo);

            table = getTable();
            table.row(
                new LabelElement(motivoBajaPrestamo.getAbreviatura()).style(Style.style(Color.green)),
                new LabelElement(motivoBajaPrestamo.getEtiqueta()).style(Style.style(Color.yellow))
            );

            context.provide(new LabelElement("\nEl elemento con abreviatura ["+abreviatura+"] fue agregado correctamente.\n"));
            context.provide(table);
        } catch (DataIntegrityViolationException e) {
            context.provide(new LabelElement("\nEl elemento con Abreviatura [" + abreviatura + "] ya existe.\n"));
        } catch (Exception e) {
            context.provide("\nOcurrio una error al realizar la operaci\u00f3n");
        }
    }

    /**
     * Obtiene los elementos del catalogo.
     *
     * @param context contexto del objeto
     */
    @Command
    @Usage("Muestra los elementos del cat\u00e1logo.")
    public void elementos(InvocationContext<Object> context) {

        try {
            List<MotivoBajaPrestamo> lstMotivoBaja = this.getController().findAll();

            table = getTable();

            for (MotivoBajaPrestamo motivoBaja : lstMotivoBaja) {
                table.row(
                        new LabelElement(motivoBaja.getAbreviatura()).style(Style.style(Color.green)),
                        new LabelElement(motivoBaja.getEtiqueta()).style(Style.style(Color.yellow))
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
     * @param context contexto del objeto
     */
    @Command
    @Usage("Muestra un elemento del cat\u00e1logo por abreviatura.")
    public void elemento(InvocationContext<Object> context,
                         @Usage("Abreviatura del elemento.") @Required @Argument String abreviatura) throws Exception {

        try {
            MotivoBajaPrestamo motivoBajaPrestamo = this.getController().obtenerElementoAbreviatura(abreviatura);

            table = getTable();
            table.row(
                new LabelElement(motivoBajaPrestamo.getAbreviatura()).style(Style.style(Color.green)),
                new LabelElement(motivoBajaPrestamo.getEtiqueta()).style(Style.style(Color.yellow))
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
     * Modifica un elemento del catalogo.
     *
     * @param context     contexto del objeto.
     * @param abreviatura nueva abreviatura que sera asignada al elemento.
     * @param etiqueta    nueva etiqueta que sera asignada al elemento.
     */
    @Command
    @Usage("Modifica los datos de un elemento del catalogo especidifcado por el identificador")
    public void modificar(InvocationContext<Object> context,
                          @Usage("Elemento a Modificar") @Required @Option(names = {"m", "abreviaturaActual"}) String abreviaturaActual,
                          @Usage("Abreviatura") @Option(names = {"a", "abreviatura"}) String abreviatura,
                          @Usage("Etiqueta") @Option(names = {"e", "etiqueta"}) String etiqueta) throws Exception {

        MotivoBajaPrestamo motivoBajaPrestamoModif = new MotivoBajaPrestamo();

        if (ObjectUtils.isEmpty(abreviatura) && ObjectUtils.isEmpty(etiqueta)) {
            context.provide(new LabelElement("\nSe requiere al menos un elemento [Abreviatura, Etiqueta] para realizar la operaci\u00f3n \n"));
        } else {
            try {
                motivoBajaPrestamoModif.setAbreviatura(abreviatura);
                motivoBajaPrestamoModif.setEtiqueta(etiqueta);

                MotivoBajaPrestamo motivoBajaPrestamo = this.getController().update(abreviaturaActual, motivoBajaPrestamoModif);

                table = getTable();
                table.row(
                    new LabelElement(motivoBajaPrestamo.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(motivoBajaPrestamo.getEtiqueta()).style(Style.style(Color.yellow))
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
}