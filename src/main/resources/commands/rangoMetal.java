package commands;

import mx.com.nmp.ms.sivad.catalogo.domain.RangoMetal;
import mx.com.nmp.ms.sivad.catalogo.service.RangoMetalService;
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

@Usage("Administra operaciones del catalogo RangoMetal.")
public class rangoMetal extends BaseCommand {

    private TableElement table;

    /**
     * Obtiene el bean del contexto de spring para interarctuar con el API, clase RangoMetalService
     *
     * @return
     */
    private RangoMetalService getController() {
        BeanFactory factory = (BeanFactory) this.context.getAttributes().get("spring.beanfactory");
        return (RangoMetalService) factory.getBean(RangoMetalService.class);
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
     * @param context
     * @param id identificador del elemento que sera eliminado.
     * @param abreviatura nueva abreviatura que sera asignada al elemento.
     * @param etiqueta nueva etiqueta que sera asignada al elemento.
     * @param configuracion nueva configuración que sera asignada al elemento.
     */
    @Command
    @Usage("Modifica los datos del elemento del catalogo Rango Metal especidifcado por una ID")
    public void modificar(InvocationContext<Object> context,
                          @Usage("id") @Required @Option(names = {"m", "modificar"}) String modificar,
                          @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                          @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta,
                          @Usage("ID ConfiguraciÃ³n.") @Required @Option(names = {"c", "configuracion"}) String configuracion) {

        try {

            RangoMetal rangoMetal = this.getController().findOne(Long.parseLong(modificar));

            rangoMetal.setAbreviatura(abreviatura);
            rangoMetal.setEtiqueta(etiqueta);
            rangoMetal.setConfiguracion(this.getControllerConfig().findOne((Long.parseLong(configuracion))));

            this.getController().saveAndFlush(rangoMetal);

            table = getTable();

            table.row(
                    new LabelElement(rangoMetal.getIdElemento()).style(Style.style(Color.cyan)),
                    new LabelElement(rangoMetal.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(rangoMetal.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(rangoMetal.getConfiguracion().getId().toString())
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
    @Usage("Muestra los elementos del catalogo RangoMetal.")
    public void elementos(InvocationContext<Object> context) {

        try {
            List<RangoMetal> lstRangoMetal = this.getController().getAll();

            table = getTable();

            for (RangoMetal rangoMetal : lstRangoMetal){
                table.row(
                        new LabelElement(rangoMetal.getIdElemento()).style(Style.style(Color.cyan)),
                        new LabelElement(rangoMetal.getAbreviatura()).style(Style.style(Color.green)),
                        new LabelElement(rangoMetal.getEtiqueta()).style(Style.style(Color.yellow)),
                        new LabelElement(rangoMetal.getConfiguracion().getId().toString())
                );
            }

            context.provide(new LabelElement("\nElementos del catalogo Rango Metal:\n"));
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
    @Usage("Muestra un elemento del catalogo RangoMetal.")
    public void elemento(InvocationContext<Object> context,
                         @Usage("identificador ddel elemento.") @Required @Argument String id) {

        try {
            RangoMetal rangoMetal = this.getController().findOne(Long.parseLong(id));

            table = getTable();

            table.row(
                    new LabelElement(rangoMetal.getIdElemento()).style(Style.style(Color.cyan)),
                    new LabelElement(rangoMetal.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(rangoMetal.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(rangoMetal.getConfiguracion().getId().toString())
            );

            context.provide(new LabelElement("\nElemento del catalogo Rango Metal:\n"));
            context.provide(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Elimina elemento del catálogo por identificador.
     *
     * @param id identificador de elemento a eliminar.
     * @return String.
     */
    @Command
    @Usage("Eliminar un elemento del catalogo RangoMetal especificado por ID.")
    public String eliminar(
            @Usage("identificador de la entrada del cat\u00E1logo.")
            @Required
            @Argument String id) {

        this.getController().delete(Long.parseLong(id));

        return "El elemento con ID " + id + " fue eliminado exitosamente!";
    }


    /**
     * Agrega elemento de catálogo de tipo RangoMetal.
     * @param context
     * @param abreviatura
     * @param etiqueta
     * @param configuracion
     */
    @Command
    @Usage("Agrega un elemento al catalogo de tipo RangoMetal.")
    public void agregar(InvocationContext<Object> context,
                        @Usage("Abreviatura")
                        @Required
                        @Option(names = {"a", "abreviatura"})
                        String abreviatura,
                        @Usage("Etiqueta")
                        @Required
                        @Option(names = {"e", "etiqueta"})
                        String etiqueta,
                        @Usage("ID Configuración.")
                        @Required
                        @Option(names = {"c", "configuracion"})
                        String configuracion) {


        try {
            RangoMetal rangoMetal = new RangoMetal();

            rangoMetal.setAbreviatura(abreviatura);
            rangoMetal.setEtiqueta(etiqueta);
            rangoMetal.setConfiguracion(this.getControllerConfig().findOne((Long.parseLong(configuracion))));

            this.getController().save(rangoMetal);

            table = getTable();

            table.row(
                    new LabelElement(rangoMetal.getIdElemento()).style(Style.style(Color.cyan)),
                    new LabelElement(rangoMetal.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(rangoMetal.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(rangoMetal.getConfiguracion().getId().toString())
            );

            context.provide(new LabelElement("\nEl elemento agregado es:\n"));
            context.provide(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
