package mx.com.nmp.ms.sivad.catalogo.web.rest;

import com.codahale.metrics.annotation.Timed;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.service.ConfiguracionCatalogoService;
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
 * Controlador REST para {@link mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo}
 *
 * @author osanchez
 */
@RestController
@RequestMapping("/catalogos")
public class ConfiguracionCatalogoResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfiguracionCatalogoResource.class);

    @Inject
    ConfiguracionCatalogoService configuracionCatalogoService;

    /**
     * GET  /configuraciones : obtener todas las configuraciones de catálogo
     *
     * @param paginacion información de paginación
     * @return una ResponseEntity con estatus 200 (OK) y la lista de configuraciones en el body
     * @throws URISyntaxException si hay un error al generar los encabezados de paginación
     */
    @RequestMapping(value = "/configuraciones",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<ConfiguracionCatalogo>> getAll(Pageable paginacion)
            throws URISyntaxException {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> getAll({})", paginacion);
        }

        Page<ConfiguracionCatalogo> page = configuracionCatalogoService.findAll(paginacion);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/catalogos/configuraciones");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
