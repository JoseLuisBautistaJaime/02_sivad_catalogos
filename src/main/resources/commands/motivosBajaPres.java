package commands;

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
import org.springframework.beans.factory.BeanFactory;

import java.util.List;

/**
 * Clase que contiene los comandos para ejecutar las operaciones de catalogo mediante SSH.
 */

@Usage("Administra operaciones del cat\u00e1logo Motivos de Baja de Prestamo.")
public class motivosBajaPres extends BaseCommand {

    private TableElement table;

    /**
     * Obtiene el bean del contexto de spring para interarctuar con el API, clase MotivoBajaPrestamo
     *
     * @return MotivoBajaPrestamoService
     */
    private MotivoBajaPrestamoService getController() {
        BeanFactory factory = (BeanFactory) this.context.getAttributes().get("spring.beanfactory");
        return (MotivoBajaPrestamoService) factory.getBean(MotivoBajaPrestamoService.class);
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
     * Elimina elemento del catalogo por identificador.
     *
     * @param id identificador de elemento a eliminar.
     * @return String.
     */
    @Command
    @Usage("Elimina un elemento del cat\u00e1logo por el identificador.")
    public String eliminar(
            @Usage("identificador del elemento.")
            @Required
            @Argument String id) {

        this.getController().delete(Long.parseLong(id));

        return "El elemento con identificador " + id + " fue eliminado exitosamente!";
    }

    /**
     * Agrega elemento de catalogo de tipo CondicionPrenda.
     * @param context contexto del objeto
     * @param abreviatura Abreviatura del elemento
     * @param etiqueta Etiqueta del elemento
     * @param configuracion Configuracion del elemento.
     */
    @Command
    @Usage("Agrega un elemento al cat\u00e1logo.")
    public void agregar(InvocationContext<Object> context,
                        @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                        @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta) {

        try {
            MotivoBajaPrestamo motivoBaja = new MotivoBajaPrestamo();
            motivoBaja.setAbreviatura(abreviatura);
            motivoBaja.setEtiqueta(etiqueta);

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

            for (MotivoBajaPrestamo motivoBaja : lstMotivoBaja){
                table.row(
                        new LabelElement(motivoBaja.getElementoId()).style(Style.style(Color.cyan)),
                        new LabelElement(motivoBaja.getAbreviatura()).style(Style.style(Color.green)),
                        new LabelElement(motivoBaja.getEtiqueta()).style(Style.style(Color.yellow)),
                        new LabelElement(motivoBaja.getConfiguracion().getId().toString())
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
    @Usage("Muestra un elemento del cat\u00e1logo por identificador.")
    public void elemento(InvocationContext<Object> context,
                         @Usage("identificador del elemento.") @Required @Argument String id) {

        try {
            MotivoBajaPrestamo motBajaPrestamo = this.getController().findOne(Long.parseLong(id));

            table = getTable();

            table.row(
                    new LabelElement(motBajaPrestamo.getElementoId()).style(Style.style(Color.cyan)),
                    new LabelElement(motBajaPrestamo.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(motBajaPrestamo.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(motBajaPrestamo.getConfiguracion().getId().toString())
            );

            context.provide(new LabelElement("\nElemento del cat\u00e1logo:\n"));
            context.provide(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Modifica un elemento del catalogo.
     *
     * @param context contexto del objeto.
     * @param id identificador del elemento que sera eliminado.
     * @param abreviatura nueva abreviatura que sera asignada al elemento.
     * @param etiqueta nueva etiqueta que sera asignada al elemento.
     * @param configuracion nueva configuracion que sera asignada al elemento.
     */
    @Command
    @Usage("Modifica los datos de un elemento del catalogo especidifcado por el identificador")
    public void modificar(InvocationContext<Object> context,
                          @Usage("Elemento a Modificar") @Required @Option(names = {"m", "elemento"}) String elemento,
                          @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                          @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta) {
        try {

            MotivoBajaPrestamo motivoBajaModificar = new MotivoBajaPrestamo();

            motivoBajaModificar.setAbreviatura(abreviatura);
            motivoBajaModificar.setEtiqueta(etiqueta);

            MotivoBajaPrestamo motivoBajaPrestamo = this.getController().update(elemento,motivoBajaModificar);

            table = getTable();

            table.row(
                    new LabelElement(motivoBajaPrestamo.getElementoId()).style(Style.style(Color.cyan)),
                    new LabelElement(motivoBajaPrestamo.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(motivoBajaPrestamo.getEtiqueta()).style(Style.style(Color.yellow)),
                    new LabelElement(motivoBajaPrestamo.getConfiguracion().getId().toString())
            );

            context.provide(new LabelElement("\nEl elemento modificado es:\n"));
            context.provide(table);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
