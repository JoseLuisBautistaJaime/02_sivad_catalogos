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

@Usage("Administra operaciones del catalogo RangoOro.")
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
        table.row(
                new LabelElement("ABREVIATURA").style(Style.style(Decoration.bold)),
                new LabelElement("ETIQUETA").style(Style.style(Decoration.bold)),
                new LabelElement("ID_CONFIGURACION").style(Style.style(Decoration.bold))
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
    @Usage("Modifica los datos del elemento del catalogo Rango Oro especidifcado por una Abreviatura")
    public void modificar(InvocationContext<Object> context,
                          @Usage("Abreviatura del elemento que se quiere actualizar")
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
                    new LabelElement(rangoOro.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(rangoOro.getConfiguracion().getId().toString())
            );

            context.provide(new LabelElement("\nEl elemento modificado es:\n"));
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
    @Usage("Muestra los elementos del catalogo RangoOro.")
    public void elementos(InvocationContext<Object> context) {

        try {
            List<RangoOro> lstRangoOro = this.getController().getAll();

            table = getTable();

            for (RangoOro rangoOro : lstRangoOro){
                table.row(
                        new LabelElement(rangoOro.getAbreviatura()).style(Style.style(Color.green)),
                        new LabelElement(rangoOro.getEtiqueta()).style(Style.style(Color.yellow)),
                        new LabelElement(rangoOro.getConfiguracion().getId().toString())
                );
            }

            context.provide(new LabelElement("\nElementos del catalogo Rango Oro:\n"));
            context.provide(table);
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
    @Usage("Muestra un elemento del catalogo RangoOro.")
    public void elemento(InvocationContext<Object> context,
                         @Usage("Abreviatura del elemento a recuperar.")
                         @Required @Argument String abreviatura) {

        try {
            RangoOro rangoOro = this.getController().get(abreviatura);

            table = getTable();

            table.row(
                    new LabelElement(rangoOro.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(rangoOro.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(rangoOro.getConfiguracion().getId().toString())
            );

            context.provide(new LabelElement("\nElemento del catalogo Rango Oro:\n"));
            context.provide(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Elimina elemento del catálogo por identificador.
     *
     * @param abreviatura abreviatura de elemento a eliminar.
     * @return String.
     */
    @Command
    @Usage("Eliminar un elemento del catalogo RangoOro especificado por ID.")
    public String eliminar(
            @Usage("Abreviatura de la entrada del cat\u00E1logo.")
            @Required
            @Argument String abreviatura) {

        this.getController().delete(abreviatura);

        return "El elemento con Abreviatura " + abreviatura + " fue eliminado exitosamente!";
    }


    /**
     * Agrega elemento de catálogo de tipo RangoOro.
     * @param context
     * @param abreviatura
     * @param etiqueta
     */
    @Command
    @Usage("Agrega un elemento al catalogo de tipo RangoOro.")
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
                    new LabelElement(rangoOro.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(rangoOro.getConfiguracion().getId().toString())
            );

            context.provide(new LabelElement("\nEl elemento agregado es:\n"));
            context.provide(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
