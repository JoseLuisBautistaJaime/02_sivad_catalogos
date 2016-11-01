package commands;

import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.MotivoBajaPrestamo;
import mx.com.nmp.ms.sivad.catalogo.service.ConfiguracionCatalogoService;
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
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Usage("Administra operaciones del catalogo Motivos de Baja de Prestamo.")
public class motivosBajaPres extends BaseCommand {

    private TableElement table;

    /**
     * Obtiene el bean del contexto de spring para interarctuar con el API, clase MotivoBajaPrestamoService
     *
     * @return
     */
    private MotivoBajaPrestamoService getController() {
        BeanFactory factory = (BeanFactory) this.context.getAttributes().get("spring.beanfactory");
        return (MotivoBajaPrestamoService) factory.getBean(MotivoBajaPrestamoService.class);
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
     * Crea el header de la tabla.
     *
     * @return Tabla
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
     * Elimina elemento del catálogo por identificador.
     *
     * @param id identificador de elemento a eliminar.
     * @return String.
     */
    @Command
    @Usage("Elimina un elemento del catalogo CondicionPrenda especificado por ID.")
    public String eliminar(
            @Usage("identificador del elemento del catalogo.")
            @Required
            @Argument String id) {

        this.getController().delete(Long.parseLong(id));

        return "El elemento con ID " + id + " fue eliminado exitosamente!";
    }

    /**
     * Agrega elemento de catálogo de tipo CondicionPrenda.
     * @param context
     * @param abreviatura Abreviatura del elemento
     * @param etiqueta Etiqueta del elemento
     * @param configuracion Configuracion del elemento.
     */
    @Command
    @Usage("Agrega un elemento al catalogo.")
    public void agregar(InvocationContext<Object> context,
                        @Usage("Abreviatura")
                        @Required
                        @Option(names = {"a", "abreviatura"})
                        String abreviatura,
                        @Usage("Etiqueta")
                        @Required
                        @Option(names = {"e", "etiqueta"})
                        String etiqueta,
                        @Usage("ID ConfiguraciÃ³n.")
                        @Required
                        @Option(names = {"c", "configuracion"})
                        String configuracion) {

        MotivoBajaPrestamo motivoBaja = new MotivoBajaPrestamo();

        try {
            motivoBaja.setAbreviatura(abreviatura);
            motivoBaja.setEtiqueta(etiqueta);
            motivoBaja.setConfiguracion(this.getControllerConfig().findOne((Long.parseLong(configuracion))));

            this.getController().save(motivoBaja);

            table = getTable();

            table.row(
                    new LabelElement(motivoBaja.getElementoId()).style(Style.style(Color.cyan)),
                    new LabelElement(motivoBaja.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(motivoBaja.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(motivoBaja.getConfiguracion().getId().toString())
            );

            context.provide(new LabelElement("\nEl elemento agregado es:\n"));
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
    @Usage("Muestra los elementos del catalogo Motivo de Baja de Prestamo.")
    public void elementos(InvocationContext<Object> context) {

        try {
            List<MotivoBajaPrestamo> lstMotivoBaja = this.getController().findAll();

            table = getTable();

            for (MotivoBajaPrestamo motivoBaja : lstMotivoBaja){
                table.row(
                        new LabelElement(motivoBaja.getElementoId()).style(Style.style(Color.cyan)),
                        new LabelElement(motivoBaja.getAbreviatura()).style(Style.style(Color.green)),
                        new LabelElement(motivoBaja.getEtiqueta()).style(Style.style(Color.yellow)),
                        new LabelElement(motivoBaja.getConfiguracion().getId().toString())
                );
            }

            context.provide(new LabelElement("\nElementos del catalogo Motivo Baja :\n"));
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
    @Usage("Muestra un elemento del catalogo Motivo Baja de Prestamo.")
    public void elemento(InvocationContext<Object> context,
                         @Usage("identificador ddel elemento.") @Required @Argument String id) {

        try {
            MotivoBajaPrestamo motBajaPrestamo = this.getController().findOne(Long.parseLong(id));

            table = getTable();

            table.row(
                    new LabelElement(motBajaPrestamo.getElementoId()).style(Style.style(Color.cyan)),
                    new LabelElement(motBajaPrestamo.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(motBajaPrestamo.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(motBajaPrestamo.getConfiguracion().getId().toString())
            );

            context.provide(new LabelElement("\nElemento del catalogo Motivo baja de Prestamo:\n"));
            context.provide(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
    @Usage("Modifica los datos del elemento del catalogo Motivo de Baja de Prestamo especidifcado por un ID")
    public void modificar(InvocationContext<Object> context,
                          @Usage("id") @Required @Option(names = {"m", "modificar"}) String modificar,
                          @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                          @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta,
                          @Usage("ID ConfiguraciÃ³n.") @Required @Option(names = {"c", "configuracion"}) String configuracion) {

        try {

            MotivoBajaPrestamo motivoBaja = this.getController().findOne(Long.parseLong(modificar));

            motivoBaja.setAbreviatura(abreviatura);
            motivoBaja.setEtiqueta(etiqueta);
            motivoBaja.setConfiguracion(this.getControllerConfig().findOne((Long.parseLong(configuracion))));

            this.getController().saveAndFlush(motivoBaja);

            table = getTable();

            table.row(
                    new LabelElement(motivoBaja.getElementoId()).style(Style.style(Color.cyan)),
                    new LabelElement(motivoBaja.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(motivoBaja.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(motivoBaja.getConfiguracion().getId().toString())
            );

            context.provide(new LabelElement("\nEl elemento modificado es:\n"));
            context.provide(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
