/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package commands

import mx.com.nmp.ms.sivad.catalogo.domain.QuilatajeDiamante
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException
import mx.com.nmp.ms.sivad.catalogo.service.QuilatajeDiamanteService
import org.crsh.cli.*
import org.crsh.command.InvocationContext
import org.crsh.text.ui.Overflow
import org.crsh.text.ui.UIBuilder
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.util.ObjectUtils

/**
 * Utilizada por la consola CRaSH para la administración del catatogo Quilataje Diamante.
 *
 * @author jbautista
 */
@Usage("Administración del cat\u00e1logo Quilataje Diamante")
class quilatajeDiamante {

    /**
     * Permite agregar un nuevo elemento al catálogo con base en los parámetros recibidos.
     *
     * @param context El contexto de la invocación.
     * @param abreviatura La abreviatura.
     * @param etiqueta La etiqueta.
     * @return El elemento guardado en caso de éxito o el mensaje correspondiente en caso de fallo.
     */
    @Usage("Permite agregar un nuevo elemento al cat\u00e1logo")
    @Command
    def agregar(InvocationContext context,
                @Usage("Abreviatura") @Option(names = ["a", "abreviatura"]) @Required String abreviatura,
                @Usage("Etiqueta") @Option(names = ["e", "etiqueta"]) @Required String etiqueta) {
        try {
            def quilatajeDiamante = new QuilatajeDiamante([abreviatura: abreviatura, etiqueta: etiqueta])
            def elemento = getServicio(context).save(quilatajeDiamante)
            out.println("El elemento con abreviatura [${abreviatura}] fue agregado correctamente al cat\u00e1logo.")
            mostrarTablaResultados([elemento])
        } catch (DataIntegrityViolationException e) {
            out.println("Ya existe un elemento del cat\u00e1logo con abreviatura [${abreviatura}].")
        }
    }

    /**
     * Permite obtener el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param context El contexto de la invocación.
     * @param abreviatura La abreviatura.
     * @return El elemento del catálogo que coincida con la abreviatura indicada.
     */
    @Usage("Permite recuperar el elemento del cat\u00e1logo que coincida con la abreviatura indicada")
    @Command
    def elemento(InvocationContext context,
                 @Usage("Abreviatura del elemento a recuperar") @Required @Argument String abreviatura) {
        try {
            mostrarTablaResultados([getServicio(context).get(abreviatura)])
        } catch (CatalogoNotFoundException e) {
            out.println("El elemento del cat\u00e1ogo con abreviatura [${abreviatura}] no existe.")
        }
    }

    /**
     * Permite obtener todos los elementos del catálogo.
     *
     * @param context El contexto de la invocación.
     * @return Lista de elementos del catálogo.
     */
    @Usage("Permite recuperar todos los elementos del cat\u00e1logo")
    @Command
    def elementos(InvocationContext context) {
        def result = getServicio(context).getAll();

        if (result) {
            mostrarTablaResultados(result)
        } else {
            out.println("El cat\u00e1logo no contiene elementos.")
        }
    }

    /**
     * Permite eliminar el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param context El contexto de la invocación.
     * @param abreviatura La abreviatura.
     * @return El mensaje de éxito o fallo correspondiente.
     */
    @Usage("Permite eliminar un elemento del cat\u00e1logo")
    @Command
    def eliminar(InvocationContext context,
                 @Usage("Abreviatura del elemento a eliminar") @Required @Argument String abreviatura) {
        try {
            getServicio(context).delete(abreviatura)
            out.println("El elemento con abreviatura [${abreviatura}] fue eliminado correctamente del cat\u00e1logo.")
        } catch (CatalogoNotFoundException e) {
            out.println("El elemento del cat\u00e1logo con abreviatura [${abreviatura}] no existe.")
        }
    }

    /**
     * Permite actualizar un elemento del catálogo.
     *
     * @param context El contexto de la invocación.
     * @param abreviaturaActual La abreviatura actual del elemento a actualizar.
     * @param abreviatura Nuevo valor de la abreviatura (puede ser opcional).
     * @param etiqueta Nuevo valor de la etiqueta (puede ser opcional).
     * @return El elemento actualizado en caso de éxito o el mensaje correspondiente en caso de fallo.
     */
    @Usage("Permite actualizar un elemento del cat\u00e1logo")
    @Command
    def modificar(InvocationContext context,
                  @Usage("Abreviatura actual del elemento a actualizar")
                  @Option(names = ["i", "abreviaturaActual"]) @Required String abreviaturaActual,
                  @Usage("Abreviatura")
                  @Option(names = ["a", "abreviatura"]) String abreviatura,
                  @Usage("Etiqueta")
                  @Option(names = ["e", "etiqueta"]) String etiqueta) {

        if (ObjectUtils.isEmpty(abreviatura) && ObjectUtils.isEmpty(etiqueta)) {
            out.println("Se requiere al menos uno de los atributos ([a, abreviatura] o [e, etiqueta]) " +
                "para realizar la actualizaci\u00f3n.")
        } else {
            try {
                def quilatajeDiamante = new QuilatajeDiamante([abreviatura: abreviatura, etiqueta: etiqueta])
                def elemento = getServicio(context).update(abreviaturaActual, quilatajeDiamante)
                out.println("El elemento con abreviatura ["+ abreviaturaActual + "] ha sido modificado.")
                mostrarTablaResultados([elemento])
            } catch (CatalogoNotFoundException e) {
                out.println("El elemento del catálogo con abreviatura [${abreviaturaActual}] no existe.")
            } catch (DataIntegrityViolationException e) {
                out.println("Ya existe un elemento del cat\u00e1logo con abreviatura [${abreviatura}].")
            }
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
     * Permite obtener la instancia del servicio QuilatajeDiamanteService.
     *
     * @param context El contexto de la invocación.
     * @return Referencia al servicio de QuilatajeDiamanteService.
     */
    private static QuilatajeDiamanteService getServicio(InvocationContext context) {
        context.attributes['spring.beanfactory'].getBean(QuilatajeDiamanteService)
    }

}
