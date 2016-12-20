package commands;

import mx.com.nmp.ms.sivad.catalogo.domain.RangoOro;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.service.RangoOroService;
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

@Usage("Administraci\u00f3n del cat\u00e1logo Rango Oro")
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
     * Crea el header de la tabla con los elementos.
     *
     * @return TableElement
     */
    private TableElement getTable() {
        TableElement table = new TableElement()
                .overflow(Overflow.HIDDEN);
        table.header(
            new LabelElement("Abreviatura ").style(Style.style(Decoration.bold).foreground(Color.black).background(Color.white)),
            new LabelElement("Etiqueta ").style(Style.style(Decoration.bold).foreground(Color.black).background(Color.white))
        );

        return table;
    }

    /**
     * Modifica un elemento del catalogo.
     *
     * @param context
     * @param abreviaturaActual abreviatura del elemento que sera modificado.
     * @param abreviatura nueva abreviatura que sera asignada al elemento.
     * @param etiqueta nueva etiqueta que sera asignada al elemento.
     */
    @Command
    @Usage("Permite actualizar un elemento del cat\u00e1logo")
    public void modificar(InvocationContext<Object> context,
                          @Usage("Abreviatura actual del elemento a actualizar") @Required @Option(names = {"i", "abreviaturaActual"}) String abreviaturaActual,
                          @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                          @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta) throws Exception {

        if (ObjectUtils.isEmpty(abreviatura) && ObjectUtils.isEmpty(etiqueta)) {
            context.provide(new LabelElement("Se requiere al menos uno de los atributos ([a, abreviatura] o [e, etiqueta]) para realizar la actualizaci\u00f3n."));
        } else {
            try {
                RangoOro rangoOro = new RangoOro();
                rangoOro.setAbreviatura(abreviatura);
                rangoOro.setEtiqueta(etiqueta);
                rangoOro = this.getController().saveAndFlush(rangoOro, abreviaturaActual);

                table = getTable();

                table.row(
                    new LabelElement(rangoOro.getAbreviatura()).style(Style.style(Color.green)),
                    new LabelElement(rangoOro.getEtiqueta()).style(Style.style(Color.yellow))
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

    /**
     * Obtiene los elementos del catalogo.
     *
     * @param context
     */
    @Command
    @Usage("Permite recuperar todos los elementos del cat\u00e1logo")
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
                context.provide(new LabelElement("El cat\u00e1logo no contiene elementos."));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Obtiene el elemento del catalogo.
     *
     * @param context
     * @param abreviatura abreviatura de elemento a mostrar.
     */
    @Command
    @Usage("Permite recuperar el elemento del cat\u00e1logo que coincida con la abreviatura indicada")
    public void elemento(InvocationContext<Object> context,
                         @Usage("Abreviatura del elemento a recuperar") @Required @Argument String abreviatura) throws Exception {
        try {
            RangoOro rangoOro = this.getController().get(abreviatura);

            table = getTable();
            table.row(
                new LabelElement(rangoOro.getAbreviatura()).style(Style.style(Color.green)),
                new LabelElement(rangoOro.getEtiqueta()).style(Style.style(Color.yellow))
            );
            context.provide(table);
        } catch (CatalogoNotFoundException e) {
            context.provide(new LabelElement("El elemento del cat\u00e1ogo con abreviatura [" + abreviatura + "] no existe."));
        } catch (Exception e) {
            context.provide("Ocurrio una error al realizar la operaci\u00f3n.");
        }
    }

    /**
     * Elimina elemento del catalogo por identificador.
     *
     * @param abreviatura abreviatura de elemento a eliminar.
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
     * Agrega elemento de catalogo de tipo RangoOro.
     * @param context
     * @param abreviatura
     * @param etiqueta
     */
    @Command
    @Usage("Permite agregar un nuevo elemento al cat\u00e1logo")
    public void agregar(InvocationContext<Object> context,
                        @Usage("Abreviatura") @Required @Option(names = {"a", "abreviatura"}) String abreviatura,
                        @Usage("Etiqueta") @Required @Option(names = {"e", "etiqueta"}) String etiqueta) throws Exception {
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

            context.provide(new LabelElement("El elemento con abreviatura [" + abreviatura + "] fue agregado correctamente al cat\u00e1logo."));
            context.provide(table);
        } catch (DataIntegrityViolationException e) {
            context.provide(new LabelElement("Ya existe un elemento del cat\u00e1logo con abreviatura [" + abreviatura + "]."));
        } catch (Exception e) {
            context.provide("Ocurrio una error al realizar la operaci\u00f3n.");
        }
    }
}
