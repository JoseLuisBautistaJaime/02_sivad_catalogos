/*
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.domain.Corte;
import mx.com.nmp.ms.sivad.catalogo.domain.CorteWithoutDependenciesProjection;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.service.CorteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import com.codahale.metrics.annotation.Timed;

import javax.inject.Inject;
import java.util.List;

/**
 * Controlador REST para entidades de tipo Cortes.
 *
 * @author mmarquez
 */
@RestController
@RequestMapping("/catalogos/diamantes/cortes")
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class CorteResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CorteResource.class);

    @Inject
    private CorteService corteService;



    // METODOS

    /**
     * GET      / : Obtener todos los elementos del catálogo.
     *
     * @return ResponseEntity con status 200 (OK) y la lista de elementos del catálogo en el body.
     */
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Catalogo> getAll() {
        LOGGER.info(">> getAll");
        List<CorteWithoutDependenciesProjection> result = corteService.getAllWithoutDependencies();
        Catalogo catalogo = null;

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catálogo Corte no contiene elementos.");
        } else {
            catalogo = CatalogoFactory.build(result.get(0).getConfiguracion(), result);
        }
        return new ResponseEntity<>(catalogo, HttpStatus.OK);
    }

    /**
     * GET      /{abreviatura} : Obtener el elemento del catálogo que corresponda a la abreviatura indicada.
     *
     * @param abreviatura La abreviatura del elemento del catálogo a recuperar.
     * @return ResponseEntity con status 200 (OK) y el elemento del catálogo en el body, o con status 404
     * (Not Found) si no existe.
     */
    @RequestMapping(value = "/{abreviatura}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Catalogo> get(@PathVariable String abreviatura) {
        LOGGER.info(">> get: [{}]", abreviatura);
        try {
            Corte corte = corteService.get(abreviatura);
            Catalogo catalogo = CatalogoFactory.build(corte);
            return new ResponseEntity<>(catalogo, HttpStatus.OK);
        } catch (CatalogoNotFoundException e) {
            LOGGER.warn("El elemento del catalogo no existe. Excepcion: [{}]", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * GET      / : Obtener todos los elementos del catálogo.
     *
     * @param dependencias Indica si deben recuperarse las dependencias del catálogo.
     * @return ResponseEntity con status 200 (OK) y la lista de elementos del catálogo en el body.
     *         ResponseEntity con status 406 (Not Acceptable) si {@code dependencias = true} ya que esté catálogo
     *         no contiene dependencias.
     */
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = "dependencias")
    @Timed
    public ResponseEntity<Catalogo> getAll(@RequestParam(value = "dependencias", required = false) boolean dependencias) {
        if (dependencias) {
            return new ResponseEntity<>(getAllWithDependencies(), HttpStatus.OK);
        } else {
            return getAll();
        }
    }

    /**
     * Recupera todos los elemtos el catálogo incluyendo dependencias.
     *
     * @return Catalogo con los elementos.
     */
    private Catalogo getAllWithDependencies() {
        LOGGER.info(">> getAll");
        List<Corte> result = corteService.getAll();

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catálogo Corte no contiene elementos.");
            return null;
        } else {
            return CatalogoFactory.build(result);
        }
    }

}
