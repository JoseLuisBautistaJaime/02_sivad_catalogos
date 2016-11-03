/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package commands

import mx.com.nmp.ms.sivad.catalogo.domain.QuilatajeOro
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoDuplicateKeyException
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException
import mx.com.nmp.ms.sivad.catalogo.service.QuilatajeOroService
import org.crsh.cli.*
import org.crsh.command.InvocationContext
import org.crsh.text.ui.Overflow
import org.crsh.text.ui.UIBuilder

/**
 * Utilizada por la consola CRaSH para la administración del catálogo Quilataje Oro.
 *
 * @author ngonzalez
 */
@Usage("Administración del catálogo Quilataje Oro")
class cat_quilataje_oro {



    // METODOS

    /**
     * Permite agregar un nuevo elemento al catálogo con base en los parámetros recibidos.
     *
     * @param context El contexto de la invocación.
     * @param abreviatura La abreviatura.
     * @param etiqueta La etiqueta.
     * @return El elemento guardado en caso de éxito o el mensaje correspondiente en caso de fallo.
     */
    @Usage("Permite agregar un nuevo elemento al catálogo")
    @Command
    def agregar(InvocationContext context,
                @Usage("Abreviatura") @Option(names = ["a", "abreviatura"]) @Required String abreviatura,
                @Usage("Etiqueta") @Option(names = ["e", "etiqueta"]) @Required String etiqueta) {
        try {
            def quilatajeOro = new QuilatajeOro([abreviatura: abreviatura, etiqueta: etiqueta])
            def elemento = getServicio(context).save(quilatajeOro)
            out.println("El elemento con abreviatura [${abreviatura}] fue agregado correctamente al catálogo.")
            mostrarTablaResultados([elemento])
        } catch (CatalogoDuplicateKeyException e) {
            out.println("Ya existe un elemento del catálogo con abreviatura [${abreviatura}].")
        }
    }

    /**
     * Permite obtener el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param context El contexto de la invocación.
     * @param abreviatura La abreviatura.
     * @return El elemento del catálogo que coincida con la abreviatura indicada.
     */
    @Usage("Permite recuperar el elemento del catálogo que coincida con la abreviatura indicada")
    @Command
    def elemento(InvocationContext context,
                 @Usage("Abreviatura del elemento a recuperar") @Required @Argument String abreviatura) {
        try {
            def catalogo = getServicio(context).get(abreviatura)
            mostrarTablaResultados(catalogo.elementos)
        } catch (CatalogoNotFoundException e) {
            out.println("El elemento del catálogo con abreviatura [${abreviatura}] no existe.")
        }
    }

    /**
     * Permite obtener todos los elementos del catálogo.
     *
     * @param context El contexto de la invocación.
     * @return Lista de elementos del catálogo.
     */
    @Usage("Permite recuperar todos los elementos del catálogo")
    @Command
    def elementos(InvocationContext context) {
        def catalogo = getServicio(context).getAll();

        if (catalogo) {
            mostrarTablaResultados(catalogo.elementos)
        } else {
            out.println("El catálogo no contiene elementos.")
        }
    }

    /**
     * Permite eliminar el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param context El contexto de la invocación.
     * @param abreviatura La abreviatura.
     * @return El mensaje de éxito o fallo correspondiente.
     */
    @Usage("Permite eliminar un elemento del catálogo")
    @Command
    def eliminar(InvocationContext context,
                 @Usage("Abreviatura del elemento a eliminar") @Required @Argument String abreviatura) {
        try {
            def result = getServicio(context).delete(abreviatura)
            out.println("El elemento con abreviatura [${abreviatura}] fue eliminado correctamente del catálogo.")
        } catch (CatalogoNotFoundException e) {
            out.println("El elemento del catálogo con abreviatura [${abreviatura}] no existe.")
        }
    }

    /**
     * Permite actualizar la abreviatura de un elemento del catálogo.
     *
     * @param context El contexto de la invocación.
     * @param abreviatura La abreviatura actual del elemento a actualizar.
     * @param abreviaturaNueva La nueva abreviatura.
     * @return El elemento actualizado en caso de éxito o el mensaje correspondiente en caso de fallo.
     */
    @Usage("Permite actualizar la abreviatura de un elemento del catálogo")
    @Command
    def modificar_abreviatura(InvocationContext context,
                              @Usage("Abreviatura actual del elemento a actualizar")
                              @Option(names = ["a", "abreviatura"]) @Required String abreviatura,
                              @Usage("Abreviatura nueva")
                              @Option(names = ["an", "abreviaturaNueva"]) @Required String abreviaturaNueva) {
        try {
            def elemento = getServicio(context).updateAbreviatura(abreviatura, abreviaturaNueva)
            out.println("La abreviatura fue actualizada correctamente.")
            mostrarTablaResultados([elemento])
        } catch (CatalogoNotFoundException e) {
            out.println("El elemento del catálogo con abreviatura [${abreviatura}] no existe.")
        } catch (CatalogoDuplicateKeyException e) {
            out.println("Ya existe un elemento del catálogo con abreviatura [${abreviaturaNueva}].")
        }
    }

    /**
     * Permite actualizar la etiqueta de un elemento del catálogo.
     *
     * @param context El contexto de la invocación.
     * @param abreviatura La abreviatura del elemento a actualizar.
     * @param etiquetaNueva La nueva etiqueta.
     * @return El elemento actualizado en caso de éxito o el mensaje correspondiente en caso de fallo.
     */
    @Usage("Permite actualizar la etiqueta de un elemento del catálogo")
    @Command
    def modificar_etiqueta(InvocationContext context,
                           @Usage("Abreviatura del elemento a actualizar")
                           @Option(names = ["a", "abreviatura"]) @Required String abreviatura,
                           @Usage("Etiqueta")
                           @Option(names = ["e", "etiquetaNueva"]) @Required String etiquetaNueva) {
        try {
            def elemento = getServicio(context).updateEtiqueta(abreviatura, etiquetaNueva)
            out.println("La etiqueta fue actualizada correctamente.")
            mostrarTablaResultados([elemento])
        } catch (CatalogoNotFoundException e) {
            out.println("El elemento del catálogo con abreviatura [${abreviatura}] no existe.")
        }
    }

    /**
     * Utilizado para representar los elementos del catálogo en un formato de tabla.
     *
     * @param elementos Lista de elementos del catálogo.
     * @return Despliegue visual en la consola con los elementos del catálogo.
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
     * Permite obtener la instancia del servicio QuilatajeOroService.
     *
     * @param context El contexto de la invocación.
     * @return Referencia al servicio de QuilatajeOroService.
     */
    private static QuilatajeOroService getServicio(InvocationContext context) {
        context.attributes['spring.beanfactory'].getBean(QuilatajeOroService)
    }

}