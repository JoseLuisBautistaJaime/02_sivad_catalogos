package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.Metal;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.MetalRepository;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import java.util.List;

/**
 * Servicio que provee la logica de negocio para el catalogo Metal.
 *
 * @author jbautista
 */
@Service
@Transactional
public class MetalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Metal.class);

    @Inject
    private MetalRepository metalRepository;

    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    /**
     * Guarda elemento de catalgo de tipo Metal.
     *
     * @param metal objeto que sera guardado.
     * @return Metal objeto que es guardado.
     */
    public Metal save(@NotNull Metal metal) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> save({})", metal);
        }
        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
            ConfiguracionCatalogoEnum.METAL.getDominioUnwrap(),
            ConfiguracionCatalogoEnum.METAL.getTipo());
        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        metal.setConfiguracion(configuracionCatalogo);

        try {
            return metalRepository.save(metal);
        } catch (DataIntegrityViolationException e) {
            String mensaje = "Ya existe un elemento con la abreviatura:" + metal.getAbreviatura();
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn(mensaje + " Excepcion: {}", e);
            }
            throw e;
        }
    }

    /**
     * Actualiza elemento de catalogo de tipo Metal.
     *
     * @param abreviatura abreviatura del elemento que sera modificado.
     * @param metal       objeto a modificar.
     * @return Metal
     */
    public Metal update(@NotNull String abreviatura, @NotNull Metal metal) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> update({})", abreviatura);
        }
        Metal metalActual = obtenerElementoAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(metal.getAbreviatura())) {
            LOGGER.warn("No se definio Abreviatura, se conserva la abreviatura actual: {}", metalActual.getAbreviatura());
        } else {
            metalActual.setAbreviatura(metal.getAbreviatura());
        }

        if (ObjectUtils.isEmpty(metal.getEtiqueta())) {
            LOGGER.warn("No se definio Etiqueta, se conserva la etiqueta actual: {}", metalActual.getEtiqueta());
        } else {
            metalActual.setEtiqueta(metal.getEtiqueta());
        }

        metalActual.getConfiguracion().setUltimaActualizacion(new DateTime());

        try {
            return metalRepository.save(metalActual);
        } catch (DataIntegrityViolationException e) {
            String mensaje = "Ya existe un elemento con la abreviatura:" + metal.getAbreviatura();
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn(mensaje + " Excepcion: {}", e);
            }
            throw e;
        }
    }

    /**
     * Obtiene entidad de tipo Metal por abreviatura.
     *
     * @param abreviatura identificador de elemento que sera buscado
     * @return Metal
     */
    @Transactional(readOnly = true)
    public Metal findbyAbreviatura(@NotNull String abreviatura) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> findbyAbreviatura({})", abreviatura);
        }
        return metalRepository.findByAbreviatura(abreviatura);
    }

    /**
     * Elimina elemento del catalogo de tipo Metal por abreviatura.
     *
     * @param abreviatura del elemento que sera eliminado
     */
    public void delete(@HasText String abreviatura) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info(">> delete({})", abreviatura);
            }
            Metal metal = this.obtenerElementoAbreviatura(abreviatura);
            metal.getConfiguracion().setUltimaActualizacion(new DateTime());
            metalRepository.delete(metal);
        }

    /**
     * Obtiene las entidades del catalogo de tipo Metal.
     *
     * @return List lista de entidades de tipo Metal
     */
    @Transactional(readOnly = true)
    public List<Metal> findAll() {
        LOGGER.info(">> findAll()");
        List<Metal> result = metalRepository.findAll();
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
        List<Metal> result = metalRepository.findAll();
        Catalogo catalogo = null;
        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("<< El catalogo Metal no contiene elementos.");
        } else {
            catalogo = CatalogoFactory.build(result);
        }
        return catalogo;
    }

    /**
     * Obtiene un elemento especificado por abreviatura.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     * @return Catalogo.
     */
    public Metal obtenerElementoAbreviatura(@HasText String abreviatura) {
        Metal result = metalRepository.findByAbreviatura(abreviatura);
        if (ObjectUtils.isEmpty(result)) {
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn("<< El elemento con abreviatura {}, no existe.", abreviatura);
                throw new CatalogoNotFoundException("El elemento con abreviatura {"+abreviatura+"}no existe",Metal.class);
            }
        }

        return result;
    }

    /**
     * Obtiene un elemento del catalogo especificado por abreviatura.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     * @return Catalogo.
     */
    public Catalogo recuperarElementoCatalogo(@HasText String abreviatura) {
        Metal result = metalRepository.findByAbreviatura(abreviatura);
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
