/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import com.codahale.metrics.annotation.Timed;
import mx.com.nmp.ms.sivad.catalogo.domain.Color;
import mx.com.nmp.ms.sivad.catalogo.domain.GradoColor;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.service.BaseFamiliasColorService;
import mx.com.nmp.ms.sivad.catalogo.service.ColorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Controlador REST que nos permite consultar el catálogo {@link Color}
 * <p>
 * Mapeos de solicitud:
 * <ul>
 *     <li>/catalogos/diamantes/color/familia1: permite recuperar todos los elementos del catalogo.</li>
 *     <li>/catalogos/diamantes/color/familia1?dependencias: permite recuperar todos los elementos del catalogo.
 *     Se incluyen dependencias si {@code dependencias=true}</li>
 * </ul>
 *
 * <b>Contiene dependecia de hijo-padre con el catálogo {@link GradoColor} como rol padre.</b>
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RestController
@RequestMapping("/catalogos/diamantes/color/familia1")
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class ColorResource extends BaseFamiliasColorResource<Color> {
    @Inject
    private ColorService colorService;

    /**
     * Constructor
     */
    public ColorResource() {
        super();
    }

    /**
     * GET /familia1 : Recuperar todos los elementos del catalogo.
     *
     * @return ResponseEntity con status 200 (OK) y el catálogo {@link Color}
     *         ResponseEntity con status 404 (Not Found) si el catálogo no contiene elementos.
     */
    @Timed
    @Override
    @RequestMapping(method = GET,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Catalogo> getAll() {
        return super.getAllWithoutDependencies();
    }

    /**
     * GET /familia1?dependencias={@code true} o {@code false} : Recuperar todos los elementos del catalogo.
     * <b>Se incluyen dependencias si {@code dependencias=true}</b>
     * Contiene dependecia de hijo padre con el catálogo {@link GradoColor} como rol padre.
     *
     * @param dependencias Indica si deben recuperarse las dependecias del catálogo.
     *
     * @return ResponseEntity con status 200 (OK) y el catálogo {@link Color}
     *         ResponseEntity con status 404 (Not Found) si el catálogo no contiene elementos.
     */
    @Timed
    @RequestMapping(method = GET,
            produces = APPLICATION_JSON_VALUE,
            params = "dependencias")
    public ResponseEntity<Catalogo> getAll(@RequestParam("dependencias") boolean dependencias) {
        if (dependencias) {
            return super.getAll();
        } else {
            return getAll();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BaseFamiliasColorService<Color> getService() {
        return colorService;
    }
}
