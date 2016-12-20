/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package commands

import mx.com.nmp.ms.sivad.catalogo.domain.GradoColor
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException
import mx.com.nmp.ms.sivad.catalogo.service.GradoColorService
import org.crsh.cli.Argument
import org.crsh.cli.Command
import org.crsh.cli.Option
import org.crsh.cli.Required
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext
import org.crsh.text.ui.Overflow
import org.crsh.text.ui.UIBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.util.ObjectUtils

/**
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Usage("Administración del catálogo Color")
class color {
    Logger LOGGER = LoggerFactory.getLogger(color.class)

    @Usage("Permite recuperar todos los elementos del catálogo.")
    @Command
    def elementos(InvocationContext context) {
        def catalogo = getServicio(context).getAll()

        if (catalogo) {
            mostrarTablaResultados(catalogo)
        } else {
            out.println("El catálogo no contiene elementos.")
        }
    }

    @Usage("Permite recuperar el elemento del catálogo que coincida con la abreviatura indicada")
    @Command
    def elemento(InvocationContext context,
                 @Usage("Abreviatura del elemento a recuperar")
                 @Required @Argument String abreviatura) {
        def catalogo = getServicio(context).getOne(abreviatura)

        if (catalogo) {
            mostrarTablaResultados(catalogo)
        } else {
            out.println("El elemento del catálogo con abreviatura [${abreviatura}] no existe.")
        }
    }

    @Usage("Permite agregar un nuevo elemento al catálogo")
    @Command
    def agregar(InvocationContext context,
                @Usage("Abreviatura") @Required @Option(names = ["a", "abreviatura"]) String abreviatura,
                @Usage("Etiqueta") @Required @Option(names = ["e", "etiqueta"]) String etiqueta) {
        def gc = new GradoColor([abreviatura: abreviatura, etiqueta: etiqueta])

        try {
            def elemento = getServicio(context).save(gc)
            out.println("El elemento con abreviatura [${abreviatura}] fue agregado correctamente al catálogo.")
            mostrarTablaResultados([elemento])
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("Ocurrió un error al guardar el elemento", e)
            out.println("Ya existe un elemento del cat\u00e1logo con abreviatura [${abreviatura}].")
        } catch (Exception e) {
            LOGGER.error("Ocurrió un error al guardar el elemento", e)
            out.println("Ocurrió un error al guardar el elemento GradoColor(${abreviatura}, ${etiqueta}).")
        }
    }

    @Usage("Permite actualizar un elemento del catálogo")
    @Command
    def modificar(InvocationContext context,
                  @Usage("Abreviatura actual del elemento a actualizar")
                  @Required @Option(names = ["i", "abreviaturaActual"]) String abrAnterior,
                  @Usage("Abreviatura") @Option(names = ["a", "abreviatura"]) String abreviatura,
                  @Usage("Etiqueta") @Option(names = ["e", "etiqueta"]) String etiqueta) {
        if (ObjectUtils.isEmpty(abreviatura) && ObjectUtils.isEmpty(etiqueta)) {
            out.println("Se requiere al menos uno de los atributos ([a, abreviatura] o [e, etiqueta]) " +
                "para realizar la actualización.")
            return
        }

        def gc = new GradoColor([abreviatura: abreviatura, etiqueta: etiqueta])

        try {
            def elemento = getServicio(context).update(gc, abrAnterior)
            out.println("El elemento con abreviatura [" + abrAnterior + "] ha sido modificado.")
            mostrarTablaResultados([elemento])
        } catch (CatalogoNotFoundException e) {
            LOGGER.error("Ocurrió un error al actualizar el elemento", e)
            out.println("El elemento del catálogo con abreviatura [${abrAnterior}] no existe.")
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("Ocurrió un error al actualizar el elemento", e)
            out.println("Ya existe un elemento del cat\u00e1logo con abreviatura [${abreviatura}].")
        } catch (Exception e) {
            LOGGER.error("Ocurrió un error al actualizar el elemento", e)
            out.println("Ocurrió un error al actualizar el elemento GradoColor(${abreviatura}, ${etiqueta}).")
        }
    }

    @Usage("Permite eliminar un elemento del catálogo.")
    @Command
    def eliminar(InvocationContext context,
                 @Usage("Abreviatura del elemento a eliminar")
                 @Required @Argument String abreviatura) {
        try {
            getServicio(context).delete(abreviatura)
            out.println("El elemento con abreviatura [${abreviatura}] fue eliminado correctamente del cat\u00e1logo.")
        } catch (CatalogoNotFoundException e) {
            LOGGER.error("Ocurrió un error al eliminar el elemento", e)
            out.println("El elemento del cat\u00e1logo con abreviatura [${abreviatura}] no existe.")
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("Ocurrió un error al eliminar el elemento", e)
            out.println("""Ocurrió un error al eliminar el elemento abreviatura: ${abreviatura}
Violación de integridad referencial.
Existen referencias a éste elemento en el catálogo Color Familia 1.""")
        } catch (Exception e) {
            LOGGER.error("Ocurrió un error al eliminar el elemento", e)
            out.println("Ocurrió un error al eliminar el elemento con abreviatura: ${abreviatura}")
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
        new UIBuilder().table(separator: dashed, overflow: Overflow.HIDDEN, rightCellPadding: 1) {
            header(decoration: bold, foreground: black, background: white) {
                label('Abreviatura')
                label('Etiqueta')
            }

            elementos.each { elemento ->
                row {
                    label(elemento.abreviatura, foreground: green)
                    label(elemento.etiqueta, foreground: yellow)
                }
            }
        }
    }

    /**
     * Regresa el servicio a utilizar segun el valor el contexto
     *
     * @return Servicio a utilizar.
     */
    private static GradoColorService getServicio(InvocationContext context) {
        context.attributes['spring.beanfactory'].getBean(GradoColorService)
    }
}
