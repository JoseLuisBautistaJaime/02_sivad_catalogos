/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.GrupoColor;
import mx.com.nmp.ms.sivad.catalogo.repository.GrupoColorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Servicio que nos permite administrar el catálogo {@link GrupoColor}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Service
@Transactional
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class GrupoColorService extends BaseFamiliasColorService<GrupoColor> {
    @Inject
    private GrupoColorRepository grupoColorRepository;

    /**
     * Constructor.
     */
    public GrupoColorService() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected GrupoColorRepository getRepository() {
        return grupoColorRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ConfiguracionCatalogoEnum getConfiguracionCatalogo() {
        return ConfiguracionCatalogoEnum.GRUPO_COLOR;
    }
}
