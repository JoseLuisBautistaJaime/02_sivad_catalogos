/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package commands

import mx.com.nmp.ms.sivad.catalogo.domain.Corte
import mx.com.nmp.ms.sivad.catalogo.domain.SubCorte
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException
import mx.com.nmp.ms.sivad.catalogo.service.SubCorteService
import org.crsh.cli.Argument
import org.crsh.cli.Command
import org.crsh.cli.Option
import org.crsh.cli.Required
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext
import org.crsh.text.ui.UIBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.dao.DataIntegrityViolationException

/**
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Usage("Administraci\u00f3n del cat\u00e1logo Sub Corte")
class SubCorteCommand {
    Logger LOGGER = LoggerFactory.getLogger(SubCorteCommand.class)

    @Command
    @Usage("Permite recuperar todos los elementos del cat\u00e1logo")
    def elementos(InvocationContext context) {
        def catalogo = getServicio(context).getAll()

        if (catalogo) {
            mostrarTablaResultados(catalogo)
        } else {
            "El cat\u00e1logo no contiene elementos."
        }
    }

    @Command
    @Usage("Permite recuperar el elemento del cat\u00e1logo que coincida con la abreviatura indicada")
    def elemento(InvocationContext context,
                 @Usage("Abreviatura del elemento a recuperar")
                 @Required @Argument String abreviatura) {
        def catalogo = getServicio(context).getOne(abreviatura)

        if (catalogo) {
            mostrarTablaResultados(catalogo)
        } else {
            "El elemento del cat\u00e1logo con abreviatura [${abreviatura}] no existe."
        }
    }

    @Command
    @Usage("Permite agregar un nuevo elemento al cat\u00e1logo")
    def agregar(InvocationContext context,
                @Usage("Abreviatura") @Required @Option(names = ["a", "abreviatura"]) String abreviatura,
                @Usage("Etiqueta") @Required @Option(names = ["e", "etiqueta"]) String etiqueta,
                @Usage("Abreviatura Padre") @Required @Option(names = ["p", "padre"]) String padre) {
        def sc = new SubCorte([abreviatura: abreviatura, etiqueta: etiqueta])

        try {
            def elemento = getServicio(context).save(sc, padre)
            out.println("El elemento con abreviatura [${abreviatura}] fue agregado correctamente al cat\u00e1logo.")
            mostrarTablaResultados([elemento])
        } catch (CatalogoNotFoundException e) {
            LOGGER.error("Ocurri\u00f3 un error al guardar el elemento", e)
            "El padre con abreviatura [${padre}] no existe."
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("Ocurri\u00f3 un error al guardar el elemento", e)
            "Ya existe un elemento del cat\u00e1logo con abreviatura [${abreviatura}]."
        } catch (Exception e) {
            LOGGER.error("Ocurri\u00f3 un error al guardar el elemento", e)
            "Ocurri\u00f3 un error al guardar el elemento TipoPrenda(${abreviatura}, ${etiqueta})."
        }
    }

    @Command
    @Usage("Permite actualizar un elemento del cat\u00e1logo")
    def modificar(InvocationContext context,
                  @Usage("Abreviatura actual del elemento a actualizar")
                  @Required @Option(names = ["i", "abreviaturaActual"]) String abrAnterior,
                  @Usage("Abreviatura") @Option(names = ["a", "abreviatura"]) String abreviatura,
                  @Usage("Etiqueta") @Option(names = ["e", "etiqueta"]) String etiqueta,
                  @Usage("Abreviatura Padre") @Option(names = ["p", "padre"]) String padre) {
        if (!(abreviatura?.trim() || etiqueta?.trim() || padre?.trim())) {
            out.println("Se requiere al menos uno de los atributos ([a, abreviatura], [e, etiqueta] o [p, padre]) " +
                "para realizar la actualizaci\u00f3n.")
            return
        }

        def sc = new SubCorte([abreviatura: abreviatura, etiqueta: etiqueta])

        try {
            def elemento = getServicio(context).update(sc, abrAnterior, padre?.trim())
            out.println("El elemento con abreviatura [" + abrAnterior + "] ha sido modificado.")
            mostrarTablaResultados([elemento])
        } catch (CatalogoNotFoundException e) {
            LOGGER.error("Ocurri\u00f3 un error al actualizar el elemento", e)
            String msj = SubCorte.isAssignableFrom(e.entidad) ? 'elemento del cat\u00e1logo' : 'padre';
            String abr = SubCorte.isAssignableFrom(e.entidad) ? abrAnterior : padre;
            "El $msj con abreviatura [$abr] no existe."
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("Ocurri\u00f3 un error al actualizar el elemento", e)
            "Ya existe un elemento del cat\u00e1logo con abreviatura [${abreviatura}]."
        } catch (Exception e) {
            LOGGER.error("Ocurri\u00f3 un error al actualizar el elemento", e)
            "Ocurri\u00f3 un error al actualizar el elemento TipoPrenda(${abreviatura}, ${etiqueta})."
        }
    }

    @Command
    @Usage("Permite eliminar un elemento del cat\u00e1logo")
    def eliminar(InvocationContext context,
                 @Usage("Abreviatura del elemento a eliminar")
                 @Required @Argument String abreviatura) {
        try {
            getServicio(context).delete(abreviatura)
            out.println("El elemento con abreviatura [${abreviatura}] fue eliminado correctamente del cat\u00e1logo.")
        } catch (CatalogoNotFoundException e) {
            LOGGER.error("Ocurri\u00f3 un error al eliminar el elemento", e)
            "El elemento del cat\u00e1logo con abreviatura [${abreviatura}] no existe."
        } catch (Exception e) {
            LOGGER.error("Ocurri\u00f3 un error al eliminar el elemento", e)
            "Ocurri\u00f3 un error al eliminar el elemento con abreviatura: ${abreviatura}"
        }
    }

    /**
     * Genera la tabla para mostrar los resultados.
     *
     * @param elementos Elementos a incluir en la tabla
     *
     * @return Tabla a mostrar con los elementos
     */
    private def mostrarTablaResultados(elementos) {
        Map<Corte, List<SubCorte>> map = [:]

        elementos.each { elemento ->
            if (!map[elemento.padre]) {
                map[elemento.padre] = []
            }

            map[elemento.padre] << elemento
        }

        new UIBuilder().table(columns: [1, 3, 5], separator: dashed, rightCellPadding: 1) {
            header(decoration: bold, foreground: black, background: white) {
                label('Corte')
                label('Sub Corte')
                label('')
            }

            map.eachWithIndex { Map.Entry<Corte, List<SubCorte>> entry ->
                header {
                    label(entry.key.abreviatura, foreground: cyan)

                    table(separator: dashed, rightCellPadding: 1) {
                        header(decoration: bold, foreground: black, background: white) {
                            label('Abreviatura')
                            label('Etiqueta')
                        }
                        entry.value.each { elemento ->
                            row {
                                label(elemento.abreviatura, foreground: green)
                                label(elemento.etiqueta, foreground: yellow)
                            }
                        }
                    }

                    label('')
                }
            }
        }
    }

    /**
     * Regresa el servicio a utilizar segun el valor el contexto
     *
     * @return Servicio a utilizar.
     */
    private static SubCorteService getServicio(InvocationContext context) {
        context.attributes['spring.beanfactory'].getBean(SubCorteService)
    }
}
