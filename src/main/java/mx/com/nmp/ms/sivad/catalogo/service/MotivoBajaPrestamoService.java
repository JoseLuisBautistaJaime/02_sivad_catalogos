package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.MotivoBajaPrestamo;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.MotivoBajaPrestamoRepository;
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
 * Servicio que provee la logica de negocio para el catalogo de tipo MotivoBajaPrestamo.
 *
 * @author jbautista
 */
@Service
@Transactional
public class MotivoBajaPrestamoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MotivoBajaPrestamoService.class);

    @Inject
    private MotivoBajaPrestamoRepository motivoBajaPrestamoRepository;

    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    /**
     * Guarda elemento de catalgo de tipo MotivoBajaPrestamo
     *
     * @param motivoBajaPrestamo elemento que sera guardado.
     * @return MotivoBajaPrestamo
     */
    public MotivoBajaPrestamo save(@NotNull MotivoBajaPrestamo motivoBajaPrestamo) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> save({})", motivoBajaPrestamo);
        }
        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
            ConfiguracionCatalogoEnum.MOTIVO_BAJA_PRESTAMO.getDominioUnwrap(),
            ConfiguracionCatalogoEnum.MOTIVO_BAJA_PRESTAMO.getTipo());
        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        motivoBajaPrestamo.setConfiguracion(configuracionCatalogo);

        try {
            return motivoBajaPrestamoRepository.save(motivoBajaPrestamo);
        } catch (DataIntegrityViolationException e) {
            String mensaje = "Ya existe un elemento con la abreviatura:" + motivoBajaPrestamo.getAbreviatura();
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn(mensaje + " Excepcion: {}", e);
            }
            throw e;
        }
    }

    /**
     * Actualiza elemento de catalogo de tipo MotivoBajaPrestamo.
     *
     * @param abreviatura        abreviatura del elemento que sera modificado.
     * @param motivoBajaPrestamo objeto a modificar.
     * @return MotivoBajaPrestamo
     */
    public MotivoBajaPrestamo update(@NotNull String abreviatura, @NotNull MotivoBajaPrestamo motivoBajaPrestamo) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> update({})", abreviatura);
        }
        MotivoBajaPrestamo motBajPrestActual = obtenerElementoAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(motivoBajaPrestamo.getAbreviatura())) {
            LOGGER.warn("No se definio Abreviatura, se conserva la abreviatura actual: {}", motBajPrestActual.getAbreviatura());
        } else {
            motBajPrestActual.setAbreviatura(motivoBajaPrestamo.getAbreviatura());
        }

        if (ObjectUtils.isEmpty(motivoBajaPrestamo.getEtiqueta())) {
            LOGGER.warn("No se definio Etiqueta, se conserva la etiqueta actual: {}", motBajPrestActual.getEtiqueta());
        } else {
            motBajPrestActual.setEtiqueta(motivoBajaPrestamo.getEtiqueta());
        }

        motBajPrestActual.getConfiguracion().setUltimaActualizacion(new DateTime());

        try {
            return motivoBajaPrestamoRepository.save(motBajPrestActual);
        } catch (DataIntegrityViolationException e) {
            String mensaje = "Ya existe un elemento con la abreviatura:" + motivoBajaPrestamo.getAbreviatura();
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn(mensaje + " Excepcion: {}", e);
            }
            throw e;
        }
    }

    /**
     * Borrar elemento de tipo MotivoBajaPrestamo por abreviatura
     *
     * @param abreviatura identificador que del elemento.
     */
    public void delete(@HasText String abreviatura) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> delete({})", abreviatura);
        }
        MotivoBajaPrestamo motivoBajaPrestamo = this.obtenerElementoAbreviatura(abreviatura);
        motivoBajaPrestamo.getConfiguracion().setUltimaActualizacion(new DateTime());
        motivoBajaPrestamoRepository.delete(motivoBajaPrestamo);
    }

    /**
     * Obtiene las entidades del catalogo de tipo MotivoBajaPrestamo.
     *
     * @return List MotivoBajaPrestamo lista de entidades de tipo MotivoBajaPrestamo
     */
    @Transactional(readOnly = true)
    public List<MotivoBajaPrestamo> findAll() {
        LOGGER.info(">> findAll()");
        List<MotivoBajaPrestamo> result = motivoBajaPrestamoRepository.findAll();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("<< findAll(): {}", result);
        }
        return result;
    }

    /**
     * Obtiene un elemento especificado por abreviatura.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     * @return Catalogo.
     */
    public MotivoBajaPrestamo obtenerElementoAbreviatura(@HasText String abreviatura) {
        MotivoBajaPrestamo result = motivoBajaPrestamoRepository.findByAbreviatura(abreviatura);
        if (ObjectUtils.isEmpty(result)) {
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn("<< El elemento con abreviatura {}, no existe.", abreviatura);
                throw new CatalogoNotFoundException("El elemento con abreviatura {"+abreviatura+"}no existe",MotivoBajaPrestamo.class);
            }
        }

        return result;
    }

    /**
     * Obtiene las entidades del catalogo de tipo MotivoBajaPrestamo.
     *
     * @return List MotivoBajaPrestamo
     */
    @Transactional(readOnly = true)
    public Catalogo getAll() {
        List<MotivoBajaPrestamo> result = motivoBajaPrestamoRepository.findAll();
        Catalogo catalogo = null;
        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("<< El catalogo TipoPrenda no contiene elementos.");
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
    public Catalogo recuperarElementoCatalogo(@HasText String abreviatura) {
        MotivoBajaPrestamo result = motivoBajaPrestamoRepository.findByAbreviatura(abreviatura);
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
