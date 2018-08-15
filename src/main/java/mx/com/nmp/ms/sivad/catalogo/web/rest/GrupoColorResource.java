/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import com.codahale.metrics.annotation.Timed;

import mx.com.nmp.ms.sivad.catalogo.domain.EscalaColor;
import mx.com.nmp.ms.sivad.catalogo.domain.GrupoColor;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.service.BaseFamiliasColorService;
import mx.com.nmp.ms.sivad.catalogo.service.GrupoColorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Controlador REST que nos permite consultar el catálogo {@link GrupoColor}
 * <p>
 * Mapeos de solicitud:
 * <ul>
 *     <li>/catalogos/diamantes/color/familia3: permite recuperar todos los elementos del catalogo.</li>
 *     <li>/catalogos/diamantes/color/familia3?dependencias: permite recuperar todos los elementos del catalogo.
 *     Se incluyen dependencias si {@code dependencias=true}</li>
 * </ul>
 *
 * <b>Contiene dependecia de hijo-padre con el catálogo {@link EscalaColor} como rol padre.</b>
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RestController
@RequestMapping("/catalogos/diamantes/color/familia3")
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class GrupoColorResource extends BaseFamiliasColorResource<GrupoColor> {
    @Inject
    private GrupoColorService grupoColorService;

    /**
     * Constructor.
     */
    public GrupoColorResource() {
        super();
    }

    /**
     * GET /familia3 : Recuperar todos los elementos del catalogo.
     *
     * @return ResponseEntity con status 200 (OK) y el catálogo {@link GrupoColor}
     *         ResponseEntity con status 404 (Not Found) si el catálogo no contiene elementos.
     */
    @Timed
    @Override
    @RequestMapping(method = GET,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Catalogo> getAll() {
        return getAllWithoutDependencies();
    }

    /**
     * GET /familia3?dependencias={@code true} o {@code false} : Recuperar todos los elementos del catalogo.
     * <b>Se incluyen dependencias si {@code dependencias=true}</b>
     * Contiene dependecia de hijo-padre con el catálogo {@link EscalaColor} como rol padre.
     *
     * @param dependencias Indica si deben recuperarse las dependecias del catálogo.
     * @param rango Id del rango del catalogo rango pesos
     *
     * @return ResponseEntity con status 200 (OK) y el catálogo {@link GrupoColor}
     *         ResponseEntity con status 404 (Not Found) si el catálogo no contiene elementos.
     */
    @Timed
    @RequestMapping(method = GET,
            produces = APPLICATION_JSON_VALUE,
            params = {"dependencias", "idRango"} )
    public ResponseEntity<Catalogo> getAll(@RequestParam(value = "dependencias", required = false) boolean dependencias, @RequestParam(value = "idRango", required = false) Long idRango) {
        if (dependencias) {
        	if (idRango != null) {
        		return super.getAll(idRango);
        	}
        	else {
        		return super.getAll();
        	}
        } else {
        	if (idRango != null) {
        		return getAllWithoutDependencies(idRango);
        	}
        	else {
        		return getAllWithoutDependencies();
        	}
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BaseFamiliasColorService<GrupoColor> getService() {
        return grupoColorService;
    }
}
