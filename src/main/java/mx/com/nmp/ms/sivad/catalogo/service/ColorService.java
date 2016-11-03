/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.domain.Color;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.repository.ColorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Servicio que nos permite administrar el catálogo {@link Color}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Service
@Transactional
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class ColorService extends BaseFamiliasColorService<Color> {
    @Inject
    private ColorRepository colorRepository;

    /**
     * Constructor.
     */
    public ColorService() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ColorRepository getRepository() {
        return colorRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ConfiguracionCatalogoEnum getConfiguracionCatalogo() {
        return ConfiguracionCatalogoEnum.COLOR;
    }
}
