/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import com.codahale.metrics.annotation.Timed;
import mx.com.nmp.ms.sivad.catalogo.domain.CatalogoPrueba;
import mx.com.nmp.ms.sivad.catalogo.service.CatalogoPruebaService;
import mx.com.nmp.ms.sivad.catalogo.web.rest.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Controlador REST de prueba para entidades de tipo "CatalogoPrueba".
 *
 * @author ngonzalez
 */
@RestController
@RequestMapping("/api")
public class CatalogoPruebaResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogoPruebaResource.class);

    @Inject
    private CatalogoPruebaService catalogoService;



    // METODOS

    /**
     * GET  /catalogos : obtener todas las entradas de catálogo.
     *
     * @param pageable información de paginación
     * @return ResponseEntity con status 200 (OK) y la lista de entradas de catálogo en el body
     * @throws java.net.URISyntaxException si hay un error al generar los headers HTTP de paginación
     */
    @RequestMapping(value = "/catalogos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<CatalogoPrueba>> getAllCatalogos(Pageable pageable)
            throws URISyntaxException {
        LOGGER.debug(">> getAllCatalogos({})", pageable);
        Page<CatalogoPrueba> page = catalogoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/catalogos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}