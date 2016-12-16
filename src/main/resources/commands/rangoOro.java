package commands;

import mx.com.nmp.ms.sivad.catalogo.domain.RangoOro;
import mx.com.nmp.ms.sivad.catalogo.service.RangoOroService;
import mx.com.nmp.ms.sivad.catalogo.service.ConfiguracionCatalogoService;
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

@Usage("Administración del catálogo Rango Oro")
public class rangoOro extends BaseCommand {

    private TableElement table;

    /**
     * Obtiene el bean del contexto de spring para interarctuar con el API, clase RangoOroService
     *
     * @return
     */
    private RangoOroService getController() {
        BeanFactory factory = (BeanFactory) this.context.getAttributes().get("spring.beanfactory");
        return (RangoOroService) factory.getBean(RangoOroService.class);
    }

    /**
     * Obtiene el bean del contexto de spring para interarctuar con el API, clase ConfiguracionCatalogoService
     *
     * @return
     */
    private ConfiguracionCatalogoService getControllerConfig() {
        BeanFactory factory = (BeanFactory) this.context.getAttributes().get("spring.beanfactory");
        return (ConfiguracionCatalogoService) factory.getBean(ConfiguracionCatalogoService.class);
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
        table.header(
            new LabelElement("Abreviatura").style(Style.style(Decoration.bold).foreground(Color.black).background(Color.white)),
            new LabelElement("Etiqueta").style(Style.style(Decoration.bold).foreground(Color.black).background(Color.white))
        );

        return table;
    }

    /**
     * Modifica un elemento del catalogo.
     *
     * @param context
     * @param abrAnterior abreviatura del elemento que sera modificado.
     * @param abreviatura nueva abreviatura que sera asignada al elemento.
     * @param etiqueta nueva etiqueta que sera asignada al elemento.
     */
    @Command
    @Usage("Permite actualizar un elemento del catálogo")
    public void modificar(InvocationContext<Object> context,
                          @Usage("Abreviatura actual del elemento a actualizar")
                          @Required @Option(names = {"i", "abrAnterior"}) String abrAnterior,
                          @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                          @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta) {

        try {

            RangoOro rangoOro = new RangoOro();

            rangoOro.setAbreviatura(abreviatura);
            rangoOro.setEtiqueta(etiqueta);
            rangoOro = this.getController().saveAndFlush(rangoOro,abrAnterior);

            table = getTable();

            table.row(
                    new LabelElement(rangoOro.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(rangoOro.getEtiqueta()).style(Style.style(Color.yellow))
            );

            context.provide(new LabelElement("\nEl elemento con abreviatura [" + abrAnterior + "] ha sido modificado."));
            context.provide(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Obtiene los elementos del catálogo.
     *
     * @param context
     */
    @Command
    @Usage("Permite recuperar todos los elementos del catálogo")
    public void elementos(InvocationContext<Object> context) {

        try {
            List<RangoOro> lstRangoOro = this.getController().getAll();

            if (lstRangoOro != null && lstRangoOro.size() > 0) {
                table = getTable();

                for (RangoOro rangoOro : lstRangoOro){
                    table.row(
                            new LabelElement(rangoOro.getAbreviatura()).style(Style.style(Color.green)),
                            new LabelElement(rangoOro.getEtiqueta()).style(Style.style(Color.yellow))
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
     * Obtiene el elemento del catálogo.
     *
     * @param context
     * @param abreviatura abreviatura de elemento a mostrar.
     */
    @Command
    @Usage("Permite recuperar el elemento del catálogo que coincida con la abreviatura indicada")
    public void elemento(InvocationContext<Object> context,
                         @Usage("Abreviatura del elemento a recuperar")
                         @Required @Argument String abreviatura) {

        try {
            RangoOro rangoOro = this.getController().get(abreviatura);

            table = getTable();

            table.row(
                    new LabelElement(rangoOro.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(rangoOro.getEtiqueta()).style(Style.style(Color.yellow))
            );

            context.provide(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Elimina elemento del catálogo por identificador.
     *
     * @param abreviatura abreviatura de elemento a eliminar.
     */
    @Command
    @Usage("Permite eliminar un elemento del catálogo")
    public String eliminar(
            @Usage("Abreviatura del elemento a eliminar")
            @Required
            @Argument String abreviatura) {

        this.getController().delete(abreviatura);

        return "El elemento con abreviatura [" + abreviatura + "] fue eliminado correctamente del catálogo.";
    }

    /**
     * Agrega elemento de catálogo de tipo RangoOro.
     * @param context
     * @param abreviatura
     * @param etiqueta
     */
    @Command
    @Usage("Permite agregar un nuevo elemento al catálogo")
    public void agregar(InvocationContext<Object> context,
                        @Usage("Abreviatura")
                        @Required
                        @Option(names = {"a", "abreviatura"})
                        String abreviatura,
                        @Usage("Etiqueta")
                        @Required
                        @Option(names = {"e", "etiqueta"})
                        String etiqueta) {


        try {
            RangoOro rangoOro = new RangoOro();

            rangoOro.setAbreviatura(abreviatura);
            rangoOro.setEtiqueta(etiqueta);

            rangoOro = this.getController().save(rangoOro);

            table = getTable();

            table.row(
                    new LabelElement(rangoOro.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(rangoOro.getEtiqueta()).style(Style.style(Color.yellow))
            );

            context.provide(new LabelElement("\nEl elemento con abreviatura [" + abreviatura + "] fue agregado correctamente al catálogo."));
            context.provide(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
