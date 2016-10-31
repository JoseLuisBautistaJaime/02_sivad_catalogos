/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.service.TipoPrendaService;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Controlador REST que nos permite consultar el catálogo {@link mx.com.nmp.ms.sivad.catalogo.domain.TipoPrenda}
 * <p>
 * Mapeos de solicitud:
 * <ul>
 *     <li>/catalogos/diamantes/alhajas/tipos: permite recuperar todos los elementos del catalogo.</li>
 *     <li>/catalogos/diamantes/alhajas/tipos?dependencias: operación no soportada ya que este catálogo no contiene
 *     dependencias.</li>
 *     <li>/catalogos/diamantes/alhajas/tipos?idElement: permite recuperar un elemento del catálogo.</li>
 * </ul>
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RestController
@RequestMapping("/catalogos/diamantes/alhajas/tipos")
public class TipoPrendaResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(TipoPrendaResource.class);

    private TipoPrendaService tipoPrendaService;

    /**
     * Constructor.
     */
    public TipoPrendaResource() {
        super();
    }

    /**
     * GET /tipos : Recuperar todos los elementos del catalogo.
     *
     * @return ResponseEntity con status 200 (OK) y el catálogo {@link mx.com.nmp.ms.sivad.catalogo.domain.TipoPrenda}
     *         ResponseEntity con status 404 (Not Found) si el catálogo no contiene elementos.
     */
    @RequestMapping(method = GET,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Catalogo> recuperarCatalogo() {
        Catalogo catalogo = tipoPrendaService.recuperarCatalogo();

        if (null == catalogo) {
            LOGGER.warn("El catálogo no contiene elementos.");
            return new ResponseEntity<>(NOT_FOUND);
        } else {
            return new ResponseEntity<>(catalogo, OK);
        }
    }

    /**
     * GET /tipos?dependencias={@code true} o {@code false} : Recuperar todos los elementos del catalogo.
     * <b>dependencias={@code true} no soportado por esté catálogo.</b>
     *
     * @param dependencias Indica si deben recuperarse las dependecias del catálogo.
     *
     * @return ResponseEntity con status 200 (OK) y el catálogo {@link mx.com.nmp.ms.sivad.catalogo.domain.TipoPrenda}
     *         ResponseEntity con status 404 (Not Found) si el catálogo no contiene elementos.
     *         ResponseEntity con status 406 (Not Acceptable) si {@code dependencias=true} ya que esté catálogo
     *          no contiene dependencias.
     */
    @RequestMapping(method = GET,
            produces = APPLICATION_JSON_VALUE,
            params = "dependencias")
    public ResponseEntity<Catalogo> recuperarCatalogo(
            @RequestParam("dependencias") Boolean dependencias) {
        if (dependencias) {
            LOGGER.warn("El catálogo no contiene dependencias.");
            return new ResponseEntity<>(NOT_ACCEPTABLE);
        }

        return recuperarCatalogo();
    }

    /**
     * GET /tipos?abreviatura={@code abreviatura} : Recuperar un elemento del catalogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @return ResponseEntity con status 200 (OK) y el elemento
     *              del catálogo {@link mx.com.nmp.ms.sivad.catalogo.domain.TipoPrenda}
     *         ResponseEntity con status 404 (Not Found) si el elemento del catálogo no existe.
     */
    @RequestMapping(method = GET,
            produces = APPLICATION_JSON_VALUE,
            params = "abreviatura")
    public ResponseEntity<Catalogo> recuperarElemento(@RequestParam("abreviatura") String abreviatura) {
        Catalogo catalogo = tipoPrendaService.recuperarElemento(abreviatura);
        if (null == catalogo) {
            LOGGER.warn("El elemento del catálogo no existe.");
            return new ResponseEntity<>(NOT_FOUND);
        } else {
            return new ResponseEntity<>(catalogo, OK);
        }
    }

    /**
     * Establce el valor de tipoPrendaService.
     *
     * @param tipoPrendaService Nuevo valor de tipoPrendaService.
     */
    @Inject
    public void setTipoPrendaService(TipoPrendaService tipoPrendaService) {
        this.tipoPrendaService = tipoPrendaService;
    }
}
