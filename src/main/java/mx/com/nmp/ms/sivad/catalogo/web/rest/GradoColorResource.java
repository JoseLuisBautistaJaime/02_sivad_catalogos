/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import com.codahale.metrics.annotation.Timed;
import mx.com.nmp.ms.sivad.catalogo.domain.GradoColor;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.service.GradoColorService;
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
 * Controlador REST que nos permite consultar el catálogo {@link GradoColor}
 * <p>
 * Mapeos de solicitud:
 * <ul>
 *     <li>/catalogos/diamantes/colores: permite recuperar todos los elementos del catalogo.</li>
 *     <li>/catalogos/diamantes/colores?dependencias: operación no soportada ya que este catálogo no contiene
 *     dependencias.</li>
 *     <li>/catalogos/diamantes/colores/{abreviatura}: permite recuperar un elemento del catálogo.</li>
 * </ul>
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RestController
@RequestMapping("/catalogos/diamantes/colores")
@SuppressWarnings({"SpringAutowiredFieldsWarningInspection", "WeakerAccess"})
public class GradoColorResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(GradoColorResource.class);

    @Inject
    private GradoColorService gradoColorService;

    /**
     * Constructor.
     */
    public GradoColorResource() {
        super();
    }

    /**
     * GET /colores : Recuperar todos los elementos del catalogo.
     * @param idRango Identificador del rango
     *
     * @return ResponseEntity con status 200 (OK) y el catálogo {@link GradoColor}
     *         ResponseEntity con status 404 (Not Found) si el catálogo no contiene elementos.
     */
    @Timed
    @RequestMapping(method = GET,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Catalogo> getAll(@RequestParam(value = "idRango", required = false) Long idRango) {
        List<GradoColor> result = null;
        if (idRango != null) {
        	result = gradoColorService.getAll(idRango);
        }
        else {
        	result = gradoColorService.getAll();
        }

        Catalogo catalogo = null;

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catálogo Grado Color no contiene elementos.");
        } else {
            catalogo = CatalogoFactory.build(result);
        }

        return new ResponseEntity<>(catalogo, OK);
    }

    /**
     * GET /colores?dependencias={@code true} o {@code false} : Recuperar todos los elementos del catalogo.
     * <b>dependencias={@code true} no soportado por esté catálogo.</b>
     *
     * @param dependencias Indica si deben recuperarse las dependecias del catálogo.
     *
     * @return ResponseEntity con status 200 (OK) y el catálogo {@link GradoColor}
     *         ResponseEntity con status 404 (Not Found) si el catálogo no contiene elementos.
     *         ResponseEntity con status 406 (Not Acceptable) si {@code dependencias=true} ya que esté catálogo
     *         no contiene dependencias.
     */
    @Timed
    @RequestMapping(method = GET,
            produces = APPLICATION_JSON_VALUE,
            params = {"dependencias", "idRango" })
    public ResponseEntity<Catalogo> getAll(@RequestParam(value = "dependencias", required = false) boolean dependencias, @RequestParam(value = "idRango", required = false) Long idRango) {
        if (dependencias) {
            LOGGER.warn("El catálogo no contiene dependencias.");
            return new ResponseEntity<>(NOT_ACCEPTABLE);
        }

    	return getAll(idRango);
    }

    /**
     * GET /colores/{abreviatura} : Recuperar un elemento del catalogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @return ResponseEntity con status 200 (OK) y el elemento del catálogo {@link GradoColor}
     *         ResponseEntity con status 404 (Not Found) si el elemento del catálogo no existe.
     */
    @Timed
    @RequestMapping(value = "/{abreviatura}",
            method = GET,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Catalogo> get(@PathVariable String abreviatura, @RequestParam(value = "idRango", required = false) Long idRango) {
    	
    	GradoColor result = null;
    	if (idRango != null) {
    		result = gradoColorService.getOne(abreviatura, idRango);
    	}
    	else {
    		result = gradoColorService.getOne(abreviatura);
    	}

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El elemento del catálogo Grado Color con abreviatura = {}, no existe.", abreviatura);
            return new ResponseEntity<>(NOT_FOUND);
        }

        return new ResponseEntity<>(CatalogoFactory.build(result), OK);
    }
}
