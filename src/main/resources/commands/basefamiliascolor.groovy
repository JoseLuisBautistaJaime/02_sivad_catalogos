package commands

import mx.com.nmp.ms.sivad.catalogo.domain.BaseColor
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException
import mx.com.nmp.ms.sivad.catalogo.service.BaseFamiliasColorService
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

@Usage("Agrupa la funcionalidad en común para los catálogos familias de color.")
abstract class basefamiliascolor<T extends BaseColor> {
    Logger LOGGER = LoggerFactory.getLogger(basefamiliascolor.class)

    @Usage("Permite recuperar todos los elementos del catálogo.")
    @Command
    def elementos(InvocationContext context) {
        def catalogo = getServicio(context).getAllWithoutDependencies()

        if (catalogo) {
            mostrarTablaResultados(catalogo.elementos)
        } else {
            "El catálogo no contiene elementos."
        }
    }

    @Usage("Recupera todos los elementos del catálogo")
    @Command
    def elemento(InvocationContext context,
                 @Usage("Abreviatura del elemento a recuperar.")
                 @Required @Argument String abreviatura) {
        def catalogo = getServicio(context).getOne(abreviatura)

        if (catalogo) {
            mostrarTablaResultados(catalogo.elementos)
        } else {
            "El elemento del catálogo con Abreviatura ${abreviatura} no existe."
        }
    }

    @Usage("Permite agregar un elemento nuevo al catálogo.")
    @Command
    def agregar(InvocationContext context,
                @Usage("Abreviatura") @Required @Option(names = ["a", "abreviatura"]) String abreviatura,
                @Usage("Etiqueta") @Required @Option(names = ["e", "etiqueta"]) String etiqueta) {
        def tp = getGenericClass().newInstance([abreviatura: abreviatura, etiqueta: etiqueta])

        try {
            def elemento = getServicio(context).save(tp)
            out.println("El elemeto fue agregado correctamente al catálogo.")
            mostrarTablaResultados([elemento])
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("Ocurrió un error al guardar el elemento", e)
            """Ocurrió un error al guardar el elemento ${getGenericClass().simpleName}(${abreviatura}, ${etiqueta}).
               No se cumplió con la restricción ${getGenericClass().simpleName}.abreviatura única.
               La abreviatura ${abreviatura} ya existe."""
        } catch (Exception e) {
            LOGGER.error("Ocurrió un error al guardar el elemento", e)
            "Ocurrió un error al guardar el elemento ${getGenericClass().simpleName}(${abreviatura}, ${etiqueta})."
        }
    }

    @Usage("Permite modificar un elemento del catálogo.")
    @Command
    def modificar(InvocationContext context,
                  @Usage("Abreviatura del elemento que se quiere actualizar")
                  @Required @Option(names = ["i", "abrAnterior"]) String abrAnterior,
                  @Usage("Abreviatura") @Option(names = ["a", "abreviatura"]) String abreviatura,
                  @Usage("Etiqueta") @Option(names = ["e", "etiqueta"]) String etiqueta) {
        def tp = getGenericClass().newInstance([abreviatura: abreviatura, etiqueta: etiqueta])

        try {
            def elemento = getServicio(context).update(tp, abrAnterior)
            out.println("El elemeto fue modificado correctamente.")
            mostrarTablaResultados([elemento])
        } catch (CatalogoNotFoundException e) {
            LOGGER.error("Ocurrió un error al actualizar el elemento", e)
            "El elemento con abreviatura ${abrAnterior} no existe."
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("Ocurrió un error al actualizar el elemento", e)
            """Ocurrió un error al actualizar el elemento ${getGenericClass().simpleName}(${abreviatura}, ${etiqueta}).
               No se cumplió con la restricción ${getGenericClass().simpleName}.abreviatura única.
               La abreviatura ${abreviatura} ya existe."""
        } catch (Exception e) {
            LOGGER.error("Ocurrió un error al actualizar el elemento", e)
            "Ocurrió un error al actualizar el elemento ${getGenericClass().simpleName}(${abreviatura}, ${etiqueta})."
        }
    }

    @Usage("Permite eliminar un elemento del catálogo.")
    @Command
    def eliminar(InvocationContext context,
                 @Usage("Abreviatura del elemento a recuperar.")
                 @Required @Argument String abreviatura) {
        try {
            def elemento = getServicio(context).delete(abreviatura)
            out.println("El elemeto fue eliminado correctamente.")
            mostrarTablaResultados([elemento])
        } catch (CatalogoNotFoundException e) {
            LOGGER.error("Ocurrió un error al eliminar el elemento", e)
            "El elemento con abreviatura ${abreviatura} no existe."
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("Ocurrió un error al eliminar el elemento", e)
            """Ocurrió un error al eliminar el elemento con abreviatura: ${abreviatura}
               Violación de integridad referencial.
               Existen referencias a éste elemento del catálogo."""
        } catch (Exception e) {
            LOGGER.error("Ocurrió un error al eliminar el elemento", e)
            "Ocurrió un error al eliminar el elemento con abreviatura: ${abreviatura}"
        }
    }

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

    protected abstract BaseFamiliasColorService getServicio(InvocationContext context)

    private Class<T> getGenericClass() {
        (Class<T>) getClass().getGenericSuperclass().getActualTypeArguments()[0]
    }
}
