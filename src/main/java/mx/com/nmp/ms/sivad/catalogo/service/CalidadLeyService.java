package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.CalidadLey;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.CalidadLeyRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
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
 * Servicio que provee la logica de negocio para el catalogo CalidadLey.
 *
 * @author jbautista
 */
@Service
@Transactional
public class CalidadLeyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalidadLeyService.class);

    @Inject
    private CalidadLeyRepository calidadLeyRepository;

    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    /**
     * Guarda elemento de catalgo de tipo CalidadLey.
     *
     * @param calidadLey objeto que sera guardado.
     * @return CalidadLey objeto que es guardado.
     */
    public CalidadLey save(@NotNull CalidadLey calidadLey) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> save({})", calidadLey);
        }
        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
            ConfiguracionCatalogoEnum.CALIDAD_LEY.getDominioUnwrap(),
            ConfiguracionCatalogoEnum.CALIDAD_LEY.getTipo());
        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        calidadLey.setConfiguracion(configuracionCatalogo);

        try {
            return calidadLeyRepository.save(calidadLey);
        } catch (DataIntegrityViolationException e) {
            String mensaje = "Ya existe un elemento con la abreviatura:" + calidadLey.getAbreviatura();
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn(mensaje + " Excepcion: {}", e);
            }
            throw e;
        }
    }

    /**
     * Actualiza elemento de catalogo de tipo CalidadLey.
     *
     * @param abreviatura abreviatura del elemento que sera modificado.
     * @param calidadLey  objeto a modificar.
     * @return CalidadLey
     */
    public CalidadLey update(@NotNull String abreviatura, @NotNull CalidadLey calidadLey) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> update({})", abreviatura);
        }
        CalidadLey calidadLeyActual = obtenerElementoAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(calidadLey.getAbreviatura())) {
            LOGGER.warn("No se definio Abreviatura, se conserva la abreviatura actual: {}", calidadLeyActual.getAbreviatura());
        } else {
            calidadLeyActual.setAbreviatura(calidadLey.getAbreviatura());
        }

        if (ObjectUtils.isEmpty(calidadLey.getEtiqueta())) {
            LOGGER.warn("No se definio Etiqueta, se conserva la etiqueta actual: {}", calidadLeyActual.getEtiqueta());
        } else {
            calidadLeyActual.setEtiqueta(calidadLey.getEtiqueta());
        }

        calidadLeyActual.getConfiguracion().setUltimaActualizacion(new DateTime());

        try {
            return calidadLeyRepository.save(calidadLeyActual);
        } catch (DataIntegrityViolationException e) {
            String mensaje = "Ya existe un elemento con la abreviatura:" + calidadLey.getAbreviatura();
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn(mensaje + " Excepcion: {}", e);
            }
            throw e;
        }
    }


    /**
     * Elimina elemento del catalogo de tipo CalidadLey por abreviatura.
     *
     * @param abreviatura del elemento que sera eliminado
     */
    public void delete(@HasText String abreviatura) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> delete({})", abreviatura);
        }
        CalidadLey calidadLey = this.obtenerElementoAbreviatura(abreviatura);
        calidadLey.getConfiguracion().setUltimaActualizacion(new DateTime());
        calidadLeyRepository.delete(calidadLey);
    }

    /**
     * Obtiene las entidades del catalogo de tipo CalidadLey.
     *
     * @return List CalidadLey lista de entidades de tipo CalidadLey
     */
    @Transactional(readOnly = true)
    public List<CalidadLey> findAll() {
        LOGGER.info(">> findAll()");
        List<CalidadLey> result = calidadLeyRepository.findAll();
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
        List<CalidadLey> result = calidadLeyRepository.findAll();
        Catalogo catalogo = null;
        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("<< El catalogo CalidadLey no contiene elementos.");
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
    public CalidadLey obtenerElementoAbreviatura(@HasText String abreviatura) {
        CalidadLey result = calidadLeyRepository.findByAbreviatura(abreviatura);
        if (ObjectUtils.isEmpty(result)) {
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn("<< El elemento con abreviatura {}, no existe.", abreviatura);
                throw new CatalogoNotFoundException("El elemento con abreviatura {"+abreviatura+"}no existe",CalidadLey.class);
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
        CalidadLey result = calidadLeyRepository.findByAbreviatura(abreviatura);
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
