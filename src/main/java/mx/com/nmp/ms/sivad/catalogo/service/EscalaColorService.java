/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.EscalaColor;
import mx.com.nmp.ms.sivad.catalogo.repository.EscalaColorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Servicio que nos permite administrar el catálogo {@link EscalaColor}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Service
@Transactional
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class EscalaColorService extends BaseFamiliasColorService<EscalaColor> {
    @Inject
    private EscalaColorRepository escalaColorRepository;

    /**
     * Constructor.
     */
    public EscalaColorService() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EscalaColorRepository getRepository() {
        return escalaColorRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ConfiguracionCatalogoEnum getConfiguracionCatalogo() {
        return ConfiguracionCatalogoEnum.ESCALA_COLOR;
    }
}
