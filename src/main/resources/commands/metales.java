package commands;

import mx.com.nmp.ms.sivad.catalogo.domain.Metal;
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

import java.util.List;

@Usage("Administra operaciones del cat\u00e1logo Metales")
public class metales extends BaseCommand {

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
                .overflow(Overflow.WRAP)
                .rightCellPadding(1);
        table.row(
                new LabelElement("ID_ELEMENTO").style(Style.style(Decoration.bold)),
                new LabelElement("ABREVIATURA").style(Style.style(Decoration.bold)),
                new LabelElement("ETIQUETA").style(Style.style(Decoration.bold)),
                new LabelElement("ID_CONFIGURACION").style(Style.style(Decoration.bold))
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
                          @Usage("Elemento a Modificar") @Required @Option(names = {"m", "elemento"}) String abrevModificar,
                          @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                          @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta) {

        try {
            Metal metalModificar = new Metal();

            if (this.getController().findbyAbreviatura(abrevModificar) == null) {
                context.provide(new LabelElement("\nEl elemento a modificar con abrevitura " + abrevModificar + " no existe.\n"));
            } else {
                metalModificar.setAbreviatura(abreviatura);
                metalModificar.setEtiqueta(etiqueta);

                Metal metal = this.getController().update(abrevModificar, metalModificar);

                table = getTable();

                table.row(
                        new LabelElement(metal.getElementoId()).style(Style.style(Color.cyan)),
                        new LabelElement(metal.getAbreviatura()).style(Style.style(Color.green)),
                        new LabelElement(metal.getEtiqueta()).style(Style.style(Color.yellow)),
                        new LabelElement(metal.getConfiguracion().getId().toString())
                );

                context.provide(new LabelElement("\nEl elemento modificado es:\n"));
                context.provide(table);
            }
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
    @Usage("Muestra los elementos del cat\u00e1logo.")
    public void elementos(InvocationContext<Object> context) {

        try {
            List<Metal> lstMetal = this.getController().findAll();

            table = getTable();

            for (Metal metal : lstMetal) {
                table.row(
                        new LabelElement(metal.getElementoId()).style(Style.style(Color.cyan)),
                        new LabelElement(metal.getAbreviatura()).style(Style.style(Color.green)),
                        new LabelElement(metal.getEtiqueta()).style(Style.style(Color.yellow)),
                        new LabelElement(metal.getConfiguracion().getId().toString())
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
     * @param context     contexto del objeto.
     * @param abreviatura del elemento.
     */
    @Command
    @Usage("Muestra un elemento del cat\u00e1logo.")
    public void elemento(InvocationContext<Object> context,
                         @Usage("Abreviatura del elemento.") @Required @Argument String abreviatura) {

        try {
            Metal metal = this.getController().findbyAbreviatura(abreviatura);

            if (metal == null) {
                context.provide(new LabelElement("\nEl elemento del cat\u00e1logo con abreviatura " + abreviatura + " no existe.\n"));
            } else {
                table = getTable();

                table.row(
                        new LabelElement(metal.getElementoId()).style(Style.style(Color.cyan)),
                        new LabelElement(metal.getAbreviatura()).style(Style.style(Color.green)),
                        new LabelElement(metal.getEtiqueta()).style(Style.style(Color.yellow)),
                        new LabelElement(metal.getConfiguracion().getId().toString())
                );

                context.provide(new LabelElement("\nElemento del cat\u00e1logo:\n"));
                context.provide(table);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Elimina elemento del catalogo por abreviatura.
     *
     * @param abreviatura identificador de elemento a eliminar.
     * @return String.
     */
    @Command
    @Usage("Elimina un elemento del cat\u00e1go por la abreviatura")
    public String eliminar(
            @Usage("Abreviatura del cat\u00e1logo.") @Required @Argument String abreviatura) {

        if (this.getController().findbyAbreviatura(abreviatura) == null) {
            return "El elemento del cat\u00e1logo con abreviatura " + abreviatura + " no existe.\n";
        } else {
            this.getController().delete(abreviatura);
            return "El elemento con abreviatura " + abreviatura + " fue eliminado exitosamente!";
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
    @Usage("Agrega un elemento al cat\u00e1logo de tipo CondicionPrenda.")
    public void agregar(InvocationContext<Object> context,
                        @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                        @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta) {
        try {
            Metal metal = new Metal();

            if (this.getController().findbyAbreviatura(abreviatura) != null) {
                context.provide(new LabelElement("\nEl elemento con Abrevitura " + abreviatura + " ya existe.\n"));
            } else {
                metal.setAbreviatura(abreviatura);
                metal.setEtiqueta(etiqueta);

                this.getController().save(metal);

                table = getTable();

                table.row(
                        new LabelElement(metal.getElementoId()).style(Style.style(Color.cyan)),
                        new LabelElement(metal.getAbreviatura()).style(Style.style(Color.green)),
                        new LabelElement(metal.getEtiqueta()).style(Style.style(Color.yellow)),
                        new LabelElement(metal.getConfiguracion().getId().toString())
                );

                context.provide(new LabelElement("\nEl elemento agregado es:\n"));
                context.provide(table);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
