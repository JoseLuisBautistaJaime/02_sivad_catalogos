/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.domain.RangoOro;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.service.RangoOroService;
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

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Controlador REST para entidades de tipo RangoOro.
 *
 * @author mmarquez
 */
@RestController
@RequestMapping("/catalogos/diamantes/alhajas/rangosOro")
public class RangoOroResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(RangoOroResource.class);

    @Inject
    private RangoOroService rangoOroService;



    // METODOS

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
        List<RangoOro> result = rangoOroService.getAll();
        Catalogo catalogo = null;

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catálogo RangoOro no contiene elementos.");
        } else {
            catalogo = CatalogoFactory.build(result);
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
            RangoOro rangoOro = rangoOroService.get(abreviatura);
            Catalogo catalogo = CatalogoFactory.build(rangoOro);
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
            LOGGER.warn("El cat\u00E1logo no contiene dependencias.");
            return new ResponseEntity<>(NOT_ACCEPTABLE);
        }

        return getAll();
    }

}
