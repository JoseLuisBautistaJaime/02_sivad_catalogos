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
@Usage("Administraci\u00f3n del cat\u00e1logo Motivos de Baja de Pr\u00e9stamo")
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
            .overflow(Overflow.HIDDEN);
        table.header(
            new LabelElement("Abreviatura ").style(Style.style(Color.black).background(Color.white)),
            new LabelElement("Etiqueta ").style(Style.style(Color.black).background(Color.white))
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
    @Usage("Permite eliminar un elemento del cat\u00e1logo")
    public String eliminar(
        @Usage("Abreviatura del elemento a eliminar") @Required @Argument String abreviatura) {
        try {
            this.getController().delete(abreviatura);
            return "El elemento con abreviatura [" + abreviatura + "] fue eliminado correctamente del cat\u00e1logo.\n";
        } catch (CatalogoNotFoundException e) {
            return "El elemento del cat\u00e1logo con abreviatura [" + abreviatura + "] no existe.\n";
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
    @Usage("Permite agregar un nuevo elemento al cat\u00e1logo")
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

            context.provide(new LabelElement("El elemento con abreviatura [" + abreviatura + "] fue agregado correctamente al cat\u00e1logo."));
            context.provide(table);
        } catch (DataIntegrityViolationException e) {
            context.provide(new LabelElement("Ya existe un elemento del cat\u00e1logo con abreviatura [" + abreviatura + "]."));
        } catch (Exception e) {
            context.provide("Ocurrio una error al realizar la operaci\u00f3n.");
        }
    }

    /**
     * Obtiene los elementos del catalogo.
     *
     * @param context contexto del objeto
     */
    @Command
    @Usage("Permite recuperar todos los elementos del cat\u00e1logo")
    public void elementos(InvocationContext<Object> context) {

        try {
            List<MotivoBajaPrestamo> lstMotivoBaja = this.getController().findAll();
            if (lstMotivoBaja != null && lstMotivoBaja.size() > 0) {
                table = getTable();
                for (MotivoBajaPrestamo motivoBaja : lstMotivoBaja) {
                    table.row(
                        new LabelElement(motivoBaja.getAbreviatura()).style(Style.style(Color.green)),
                        new LabelElement(motivoBaja.getEtiqueta()).style(Style.style(Color.yellow))
                    );
                }

                context.provide(table);
            } else {
                context.provide(new LabelElement("El cat\u00e1logo no contiene elementos."));
            }
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
    @Usage("Permite recuperar el elemento del cat\u00e1logo que coincida con la abreviatura indicada")
    public void elemento(InvocationContext<Object> context,
                         @Usage("Abreviatura del elemento a recuperar") @Required @Argument String abreviatura) throws Exception {
        try {
            MotivoBajaPrestamo motivoBajaPrestamo = this.getController().obtenerElementoAbreviatura(abreviatura);

            table = getTable();
            table.row(
                new LabelElement(motivoBajaPrestamo.getAbreviatura()).style(Style.style(Color.green)),
                new LabelElement(motivoBajaPrestamo.getEtiqueta()).style(Style.style(Color.yellow))
            );
            context.provide(table);
        } catch (CatalogoNotFoundException e) {
            context.provide(new LabelElement("El elemento del cat\u00e1ogo con abreviatura [" + abreviatura + "] no existe."));
        } catch (Exception e) {
            context.provide("Ocurrio una error al realizar la operaci\u00f3n.");
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
    @Usage("Permite actualizar un elemento del cat\u00e1logo")
    public void modificar(InvocationContext<Object> context,
                          @Usage("Abreviatura actual del elemento a actualizar") @Required @Option(names = {"i", "abreviaturaActual"}) String abreviaturaActual,
                          @Usage("Abreviatura") @Option(names = {"a", "abreviatura"}) String abreviatura,
                          @Usage("Etiqueta") @Option(names = {"e", "etiqueta"}) String etiqueta) throws Exception {

        if (ObjectUtils.isEmpty(abreviatura) && ObjectUtils.isEmpty(etiqueta)) {
            context.provide(new LabelElement("Se requiere al menos uno de los atributos ([a, abreviatura] o [e, etiqueta]) para realizar la actualizaci\u00f3n."));
        } else {
            try {
                MotivoBajaPrestamo motivoBajaPrestamoModif = new MotivoBajaPrestamo();
                motivoBajaPrestamoModif.setAbreviatura(abreviatura);
                motivoBajaPrestamoModif.setEtiqueta(etiqueta);
                MotivoBajaPrestamo motivoBajaPrestamo = this.getController().update(abreviaturaActual, motivoBajaPrestamoModif);

                table = getTable();
                table.row(
                    new LabelElement(motivoBajaPrestamo.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(motivoBajaPrestamo.getEtiqueta()).style(Style.style(Color.yellow))
                );

                context.provide(new LabelElement("El elemento con abreviatura [" + abreviaturaActual + "] ha sido modificado."));
                context.provide(table);
            } catch (CatalogoNotFoundException e) {
                context.provide(new LabelElement("El elemento del cat\u00e1logo con abreviatura [" + abreviaturaActual + "] no existe."));
            } catch (DataIntegrityViolationException e) {
                context.provide(new LabelElement("Ya existe un elemento del cat\u00e1logo con abreviatura [" + abreviatura + "]."));
            }
        }
    }
}
