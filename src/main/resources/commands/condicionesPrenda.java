package commands;

import mx.com.nmp.ms.sivad.catalogo.domain.CondicionPrenda;
import mx.com.nmp.ms.sivad.catalogo.service.CondicionPrendaService;
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

@Usage("Administra operaciones del catalogo CondicionPrenda.")
public class condicionesPrenda extends BaseCommand {

    private TableElement table;

    /**
     * Obtiene el bean del contexto de spring para interarctuar con el API, clase CondicionPrendaService
     *
     * @return
     */
    private CondicionPrendaService getController() {
        BeanFactory factory = (BeanFactory) this.context.getAttributes().get("spring.beanfactory");
        return (CondicionPrendaService) factory.getBean(CondicionPrendaService.class);
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
    @Usage("Modifica los datos del elemento del catalogo Condicion de Prenda especidifcado por una ID")
    public void modificar(InvocationContext<Object> context,
                          @Usage("id") @Required @Option(names = {"id", "modificar"}) String modificar,
                          @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                          @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta,
                          @Usage("ID ConfiguraciÃ³n.") @Required @Option(names = {"c", "configuracion"}) String configuracion) {

        try {

            CondicionPrenda condicionPrenda = this.getController().findOne(Long.parseLong(modificar));

            condicionPrenda.setAbreviatura(abreviatura);
            condicionPrenda.setEtiqueta(etiqueta);
            condicionPrenda.setConfiguracion(this.getControllerConfig().findOne((Long.parseLong(configuracion))));

            this.getController().saveAndFlush(condicionPrenda);

            table = getTable();

            table.row(
                    new LabelElement(condicionPrenda.getElementoId()).style(Style.style(Color.cyan)),
                    new LabelElement(condicionPrenda.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(condicionPrenda.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(condicionPrenda.getConfiguracion().getId().toString())
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
    @Usage("Muestra los elementos del catalogo CondicionPrenda.")
    public void elementos(InvocationContext<Object> context) {

        try {
            List<CondicionPrenda> lstCondicionPrenda = this.getController().findAll();

            table = getTable();

            for (CondicionPrenda condicionPrenda : lstCondicionPrenda){
                table.row(
                        new LabelElement(condicionPrenda.getElementoId()).style(Style.style(Color.cyan)),
                        new LabelElement(condicionPrenda.getAbreviatura()).style(Style.style(Color.green)),
                        new LabelElement(condicionPrenda.getEtiqueta()).style(Style.style(Color.yellow)),
                        new LabelElement(condicionPrenda.getConfiguracion().getId().toString())
                );
            }

            context.provide(new LabelElement("\nElementos del catalogo Condicion de Prenda:\n"));
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
    @Usage("Muestra un elemento del catalogo CondicionPrenda.")
    public void elemento(InvocationContext<Object> context,
                         @Usage("identificador ddel elemento.") @Required @Argument String id) {

        try {
            CondicionPrenda condicionPrenda = this.getController().findOne(Long.parseLong(id));

            table = getTable();

            table.row(
                    new LabelElement(condicionPrenda.getElementoId()).style(Style.style(Color.cyan)),
                    new LabelElement(condicionPrenda.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(condicionPrenda.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(condicionPrenda.getConfiguracion().getId().toString())
            );

            context.provide(new LabelElement("\nElemento del catalogo Condicion de Prenda:\n"));
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
    @Usage("Eliminar un elemento del catalogo CondicionPrenda especificado por ID.")
    public String eliminar(
            @Usage("identificador de la entrada del cat\u00E1logo.")
            @Required
            @Argument String id) {

        this.getController().delete(Long.parseLong(id));

        return "El elemento con ID " + id + " fue eliminado exitosamente!";
    }


    /**
     * Agrega elemento de catálogo de tipo CondicionPrenda.
     * @param context
     * @param abreviatura
     * @param etiqueta
     * @param configuracion
     */
    @Command
    @Usage("Agrega un elemento al catalogo de tipo CondicionPrenda.")
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
            CondicionPrenda condicionPrenda = new CondicionPrenda();

            condicionPrenda.setAbreviatura(abreviatura);
            condicionPrenda.setEtiqueta(etiqueta);
            condicionPrenda.setConfiguracion(this.getControllerConfig().findOne((Long.parseLong(configuracion))));

            this.getController().save(condicionPrenda);

            table = getTable();

            table.row(
                    new LabelElement(condicionPrenda.getElementoId()).style(Style.style(Color.cyan)),
                    new LabelElement(condicionPrenda.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(condicionPrenda.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(condicionPrenda.getConfiguracion().getId().toString())
            );

            context.provide(new LabelElement("\nEl elemento agregado es:\n"));
            context.provide(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
