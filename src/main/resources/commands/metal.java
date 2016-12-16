package commands;

import mx.com.nmp.ms.sivad.catalogo.domain.Metal;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.service.MetalService;
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

@Usage("Administración del catálogo Metales")
public class metal extends BaseCommand {

    private TableElement table;

    /**
     * Obtiene el bean del contexto de spring para interarctuar con el API, clase MetalService
     *
     * @return MetalService
     */
    private MetalService getController() {
        BeanFactory factory = (BeanFactory) this.context.getAttributes().get("spring.beanfactory");
        return (MetalService) factory.getBean(MetalService.class);
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
        table.header(
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
    @Usage("Permite actualizar un elemento del catálogo")
    public void modificar(InvocationContext<Object> context,
                          @Usage("Abreviatura actual del elemento a actualizar") @Required @Option(names = {"i", "abreviaturaActual"}) String abreviaturaActual,
                          @Usage("Abreviatura") @Option(names = {"a", "abreviatura"}) String abreviatura,
                          @Usage("Etiqueta") @Option(names = {"e", "etiqueta"}) String etiqueta) throws Exception {

        Metal metalModificar = new Metal();

        if (ObjectUtils.isEmpty(abreviatura) && ObjectUtils.isEmpty(etiqueta)) {
            context.provide(new LabelElement("\nSe requiere al menos uno de los atributos ([a, abreviatura] o [e, etiqueta]) para realizar la actualización."));
        } else {
            try {
                metalModificar.setAbreviatura(abreviatura);
                metalModificar.setEtiqueta(etiqueta);

                Metal metal = this.getController().update(abreviaturaActual, metalModificar);

                table = getTable();
                table.row(
                    new LabelElement(metal.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(metal.getEtiqueta()).style(Style.style(Color.yellow))
                );

                context.provide(new LabelElement("\nEl elemento con abreviatura [" + abreviaturaActual + "] ha sido modificado."));
                context.provide(table);
            } catch (CatalogoNotFoundException e) {
                context.provide(new LabelElement("\nEl elemento del catálogo con abreviatura [" + abreviaturaActual + "] no existe."));
            } catch (DataIntegrityViolationException e) {
                context.provide(new LabelElement("\nYa existe un elemento del catálogo con abreviatura [" + abreviatura + "]."));
            }

        }

    }

    /**
     * Obtiene los elementos del catalogo.
     *
     * @param context contexto del objeto.
     */
    @Command
    @Usage("Permite recuperar todos los elementos del catálogo")
    public void elementos(InvocationContext<Object> context) {

        try {
            List<Metal> lstMetal = this.getController().findAll();

            if (lstMetal != null && lstMetal.size() > 0) {
                table = getTable();

                for (Metal metal : lstMetal) {
                    table.row(
                        new LabelElement(metal.getAbreviatura()).style(Style.style(Color.green)),
                        new LabelElement(metal.getEtiqueta()).style(Style.style(Color.yellow))
                    );
                }

                context.provide(table);
            } else {
                context.provide(new LabelElement("\nEl cat\u00e1logo no contiene elementos."));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Obtiene los elementos del catalogo.
     *
     * @param context     contexto del objeto.
     * @param abreviatura del elemento.
     */
    @Command
    @Usage("Permite recuperar el elemento del catálogo que coincida con la abreviatura indicada")
    public void elemento(InvocationContext<Object> context,
                         @Usage("Abreviatura del elemento a recuperar") @Required @Argument String abreviatura) throws Exception {

        try {
            Metal metal = this.getController().obtenerElementoAbreviatura(abreviatura);

            table = getTable();
            table.row(
                new LabelElement(metal.getAbreviatura()).style(Style.style(Color.green)),
                new LabelElement(metal.getEtiqueta()).style(Style.style(Color.yellow))
            );
            context.provide(table);

        } catch (CatalogoNotFoundException e) {
            context.provide(new LabelElement("\nEl elemento del catá1ogo con abreviatura [" + abreviatura + "] no existe."));
        } catch (Exception e) {
            context.provide("\nOcurrio una error al realizar la operación.");
        }
    }

    /**
     * Elimina elemento del catalogo por abreviatura.
     *
     * @param abreviatura identificador de elemento a eliminar.
     * @return String.
     */
    @Command
    @Usage("Permite eliminar un elemento del catálogo")
    public String eliminar(
        @Usage("Abreviatura del elemento a eliminar") @Required @Argument String abreviatura) {
        try {
            this.getController().delete(abreviatura);
            return "\nEl elemento con abreviatura [" + abreviatura + "] fue eliminado correctamente del catálogo.";
        } catch (CatalogoNotFoundException e) {
            return "\nEl elemento del catálogo con abreviatura [" + abreviatura + "] no existe.";
        }
    }


    /**
     * Agrega elemento de catalogo de tipo Metales.
     *
     * @param context     contexto del objeto.
     * @param abreviatura abreviatura del elemento.
     * @param etiqueta    etiqueta del elemento.
     */
    @Command
    @Usage("Permite agregar un nuevo elemento al catálogo")
    public void agregar(InvocationContext<Object> context,
                        @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                        @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta) throws Exception {
        try {
            Metal metal = new Metal();
            metal.setAbreviatura(abreviatura);
            metal.setEtiqueta(etiqueta);

            this.getController().save(metal);

            table = getTable();
            table.row(
                new LabelElement(metal.getAbreviatura()).style(Style.style(Color.green)),
                new LabelElement(metal.getEtiqueta()).style(Style.style(Color.yellow))
            );

            context.provide(new LabelElement("\nEl elemento con abreviatura [" + abreviatura + "] fue agregado correctamente al catálogo."));
            context.provide(table);
        } catch (DataIntegrityViolationException e) {
            context.provide(new LabelElement("\nYa existe un elemento del catálogo con abreviatura [" + abreviatura + "]."));
        } catch (Exception e) {
            context.provide("\nOcurrio una error al realizar la operación.");
        }
    }
}
