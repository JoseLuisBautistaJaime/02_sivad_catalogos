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
import org.springframework.util.ObjectUtils

/**
 * Agrupa la funcionalidad en común para los catálogos familias de color.
 *
 * @param <T> Tipo de catálogo soportados debe ser un subtipo de {@link BaseColor}
 */
abstract class basefamiliascolor<T extends BaseColor> {
    Logger LOGGER = LoggerFactory.getLogger(basefamiliascolor.class)

    @Usage("Permite recuperar todos los elementos del catálogo")
    @Command
    def elementos(InvocationContext context) {
        def catalogo = getServicio(context).getAllWithoutDependencies()

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
            out.println("El elemento del cat\u00e1logo con abreviatura [${abreviatura}] no existe.")
        }
    }

    @Usage("Permite agregar un nuevo elemento al catálogo")
    @Command
    def agregar(InvocationContext context,
                @Usage("Abreviatura") @Required @Option(names = ["a", "abreviatura"]) String abreviatura,
                @Usage("Etiqueta") @Required @Option(names = ["e", "etiqueta"]) String etiqueta) {
        def tp = getGenericClass().newInstance([abreviatura: abreviatura, etiqueta: etiqueta])

        try {
            def elemento = getServicio(context).save(tp)
            out.println("El elemento con abreviatura [${abreviatura}] fue agregado correctamente al cat\u00e1logo.")
            mostrarTablaResultados([elemento])
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("Ocurrió un error al guardar el elemento", e)
            out.println("Ya existe un elemento del cat\u00e1logo con abreviatura [${abreviatura}].")
        } catch (Exception e) {
            LOGGER.error("Ocurrió un error al guardar el elemento", e)
            out.println("Ocurrió un error al guardar el elemento ${getGenericClass().simpleName}(${abreviatura}, ${etiqueta}).")
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

        def tp = getGenericClass().newInstance([abreviatura: abreviatura, etiqueta: etiqueta])

        try {
            def elemento = getServicio(context).update(tp, abrAnterior)
            out.println("El elemento con abreviatura [" + abrAnterior + "] ha sido modificado.")
            mostrarTablaResultados([elemento])
        } catch (CatalogoNotFoundException e) {
            LOGGER.error("Ocurrió un error al actualizar el elemento", e)
            out.println("El elemento del catálogo con abreviatura [${abrAnterior}] no existe.")
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("Ocurrió un error al actualizar el elemento", e)
            out.println("Ya existe un elemento del catálogo con abreviatura [${abreviatura}].")
        } catch (Exception e) {
            LOGGER.error("Ocurrió un error al actualizar el elemento", e)
            out.println("Ocurrió un error al actualizar el elemento ${getGenericClass().simpleName}(${abreviatura}, ${etiqueta}).")
        }
    }

    @Usage("Permite eliminar un elemento del catálogo.")
    @Command
    def eliminar(InvocationContext context,
                 @Usage("Abreviatura del elemento a eliminar")
                 @Required @Argument String abreviatura) {
        try {
            getServicio(context).delete(abreviatura)
            out.println("El elemento con abreviatura [${abreviatura}] fue eliminado correctamente del catálogo.")
        } catch (CatalogoNotFoundException e) {
            LOGGER.error("Ocurrió un error al eliminar el elemento", e)
            out.println("El elemento del catálogo con abreviatura [${abreviatura}] no existe.")
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("Ocurrió un error al eliminar el elemento", e)
            out.println("""Ocurrió un error al eliminar el elemento con abreviatura: ${abreviatura}
Violación de integridad referencial.
Existen referencias a éste elemento en el catálogo Color ${buscarReferencias()}.""")
        } catch (Exception e) {
            LOGGER.error("Ocurrió un error al eliminar el elemento", e)
            out.println("Ocurrió un error al eliminar el elemento con abreviatura: ${abreviatura}")
        }
    }

    @Usage("Muestra graficamente la relación del elemento con sus padres. Relación Hijo Padre")
    @Command
    def relacion(InvocationContext context,
                 @Usage("Abreviatura del elemento a recuperar.")
                 @Required @Argument String abreviatura) {
        def elemento = getServicio(context).getOne(abreviatura)

        if (elemento) {
            def arbol = new UIBuilder()
            mostrarArbolPadres(arbol, elemento)
            arbol
        } else {
            out.println("El elemento del catálogo con abreviatura [${abreviatura}] no existe.")
        }
    }

    /**
     * Permite agregar padres a un elemento del catálogo
     *
     * @param context Contexto.
     * @param elemento Abreviatura del elemento al cual se le agregaran los padres.
     * @param padres Lista con las abreviaturas de los elementos que serán padres.
     *
     * @return Mensaje con el estado de la operación
     */
    protected void agregarPadres(InvocationContext context, String elemento, List<String> padres) {
        try {
            def result = getServicio(context).addPadres(elemento, padres);
            List<String> pAgregados = [];

            result.padres.each { p ->
                if ((i = padres.indexOf(p.abreviatura)) >= 0) {
                    pAgregados.add(padres.get(i))
                }
            }

            padres.removeAll(pAgregados)

            if (padres) {
                out.println("No se encontraron los padres con abreviatura: ${padres}", red)
            }

            out.println("""Asignación ejecutada correctamente.
Se agregaron los padres: ${pAgregados} al elemento con abreviatura: ${elemento}.""");
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("Ocurrió un error al agregar el padre al elemento", e)
            String msj = ""
            padres.each {p ->
                msj += "${getGenericClass().simpleName}(${p}, ${elemento})\n"
            }
            out.println("""Ocurrió un error al agregar los padres: ${padres} al elemento con abreviatura: ${elemento}
Violación de integridad referencial, la clave primaria ya existe
Alguna clave primaria ya existe.
${msj}""", red);
        } catch (CatalogoNotFoundException e) {
            String msj
            if (getGenericClass().isAssignableFrom(e.entidad)) {
                msj = "No se encontro el elemento hijo con abreviatura: ${elemento}"
            } else {
                msj = "No se encontraron los padres con abreviatura: ${padres}"
            }

            out.println(msj, red)
        }
    }

    /**
     * Permite desasignar un padre al elemento del catálogo.
     *
     * @param context Contexto.
     * @param elemento Abreviatura del elemento al cual se le eliminara el padre.
     * @param padre Abreviaturas del elemento padre.
     *
     * @return Mensaje con el estado de la operación
     */
    protected void eliminarPadre(InvocationContext context, String elemento, String padre) {
        try {
            getServicio(context).removePadre(elemento, padre)
            out.println("""Desasignación ejecutada correctamente.
Se desasigno el padre: ${padre} del elemento con abreviatura: ${elemento}.""");
        } catch (CatalogoNotFoundException e) {
            String msj
            if (getGenericClass().isAssignableFrom(e.entidad)) {
                msj = "No se encontro el elemento hijo con abreviatura: ${elemento}"
            } else {
                msj = "No se encontro el padre con abreviatura: ${padre}"
            }

            out.println(msj, red)
        } catch (IndexOutOfBoundsException e) {
            out.println("El elemento con abreviatura ${elemento} no tiene relación con el padre ${padre}", red)
        }
    }

    /**
     * Recupera el tipo ParameterizedType.
     *
     * @return Tipo ParameterizedType
     */
    @SuppressWarnings("GroovyAssignabilityCheck")
    protected Class<T> getGenericClass() {
        (Class<T>) getClass().getGenericSuperclass().getActualTypeArguments()[0]
    }

    /**
     * Regresa el servicio a utilizar segun el valor el contexto
     *
     * @return Servicio a utilizar.
     */
    protected abstract BaseFamiliasColorService getServicio(InvocationContext context)

    protected abstract String buscarReferencias();

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
     * Genera el arbol para mostrar las relaciones de un elemento.
     *
     * @param builder Objeto que contendra la información a mostrar.
     * @param elemento Elemento a representar.
     *
     * @return Arbol con las relaciones.
     */
    protected void mostrarArbolPadres(UIBuilder builder, BaseColor elemento) {
        builder.node("${elemento.class.simpleName}(${elemento.abreviatura})") {
            if (elemento.hasProperty("padres") && elemento.padres) {
                elemento.padres.each { p ->
                    mostrarArbolPadres(builder, p)
                }
            }
        }
    }
}
