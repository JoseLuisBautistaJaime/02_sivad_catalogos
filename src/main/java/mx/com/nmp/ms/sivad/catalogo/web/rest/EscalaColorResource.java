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
import mx.com.nmp.ms.sivad.catalogo.domain.EscalaColor;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.service.BaseFamiliasColorService;
import mx.com.nmp.ms.sivad.catalogo.service.EscalaColorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Controlador REST que nos permite consultar el catálogo {@link EscalaColor}
 * <p>
 * Mapeos de solicitud:
 * <ul>
 *     <li>/catalogos/diamantes/color/familia2: permite recuperar todos los elementos del catalogo.</li>
 *     <li>/catalogos/diamantes/color/familia2?dependencias: permite recuperar todos los elementos del catalogo.
 *     Se incluyen dependencias si {@code dependencias=true}</li>
 * </ul>
 *
 * <b>Contiene dependecia de hijo-padre con el catálogo {@link Color} como rol padre.</b>
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RestController
@RequestMapping("/catalogos/diamantes/color/familia2")
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class EscalaColorResource extends BaseFamiliasColorResource<EscalaColor> {
    @Inject
    private EscalaColorService escalaColorService;

    /**
     * Constructor
     */
    public EscalaColorResource() {
        super();
    }

    /**
     * GET /familia2 : Recuperar todos los elementos del catalogo.
     * @param idRango Identificador del rango 
     *
     * @return ResponseEntity con status 200 (OK) y el catálogo {@link EscalaColor}
     *         ResponseEntity con status 404 (Not Found) si el catálogo no contiene elementos.
     */
    @Timed
    @Override
    @RequestMapping(method = GET,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Catalogo> getAll(@RequestParam(value = "idRango", required = false) Long idRango) {
    	if (idRango != null) {
    		return super.getAllWithoutDependencies(idRango);
    	}
    	else {
    		return super.getAllWithoutDependencies();
    	}
    }

    /**
     * GET /familia2?dependencias={@code true} o {@code false} : Recuperar todos los elementos del catalogo.
     * <b>Se incluyen dependencias si {@code dependencias=true}</b>
     * Contiene dependecia de hijo-padre con el catálogo {@link Color} como rol padre.
     *
     * @param dependencias Indica si deben recuperarse las dependecias del catálogo.
     *
     * @return ResponseEntity con status 200 (OK) y el catálogo {@link EscalaColor}
     *         ResponseEntity con status 404 (Not Found) si el catálogo no contiene elementos.
     */
    @Timed
    @RequestMapping(method = GET,
            produces = APPLICATION_JSON_VALUE,
            params = {"dependencias", "idRango"})
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
        		return super.getAllWithoutDependencies(idRango);
        	}
        	else {
        		return super.getAllWithoutDependencies();
        	}
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BaseFamiliasColorService<EscalaColor> getService() {
        return escalaColorService;
    }
}
