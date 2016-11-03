/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.domain.BaseColor;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.service.BaseFamiliasColorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

import static org.springframework.http.HttpStatus.NOT_FOUND;
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
        Catalogo catalogo = getService().getAll();

        if (ObjectUtils.isEmpty(catalogo)) {
            LOGGER.warn("El catálogo no contiene elementos.");
            return new ResponseEntity<>(NOT_FOUND);
        } else {
            return new ResponseEntity<>(catalogo, OK);
        }
    }


    /**
     * Recupera todos los elementos del catálogo. Sin dependencias.
     *
     * @return ResponseEntity
     */
    public ResponseEntity<Catalogo> getAllWithoutDependencies() {
        Catalogo catalogo = getService().getAllWithoutDependencies();

        if (ObjectUtils.isEmpty(catalogo)) {
            LOGGER.warn("El catálogo no contiene elementos.");
            return new ResponseEntity<>(NOT_FOUND);
        } else {
            return new ResponseEntity<>(catalogo, OK);
        }
    }

    /**
     * Regresa el servicio a utilizar segun el valor de {@code T}
     *
     * @return Servicio a utilizar.
     */
    protected abstract BaseFamiliasColorService<T> getService();
}
