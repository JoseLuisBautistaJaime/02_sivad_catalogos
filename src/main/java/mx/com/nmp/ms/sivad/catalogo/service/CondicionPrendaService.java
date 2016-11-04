package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.CondicionPrenda;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.CondicionPrendaRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import java.util.List;

/**
 * Servicio que provee la logica de negocio para el catalogo CondicionPrenda.
 *
 * @author jbautista
 */
@Service
@Transactional
public class CondicionPrendaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CondicionPrendaService.class);

    @Inject
    private CondicionPrendaRepository condicionPrendaRepository;

    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    /**
     * Guarda elemento de catalgo de tipo CondicionPrenda.
     *
     * @param condicionPrenda objeto que sera guardado.
     * @return CondicionPrenda objeto que es guardado.
     */
    public CondicionPrenda save(@NotNull CondicionPrenda condicionPrenda) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> save({})", condicionPrenda);
        }
        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
                ConfiguracionCatalogoEnum.CONDICION_PRENDA.getDominioUnwrap(),
                ConfiguracionCatalogoEnum.CONDICION_PRENDA.getTipo());
        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        condicionPrenda.setConfiguracion(configuracionCatalogo);

        return condicionPrendaRepository.save(condicionPrenda);
    }

    /**
     * Actualiza elemento de catalogo de tipo CondicionPrenda.
     *
     * @param abreviatura     abreviatura del elemento que sera modificado.
     * @param condicionPrenda objeto a modificar.
     * @return CondicionPrenda
     */
    public CondicionPrenda update(@NotNull String abreviatura, @NotNull CondicionPrenda condicionPrenda) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> update({})", abreviatura);
        }
        CondicionPrenda condicionPrendaActual = condicionPrendaRepository.findByAbreviatura(abreviatura);
        condicionPrendaActual.setEtiqueta(condicionPrenda.getEtiqueta());
        condicionPrendaActual.setAbreviatura(condicionPrenda.getAbreviatura());
        condicionPrendaActual.getConfiguracion().setUltimaActualizacion(new DateTime());

        return condicionPrendaRepository.save(condicionPrendaActual);
    }

    /**
     * Obtiene entidad de tipo CondicionPrenda por identificador.
     *
     * @param id identificador de elemento que sera buscado
     * @return CondicionPrenda
     */
    @Transactional(readOnly = true)
    public CondicionPrenda findOne(@NotNull Long id) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> findOne({})", id);
        }
        return condicionPrendaRepository.findOne(id);
    }

    /**
     * Obtiene entidad de tipo CondicionPrenda por abreviatura.
     *
     * @param abreviatura identificador de elemento que sera buscado
     * @return CondicionPrenda
     */
    @Transactional(readOnly = true)
    public CondicionPrenda findbyAbreviatura(@NotNull String abreviatura) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> findbyAbreviatura({})", abreviatura);
        }
        return condicionPrendaRepository.findByAbreviatura(abreviatura);
    }

    /**
     * Elimina elemento del catalogo de tipo CondicionPrenda por abreviatura.
     *
     * @param abreviatura del elemento que sera eliminado
     */
    public void delete(@NotNull String abreviatura) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> delete({})", abreviatura);
        }
        CondicionPrenda condicionPrenda = condicionPrendaRepository.findByAbreviatura(abreviatura);
        condicionPrenda.getConfiguracion().setUltimaActualizacion(new DateTime());
        condicionPrendaRepository.delete(condicionPrenda);
    }

    /**
     * Obtiene las entidades del catalogo de tipo CondicionPrenda.
     *
     * @return List CondicionPrenda lista de entidades de tipo CondicionPrenda
     */
    @Transactional(readOnly = true)
    public List<CondicionPrenda> findAll() {
        LOGGER.info(">> findAll()");
        List<CondicionPrenda> result = condicionPrendaRepository.findAll();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("<< findAll(): {}", result);
        }
        return result;
    }

    /**
     * Obtiene los elementos del catalogo con formato JSON.
     *
     * @return Catalogo.
     */
    @Transactional(readOnly = true)
    public Catalogo getAll() {
        LOGGER.info(">> getAll()");
        List<CondicionPrenda> result = condicionPrendaRepository.findAll();
        Catalogo catalogo = null;
        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("<< El catalogo CondicionPrenda no contiene elementos.");
        } else {
            catalogo = CatalogoFactory.build(result);
        }
        return catalogo;
    }

    /**
     * Obtiene un elemento del catalogo especificado por abreviatura.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     * @return Catalogo.
     */
    public Catalogo recuperarElemento(@HasText String abreviatura) {
        CondicionPrenda result = condicionPrendaRepository.findByAbreviatura(abreviatura);
        Catalogo catalogo = null;

        if (ObjectUtils.isEmpty(result)) {
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn("<< El elemento con abreviatura {}, no existe.", abreviatura);
            }
        } else {
            catalogo = CatalogoFactory.build(result);
        }

        return catalogo;
    }

}
