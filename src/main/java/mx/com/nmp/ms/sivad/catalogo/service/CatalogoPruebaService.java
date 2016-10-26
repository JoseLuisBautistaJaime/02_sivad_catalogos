/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.domain.CatalogoPrueba;
import mx.com.nmp.ms.sivad.catalogo.repository.CatalogoPruebaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Servicio de prueba para entidades de tipo "CatalogoPrueba".
 *
 * @author ngonzalez
 */
@Service
@Transactional
public class CatalogoPruebaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogoPruebaService.class);

    @Inject
    private CatalogoPruebaRepository catalogoPruebaRepository;



    // METODOS

    /**
     * Obtener todas las entidades de tipo "CatalogoPrueba".
     *
     * @param pageable informacion de paginacion
     * @return lista de entidades
     */
    @Transactional(readOnly = true)
    public Page<CatalogoPrueba> findAll(Pageable pageable) {
        LOGGER.info(">> findAll({})", pageable);
        Page<CatalogoPrueba> result = catalogoPruebaRepository.findAll(pageable);
        LOGGER.debug("<< findAll({}): {}", pageable, result);
        return result;
    }

}