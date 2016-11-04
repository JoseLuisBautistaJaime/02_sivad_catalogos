/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import com.codahale.metrics.annotation.Timed;
import mx.com.nmp.ms.sivad.catalogo.domain.QuilatajeOro;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.service.QuilatajeOroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Controlador REST utilizado para obtener la información del catálogo Quilataje Oro.
 *
 * @author ngonzalez
 */
@RestController
@RequestMapping("/catalogos/diamantes/alhajas/quilatajes")
public class QuilatajeOroResource {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(QuilatajeOroResource.class);

    /**
     * Referencia al servicio de QuilatajeOroService.
     */
    @Inject
    private QuilatajeOroService quilatajeOroService;



    // METODOS

    /**
     * GET      / : Obtener todos los elementos del catálogo.
     *
     * @return ResponseEntity con status 200 (OK) y la lista de elementos del catálogo en el body.
     */
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Catalogo> getAll() {
        LOGGER.info(">> getAll");

        List<QuilatajeOro> result = quilatajeOroService.getAll();
        if (ObjectUtils.isEmpty(result)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(CatalogoFactory.build(quilatajeOroService.getAll()), HttpStatus.OK);
        }
    }

    /**
     * GET      / : Obtener todos los elementos del catálogo.
     *
     * @param dependencias Indica si deben recuperarse las dependencias del catálogo.
     * @return ResponseEntity con status 200 (OK) y la lista de elementos del catálogo en el body si
     *         {@code dependencias = false}.
     *         ResponseEntity con status 406 (Not Acceptable) si {@code dependencias = true} ya que
     *         esté catálogo no contiene dependencias.
     */
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = "dependencias")
    @Timed
    public ResponseEntity<Catalogo> getAll(@RequestParam("dependencias") boolean dependencias) {
        if (dependencias) {
            LOGGER.warn("El catalogo QuilatajeOro no contiene dependencias.");
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        return getAll();
    }

    /**
     * GET      /{abreviatura} : Obtener el elemento del catálogo que corresponda a la abreviatura indicada.
     *
     * @param abreviatura La abreviatura del elemento del catálogo a recuperar.
     * @return ResponseEntity con status 200 (OK) y el elemento del catálogo en el body, o con status 404
     * (Not Found) si no existe.
     */
    @RequestMapping(value = "/{abreviatura}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Catalogo> get(@PathVariable String abreviatura) {
        LOGGER.info(">> get: [{}]", abreviatura);

        try {
            return new ResponseEntity<>(CatalogoFactory.build(quilatajeOroService.get(abreviatura)), HttpStatus.OK);
        } catch (CatalogoNotFoundException e) {
            LOGGER.warn("El elemento del catalogo no existe. Excepcion: [{}]", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}