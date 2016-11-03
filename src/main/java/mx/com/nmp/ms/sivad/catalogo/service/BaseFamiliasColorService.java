/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import com.codahale.metrics.annotation.Timed;
import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.BaseColor;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.FCWithoutDependenciesProjection;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.BaseFamiliasColorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import javax.validation.Valid;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Clase que agrupa la funcionalidad en común para los catálogos familias de color.
 *
 * @param <T> Catálogo que será soportado, debe ser un sub tipo de {@link BaseColor}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public abstract class BaseFamiliasColorService<T extends BaseColor> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseFamiliasColorService.class);

    @Inject
    private ConfiguracionCatalogoService configuracionCatalogoService;

    /**
     * Constructor.
     */
    BaseFamiliasColorService() {
        super();
    }

    /**
     * Permite agregar un elemento nuevo al catálogo.
     *
     * @param elemento Elemento a guardar.
     *
     * @return El objeto {@link T} que fue creado.
     */
    public T save(@Valid T elemento) {
        elemento.setConfiguracion(actualizarConfiguracion());

        return getRepository().save(elemento);
    }

    /**
     * Permite modificar un elemento del catálogo.
     *
     * @param elemento Elemento modificado.
     * @param abreviatura Abreviatura que identifica el elementos que será modificado.
     *
     * @return El objeto {@link T} que fue actualizado.
     *
     * @throws CatalogoNotFoundException Cuando no existe el elemento a actualizar.
     */
    public T update(@NotNull T elemento, @HasText String abreviatura) {
        T cc = obtenerElemento(abreviatura);
        actualizarCatalogo(cc, elemento);

        return save(cc);
    }

    /**
     * Permite eliminar un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a eliminar.
     *
     * @return El objeto {@link T} que fue eliminado.
     *
     * @throws CatalogoNotFoundException Cuando no existe el elemento a eliminar.
     */
    public T delete(@HasText String abreviatura) {
        T cc = obtenerElemento(abreviatura);
        actualizarConfiguracion();
        getRepository().delete(cc);

        return cc;
    }

    /**
     * Permite recuperar todos los elementos del catálogo. Se incluyen dependencias.
     *
     * @return Objeto {@link Catalogo} con todos los elementos.
     */
    @Timed
    @Transactional(readOnly = true)
    public Catalogo getAll() {
        List<T> result = getRepository().findAll();
        Catalogo catalogo = null;

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catálogo {} no contiene elementos.", getGenericClass().getSimpleName());
        } else {
            catalogo = CatalogoFactory.build(result);
        }

        return catalogo;
    }

    /**
     * Permite recuperar todos los elementos del catálogo, sin las dependencias.
     *
     * @return Objeto {@link Catalogo} con todos los elementos.
     */
    @Timed
    @Transactional(readOnly = true)
    public Catalogo getAllWithoutDependencies() {
        List<FCWithoutDependenciesProjection> result = getRepository().findAllWithoutDependenciesBy();
        Catalogo catalogo = null;

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catálogo {} no contiene elementos.", getGenericClass().getSimpleName());
        } else {
            catalogo = CatalogoFactory.build(result.get(0).getConfiguracion(), result);
        }

        return catalogo;
    }

    /**
     * Permite recuperar un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @return Objeto {@link Catalogo} con el elemento especificado.
     */
    @Timed
    @Transactional(readOnly = true)
    public Catalogo getOne(@HasText String abreviatura) {
        T result = getRepository().findByAbreviatura(abreviatura);
        Catalogo catalogo = null;

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El elemento con {}.abreviatura = {}, no existe.",
                    abreviatura, getGenericClass().getSimpleName());
        } else {
            catalogo = CatalogoFactory.build(result);
        }

        return catalogo;
    }

    /**
     * Regresa el repositorio a utilizar segun el valor de {@code T}
     *
     * @return Repositorio a utilizar.
     */
    protected abstract BaseFamiliasColorRepository<T> getRepository();

    /**
     * Regresa la configuración del catálogo a utilizar segun el valor de {@code T}
     *
     * @return Configuración del catálogo a utilizar
     */
    protected abstract ConfiguracionCatalogoEnum getConfiguracionCatalogo();

    /**
     * Verifica si el elemento recuperado es valido
     *
     * @param obj Elemento a validar.
     * @param abreviaturaPadre Abreviatura del elemento.
     * @param clazz Class del elemento.
     */
    protected static void validarElmento(Object obj, String abreviaturaPadre,  Class<?> clazz) {
        if (ObjectUtils.isEmpty(obj)) {
            String msj = String.format("No se encontro el elemento con abreviatura: %s", abreviaturaPadre);
            LOGGER.warn(msj);
            throw new CatalogoNotFoundException(msj, clazz);
        }
    }

    /**
     * Actualiza la fecha de ultima actualización de la configuración del catálogo.
     *
     * @return Regresa el objeto {@link ConfiguracionCatalogo} modificado.
     */
    private ConfiguracionCatalogo actualizarConfiguracion() {
        ConfiguracionCatalogoEnum config = getConfiguracionCatalogo();

        return configuracionCatalogoService.getAndUpdateOperationDate(config.getDominioUnwrap(), config.getTipo());
    }


    /**
     * Lee un elemento del catálogo filtrando por {@code abreviatura}
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @throws CatalogoNotFoundException Cuando no existe el elemento a recuperar.
     */
    private T obtenerElemento(String abreviatura) {
        T cc = getRepository().findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(cc)) {
            String mensage = String.format("El elemento con %s.abreviatura = %s, no existe.",
                    getGenericClass().getSimpleName(), abreviatura);
            LOGGER.warn(mensage);
            throw new CatalogoNotFoundException(mensage, getGenericClass());
        }

        return cc;
    }

    /**
     * Actualiza un objeto {@link T} apartir de otro.
     *
     * @param original Objeto original a ser actualizado.
     * @param nuevo Objeto con las modificaciones.
     */
    private void actualizarCatalogo(T original, T nuevo) {
        if (ObjectUtils.isEmpty(nuevo.getAbreviatura())) {
            LOGGER.warn("{}.abreviatura = null, se deja valor anterior {}", getGenericClass().getSimpleName(),
                    original.getAbreviatura());
        } else {
            original.setAbreviatura(nuevo.getAbreviatura());
        }

        if (ObjectUtils.isEmpty(nuevo.getEtiqueta())) {
            LOGGER.warn("{}.etiqueta = null, se deja valor anterior {}", getGenericClass().getSimpleName(),
                    original.getEtiqueta());
        } else {
            original.setEtiqueta(nuevo.getEtiqueta());
        }
    }

    /**
     * Recupera el tipo ParameterizedType.
     *
     * @return Tipo ParameterizedType
     */
    @SuppressWarnings("unchecked")
    private Class<T> getGenericClass() {
        ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();

        return (Class<T>) pt.getActualTypeArguments()[0];
    }
}
