/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import com.codahale.metrics.annotation.Timed;
import mx.com.nmp.ms.sivad.catalogo.domain.ClaridadDiamante;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.service.ClaridadDiamanteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import mx.com.nmp.ms.sivad.catalogo.domain.FCWithoutDependenciesProjection;

/**
 * Controlador REST utilizado para obtener la información del catálogo Claridad Diamante.
 *
 * @author roramirez
 */
@RestController
@RequestMapping("/catalogos/diamantes/claridades")
public class ClaridadDiamanteResource {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ClaridadDiamanteResource.class);

    /**
     * Referencia al servicio de ClaridadDiamanteService.
     */
    @Inject
    private ClaridadDiamanteService claridadDiamanteService;

    /**
     * GET      / : Obtener todos los elementos del catálogo.
     * @param idRango Identificador del rango
     *
     * @return ResponseEntity con status 200 (OK) y la lista de elementos del catálogo en el body.
     */
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Catalogo> getAll(@RequestParam(value = "idRango", required = false) Long idRango) {
        LOGGER.info(">> getAll");
        List<FCWithoutDependenciesProjection> result =  null;
        if (idRango != null) {
            result = claridadDiamanteService.getAllWithoutDependencies(idRango);
        }else {
            result = claridadDiamanteService.getAllWithoutDependencies();
        }

        if(ObjectUtils.isEmpty(result)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        Catalogo catalogo = CatalogoFactory.build(result.get(0).getConfiguracion(),result);

        return new ResponseEntity<>(catalogo, HttpStatus.OK);
    }

    /**
     * GET      / : Obtener todos los elementos del catálogo.
     *
     * @param dependencias Indica si deben recuperarse las dependencias del catálogo.
     * @return ResponseEntity con status 200 (OK) y la lista de elementos del catálogo en el body si
     *         {@code dependencias = false}.
     *         ResponseEntity con status 406 (Not Acceptable) si {@code dependencias = true} ya que
     *         esté catálogo no contiene dependencias.
     */
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = {"dependencias", "idRango"})
    @Timed
    public ResponseEntity<Catalogo> getAll(@RequestParam(value = "dependencias", required = false) boolean dependencias, @RequestParam(value = "idRango", required = false) Long idRango) {
        //if (dependencias) {
        //    LOGGER.warn("El catalogo ClaridadDiamante no contiene dependencias.");
        //    return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        //}

    	// Remover padres
    	LOGGER.info(">> getAll");

        if (dependencias) {
            List<ClaridadDiamante> result = null;
            if (idRango != null) {
                result = claridadDiamanteService.getAll(idRango);
            }else {
                result = claridadDiamanteService.getAll();
            }

            if(ObjectUtils.isEmpty(result)) {
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(CatalogoFactory.build(result), HttpStatus.OK);
        }else{
            List<FCWithoutDependenciesProjection> result =  null;
            if (idRango != null) {
                result = claridadDiamanteService.getAllWithoutDependencies(idRango);
            }else {
                result = claridadDiamanteService.getAllWithoutDependencies();
            }

            if(ObjectUtils.isEmpty(result)) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            Catalogo catalogo = CatalogoFactory.build(result.get(0).getConfiguracion(),result);

            return new ResponseEntity<>(catalogo, HttpStatus.OK);
        }

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
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = "idRango")
    @Timed
    public ResponseEntity<Catalogo> get(@PathVariable String abreviatura, @RequestParam(value = "idRango", required = true) Long idRango) {
        LOGGER.info(">> get: [{}, {}]", abreviatura, idRango);

        try {
            return new ResponseEntity<>(CatalogoFactory.build(claridadDiamanteService.getAll(abreviatura, idRango)), HttpStatus.OK);
        } catch (CatalogoNotFoundException e) {
            LOGGER.warn("El elemento del catalogo no existe. Excepcion: [{}]", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
