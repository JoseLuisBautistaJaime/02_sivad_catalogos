/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import com.codahale.metrics.annotation.Timed;
import mx.com.nmp.ms.sivad.catalogo.domain.TipoPrenda;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.service.TipoPrendaService;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Controlador REST que nos permite consultar el catálogo {@link TipoPrenda}
 * <p>
 * Mapeos de solicitud:
 * <ul>
 *     <li>/catalogos/diamantes/alhajas/tipos: permite recuperar todos los elementos del catalogo.</li>
 *     <li>/catalogos/diamantes/alhajas/tipos?dependencias: operación no soportada ya que este catálogo no contiene
 *     dependencias.</li>
 *     <li>/catalogos/diamantes/alhajas/tipos/{abreviatura} permite recuperar un elemento del catálogo.</li>
 * </ul>
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RestController
@RequestMapping("/catalogos/diamantes/alhajas/tipos")
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class TipoPrendaResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(TipoPrendaResource.class);

    @Inject
    private TipoPrendaService tipoPrendaService;

    /**
     * Constructor.
     */
    @SuppressWarnings("WeakerAccess")
    public TipoPrendaResource() {
        super();
    }

    /**
     * GET /tipos : Recuperar todos los elementos del catalogo.
     *
     * @return ResponseEntity con status 200 (OK) y el catálogo {@link TipoPrenda}.
     */
    @Timed
    @RequestMapping(method = GET,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Catalogo> getAll() {
        List<TipoPrenda> result = tipoPrendaService.getAll();
        Catalogo catalogo = null;

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catálogo Tipo Prenda no contiene elementos.");
        } else {
            catalogo = CatalogoFactory.build(result);
        }

        return new ResponseEntity<>(catalogo, OK);
    }

    /**
     * GET /tipos?dependencias={@code true} o {@code false} : Recuperar todos los elementos del catalogo.
     * <b>dependencias={@code true} no soportado por esté catálogo.</b>
     *
     * @param dependencias Indica si deben recuperarse las dependecias del catálogo.
     *
     * @return ResponseEntity con status 200 (OK) y el catálogo {@link TipoPrenda}
     *         ResponseEntity con status 406 (Not Acceptable) si {@code dependencias=true} ya que esté catálogo
     *         no contiene dependencias.
     */
    @Timed
    @RequestMapping(method = GET,
            produces = APPLICATION_JSON_VALUE,
            params = "dependencias")
    public ResponseEntity<Catalogo> getAll(@RequestParam(value = "dependencias", required = false) boolean dependencias) {
        if (dependencias) {
            LOGGER.warn("El catálogo no contiene dependencias.");
            return new ResponseEntity<>(NOT_ACCEPTABLE);
        }

        return getAll();
    }

    /**
     * GET /{abreviatura} : Recuperar un elemento del catalogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @return ResponseEntity con status 200 (OK) y el elemento del catálogo {@link TipoPrenda}
     *         ResponseEntity con status 404 (Not Found) si el elemento del catálogo no existe.
     */
    @Timed
    @RequestMapping(value = "/{abreviatura}",
            method = GET,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Catalogo> get(@PathVariable String abreviatura) {
        TipoPrenda result = tipoPrendaService.getOne(abreviatura);

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El elemento del catálogo Tipo Prenda con abreviatura = {}, no existe.", abreviatura);
            return new ResponseEntity<>(NOT_FOUND);
        }

        return new ResponseEntity<>(CatalogoFactory.build(result), OK);
    }
}
