/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.domain.BaseColor;
import mx.com.nmp.ms.sivad.catalogo.domain.FCWithoutDependenciesProjection;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.service.BaseFamiliasColorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

/**
 * Clase que agrupa la funcionalidad en común para los servicios REST de los catálogos familias de color.
 *
 * @param <T> Catálogo que será soportado, debe ser un sub tipo de {@link BaseColor}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
abstract class BaseFamiliasColorResource<T extends BaseColor> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseFamiliasColorResource.class);

    /**
     * Constructor.
     */
    BaseFamiliasColorResource() {
        super();
    }

    /**
     * Recupera todos los elementos del catálogo. Se incluyen dependencias.
     *
     * @return ResponseEntity
     */
    public ResponseEntity<Catalogo> getAll() {
        List<T> result = getService().getAll();
        Catalogo catalogo = null;

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catálogo {} no contiene elementos.", getGenericClass().getSimpleName());
        } else {
            catalogo = CatalogoFactory.build(result);
        }

        return new ResponseEntity<>(catalogo, OK);
    }

    /**
     * Recupera todos los elementos del catálogo. Se incluyen dependencias.
     * @param idRango
     *
     * @return ResponseEntity
     */
    protected ResponseEntity<Catalogo> getAll(Long idRango) {
        List<T> result = getService().getAll(idRango);
        Catalogo catalogo = null;

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catálogo {} no contiene elementos.", getGenericClass().getSimpleName());
        } else {
            catalogo = CatalogoFactory.build(result);
        }

        return new ResponseEntity<>(catalogo, OK);
    }


    /**
     * Recupera todos los elementos del catálogo. Sin dependencias.
     * @param idRango
     *
     * @return ResponseEntity
     */
    @SuppressWarnings("WeakerAccess")
    public ResponseEntity<Catalogo> getAllWithoutDependencies() {
        List<FCWithoutDependenciesProjection> result = getService().getAllWithoutDependencies();
        Catalogo catalogo = null;

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catálogo {} no contiene elementos.", getGenericClass().getSimpleName());
        } else {
            catalogo = CatalogoFactory.build(result.get(0).getConfiguracion(), result);
        }

        return new ResponseEntity<>(catalogo, OK);
    }


    /**
     * Recupera todos los elementos del catálogo. Sin dependencias.
     * @param idRango
     *
     * @return ResponseEntity
     */
    @SuppressWarnings("WeakerAccess")
    public ResponseEntity<Catalogo> getAllWithoutDependencies(Long idRango) {
        List<FCWithoutDependenciesProjection> result = getService().getAllWithoutDependencies(idRango);
        Catalogo catalogo = null;

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catálogo {} no contiene elementos.", getGenericClass().getSimpleName());
        } else {
            catalogo = CatalogoFactory.build(result.get(0).getConfiguracion(), result);
        }

        return new ResponseEntity<>(catalogo, OK);
    }

    /**
     * Regresa el servicio a utilizar segun el valor de {@code T}
     *
     * @return Servicio a utilizar.
     */
    protected abstract BaseFamiliasColorService<T> getService();

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
