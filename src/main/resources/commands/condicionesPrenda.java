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

@Usage("Administra operaciones del cat\u00e1logo Condicion de Prenda.")
public class condicionesPrenda extends BaseCommand {

    private TableElement table;

    /**
     * Obtiene el bean del contexto de spring para interarctuar con el API, clase CondicionPrendaService
     *
     * @return CondicionPrendaService
     */
    private CondicionPrendaService getController() {
        BeanFactory factory = (BeanFactory) this.context.getAttributes().get("spring.beanfactory");
        return (CondicionPrendaService) factory.getBean(CondicionPrendaService.class);
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
     * @param context coontexto del objeto.
     * @param id identificador del elemento que sera eliminado.
     * @param abreviatura nueva abreviatura que sera asignada al elemento.
     * @param etiqueta nueva etiqueta que sera asignada al elemento.
     * @param configuracion nueva configuracion que sera asignada al elemento.
     */
    @Command
    @Usage("Modifica los datos del elemento del cat\u00e1logo mediante la Abreviatura")
    public void modificar(InvocationContext<Object> context,
                          @Usage("Elemento a Modificar") @Required @Option(names = {"m", "elemento"}) String elemento,
                          @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                          @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta) {

        try {

            CondicionPrenda condicionPrendaModificar = new CondicionPrenda();
            condicionPrendaModificar.setAbreviatura(abreviatura);
            condicionPrendaModificar.setEtiqueta(etiqueta);

            CondicionPrenda condicionPrenda = this.getController().update(elemento,condicionPrendaModificar);

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
     * Obtiene los elementos del catalogo.
     *
     * @param context contexto del objeto.
     */
    @Command
    @Usage("Muestra los elementos del cat\u00e1logo.")
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
                         @Usage("Identificador del elemento.") @Required @Argument String id) {

        try {
            CondicionPrenda condicionPrenda = this.getController().findOne(Long.parseLong(id));

            table = getTable();

            table.row(
                    new LabelElement(condicionPrenda.getElementoId()).style(Style.style(Color.cyan)),
                    new LabelElement(condicionPrenda.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(condicionPrenda.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(condicionPrenda.getConfiguracion().getId().toString())
            );

            context.provide(new LabelElement("\nElemento del cat\u00e1logo:\n"));
            context.provide(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Elimina elemento del catalogo por identificador.
     *
     * @param id identificador de elemento a eliminar.
     * @return String.
     */
    @Command
    @Usage("Elimina un elemento del cat\u00e1go por el identificador.")
    public String eliminar(
            @Usage("identificador de la entrada del cat\u00e1logo.")
            @Required
            @Argument String id) {

        this.getController().delete(Long.parseLong(id));

        return "El elemento con identificador " + id + " fue eliminado exitosamente!";
    }


    /**
     * Agrega elemento de catalogo de tipo CondicionPrenda.
     * @param context contexto del objeto.
     * @param abreviatura abreviatura del elemento.
     * @param etiqueta etiqueta del elemento.
     * @param configuracion configuracion del elemento.
     */
    @Command
    @Usage("Agrega un elemento al cat\u00e1logo de tipo CondicionPrenda.")
    public void agregar(InvocationContext<Object> context,
                        @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                        @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta) {
        try {
            CondicionPrenda condicionPrenda = new CondicionPrenda();

            condicionPrenda.setAbreviatura(abreviatura);
            condicionPrenda.setEtiqueta(etiqueta);

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
