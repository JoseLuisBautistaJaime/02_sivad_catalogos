/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.domain.QuilatajeOro;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
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
 * Controlador REST utilizado para obtener la información del catálogo de quilatajes del oro.
 *
 * @author ngonzalez
 * @version 1.0
 * @created 01-Nov-2016
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
    public ResponseEntity<Catalogo> getAll() {
        LOGGER.info(">> getAll");
        List<QuilatajeOro> result = quilatajeOroService.getAll();
        Catalogo catalogo = CatalogoFactory.build(result);
        return new ResponseEntity<>(catalogo, HttpStatus.OK);
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
    public ResponseEntity<Catalogo> get(@PathVariable String abreviatura) {
        LOGGER.info(">> get: [{}]", abreviatura);
        QuilatajeOro quilatajeOro = quilatajeOroService.get(abreviatura);

        if (ObjectUtils.isEmpty(quilatajeOro)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Catalogo catalogo = CatalogoFactory.build(quilatajeOro);
            return new ResponseEntity<>(catalogo, HttpStatus.OK);
        }
    }

    /**
     * GET      / : Obtener todos los elementos del catálogo.
     *
     * @param dependencias Indica si deben recuperarse las dependencias del catálogo.
     * @return ResponseEntity con status 200 (OK) y la lista de elementos del catálogo en el body.
     *         ResponseEntity con status 406 (Not Acceptable) si {@code dependencias = true} ya que esté catálogo
     *         no contiene dependencias.
     */
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = "dependencias")
    public ResponseEntity<Catalogo> getAll(@RequestParam("dependencias") Boolean dependencias) {
        if (dependencias) {
            LOGGER.warn("El cat\u00E1logo no contiene dependencias.");
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        return getAll();
    }

}