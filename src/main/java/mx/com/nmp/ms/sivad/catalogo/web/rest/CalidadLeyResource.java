package mx.com.nmp.ms.sivad.catalogo.web.rest;

import com.codahale.metrics.annotation.Timed;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.service.CalidadLeyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.net.URISyntaxException;

/**
 * Controlador REST para consultar entidades de tipo CalidadLey.
 *
 * @author jbautista
 */

@RestController
@RequestMapping("/catalogos")
public class CalidadLeyResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalidadLeyResource.class);

    @Inject
    private CalidadLeyService calidadLeyService;

    /**
     * Constructor de la clase.
     */
    public CalidadLeyResource() {
        super();
    }

    /**
     * GET  /catalogos : obtiene los elementos del catalogo CalidadLey.
     *
     * @return ResponseEntity con status 200 (OK) y la lista de elementos, status 404 (NOT FOUND) cuando no contiene elementos.
     * @throws URISyntaxException si hay un error al generar los headers HTTP de paginacion
     */
    @RequestMapping(value = "/diamantes/alhajas/calidades_ley",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Catalogo> getAll()
            throws URISyntaxException {
        LOGGER.info(">> getAll({})");
        Catalogo catalogo = calidadLeyService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (catalogo == null) {
            LOGGER.warn("<< El catalogo no contiene valores.");
            return new ResponseEntity<>(headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(catalogo, headers, HttpStatus.OK);
    }

    /**
     * GET  /catalogos : obtiene los elementos del catalogo CalidadLey.
     *
     * @param abreviatura abreviatura del elemento a buscar.
     * @return ResponseEntity con status 200 (OK) y la lista de elementos, status 404 (NOT FOUND) cuando no contiene elementos.
     * @throws URISyntaxException si hay un error al generar en la invocación de headers.
     */
    @RequestMapping(value = "/diamantes/alhajas/calidades_ley/{abreviatura}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Catalogo> get(@PathVariable String abreviatura)
            throws URISyntaxException {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> get({})", abreviatura);
        }
        Catalogo catalogo = calidadLeyService.recuperarElementoCatalogo(abreviatura);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (catalogo == null) {
            LOGGER.warn("<< El elemento no existe.");
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(catalogo, headers, HttpStatus.OK);
    }

}
