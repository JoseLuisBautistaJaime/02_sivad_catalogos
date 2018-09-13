/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package commands

import mx.com.nmp.ms.sivad.catalogo.domain.ClaridadDiamante
import mx.com.nmp.ms.sivad.catalogo.domain.RangoPeso
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException
import mx.com.nmp.ms.sivad.catalogo.service.ClaridadDiamanteService
import org.crsh.cli.*
import org.crsh.command.InvocationContext
import org.crsh.text.ui.Overflow
import org.crsh.text.ui.UIBuilder
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.util.ObjectUtils

/**
 * Utilizada por la consola CRaSH para la administración del catálogo Claridad Diamantes
 *
 * @author roramirez
 */
@Usage("Administración del catálogo Claridad Diamantes")
class claridad {

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
                @Usage("Etiqueta") @Option(names = ["e", "etiqueta"]) @Required String etiqueta,
                @Usage("Identificador del rango") @Option(names = ["i", "idRango"]) @Required int idRango,
                @Usage("padre (0=false, 1=true)") @Option(names = ["p", "padre"]) @Required int padre) {
        try {
            def claridadDiamante = new ClaridadDiamante([abreviatura: abreviatura, etiqueta: etiqueta, rango: new RangoPeso([idElemento: idRango]), padre: padre])
            def elemento = getServicio(context).save(claridadDiamante)
            out.println("El elemento con abreviatura [${abreviatura}] fue agregado correctamente al catálogo.")
            mostrarTablaResultados([elemento])
        } catch (DataIntegrityViolationException e) {
            out.println("Ya existe un elemento del catálogo con abreviatura y rango [${abreviatura}, ${idRango}].")
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
                 @Usage("Abreviatura del elemento a recuperar") @Required @Argument String abreviatura,
                 @Usage("Identificador del rango") @Required @Argument int idRango) {
        try {
            mostrarTablaResultados([getServicio(context).get(abreviatura, idRango)])
        } catch (CatalogoNotFoundException e) {
            out.println("El elemento del catálogo con abreviatura [${abreviatura}, ${idRango}] no existe.")
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
        def result = getServicio(context).getAll();

        if (result) {
            mostrarTablaResultados(result)
        } else {
            out.println("El catálogo no contiene elementos.")
        }
    }

    /**
     * Permite obtener todos los elementos del catálogo por rango.
     *
     * @param context El contexto de la invocación.
     * @return Lista de elementos del catálogo.
     */
    @Usage("Permite recuperar todos los elementos del catálogo por rango")
    @Command
    def elementosrango(InvocationContext context,
    				@Usage("Identificador del rango") @Required @Argument int idRango) {
        def result = getServicio(context).getAll(idRango);

        if (result) {
            mostrarTablaResultados(result)
        } else {
            out.println("El catálogo no contiene elementos con el rango [${idRango}].")
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
                 @Usage("Abreviatura del elemento a eliminar") @Required @Argument String abreviatura,
                 @Usage("Identificador del rango") @Required @Argument int idRango) {
        try {
            getServicio(context).delete(abreviatura, idRango)
            out.println("El elemento con abreviatura [${abreviatura}, ${idRango}] fue eliminado correctamente del catálogo.")
        } catch (CatalogoNotFoundException e) {
            out.println("El elemento del catálogo con abreviatura [${abreviatura}, ${idRango}] no existe.")
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
    @Usage("Permite actualizar un elemento del catálogo")
    @Command
    def modificar(InvocationContext context,
                  @Usage("Abreviatura actual del elemento a actualizar") @Option(names = ["i", "abreviaturaActual"]) @Required String abreviaturaActual,
                  @Usage("Identificador del rango del elemento") @Option(names = ["r", "idRangoActual"]) @Required int idRangoActual,
                  @Usage("Abreviatura") @Option(names = ["a", "abreviatura"]) String abreviatura,
                  @Usage("Etiqueta") @Option(names = ["e", "etiqueta"]) String etiqueta,
                  @Usage("Padre (0=false, 1=true)") @Option(names = ["p", "padre"]) String padre) {

        if (ObjectUtils.isEmpty(abreviatura) && ObjectUtils.isEmpty(etiqueta) && ObjectUtils.isEmpty(padre)) {
            out.println("Se requiere al menos uno de los atributos ([a, abreviatura] o [e, etiqueta] y [r, idRangoActual]) " +
                    "para realizar la actualización.")
        } else {

            int padreInt
            if (!ObjectUtils.isEmpty(padre)) {
                if (padre != "1" && padre != "0") {
                    out.println("El atributo ([p, padre]) solo permite los valores 0=false o 1=true")
                    return
                } else {
                    padreInt = Integer.valueOf(padre);
                }
            }

            try {
                def claridadDiamante
                def elemento

                if (ObjectUtils.isEmpty(padre)) {
                    claridadDiamante = new ClaridadDiamante([abreviatura: abreviatura, etiqueta: etiqueta, rango: new RangoPeso([idElemento: idRangoActual]), padre: 0])
                    elemento = getServicio(context).update(abreviaturaActual, idRangoActual, claridadDiamante, false)
                } else {
                    claridadDiamante = new ClaridadDiamante([abreviatura: abreviatura, etiqueta: etiqueta, rango: new RangoPeso([idElemento: idRangoActual]), padre: padreInt])
                    elemento = getServicio(context).update(abreviaturaActual, idRangoActual, claridadDiamante, true)
                }

                out.println("El elemento con abreviatura ["+ abreviaturaActual + "] ha sido modificado.")
                mostrarTablaResultados([elemento])
            } catch (CatalogoNotFoundException e) {
                out.println("El elemento del catálogo con abreviatura [${abreviaturaActual}, ${idRangoActual}] no existe.")
            } catch (DataIntegrityViolationException e) {
                out.println("Ya existe un elemento del catálogo con abreviatura [${abreviatura}].")
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
                label('Padre')
                label('Rango')
            }

            elementos.each { elemento ->
                row {
                    label(elemento.abreviatura, foreground: green)
                    label(elemento.etiqueta, foreground: yellow)
                    label(elemento.padre, foreground: orange)
                    label(elemento.rango.idElemento, foreground: grey)
                }
            }
        }
    }

    /**
     * Permite obtener la instancia del servicio ClaridadDiamanteService.
     *
     * @param context El contexto de la invocación.
     * @return Referencia al servicio de ClaridadDiamanteService.
     */
    private static ClaridadDiamanteService getServicio(InvocationContext context) {
        context.attributes['spring.beanfactory'].getBean(ClaridadDiamanteService)
    }


}
