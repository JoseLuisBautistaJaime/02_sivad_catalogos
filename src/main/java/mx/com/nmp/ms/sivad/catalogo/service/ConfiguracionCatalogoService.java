package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Lógica de negocio para ConfiguracionCatalogo
 *
 * @author osanchez
 */
@Service
@Transactional
public class ConfiguracionCatalogoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfiguracionCatalogoService.class);

    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    /**
     * Obtener todas las configuraciones de catalogo
     *
     * @param paginacion información de paginación
     * @return listado de configuraciones
     */
    @Transactional(readOnly = true)
    public Page<ConfiguracionCatalogo> findAll(Pageable paginacion) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> findAll({})", paginacion);
        }

        return configuracionCatalogoRepository.findAll(paginacion);
    }
}
