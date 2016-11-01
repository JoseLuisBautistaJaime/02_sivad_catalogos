package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.service.CondicionPrendaService;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.inject.Inject;
import java.net.URISyntaxException;

/**
 * Controlador REST para consultar entidades de tipo CondicionPrenda.
 *
 * @author jbautista
 */

@RestController
@RequestMapping("/catalogos")
public class CondicionPrendaResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CondicionPrendaResource.class);

    @Inject
    private CondicionPrendaService condicionPrendaService;

    /**
     * Constructor de la clase.
     */
    public CondicionPrendaResource(){
        super();
    }

    /**
     * GET  /catalogos : obtiene los elementos del catálogo CondicionPrenda.
     *
     * @return ResponseEntity con status 200 (OK) y la lista de elementos, status 404 (NOT FOUND) cuando no contiene elementos.
     * @throws URISyntaxException si hay un error al generar los headers HTTP de paginacion
     */
    @RequestMapping(value = "/diamantes/condiciones",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Catalogo> getAll()
    throws URISyntaxException {
        LOGGER.debug(">> getAllEstadosPrenda()");
        Catalogo catalogo = condicionPrendaService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (catalogo == null) {
            LOGGER.warn("El catalogo es null");
            return new ResponseEntity<Catalogo>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Catalogo>(catalogo, headers, HttpStatus.OK);
    }
}
