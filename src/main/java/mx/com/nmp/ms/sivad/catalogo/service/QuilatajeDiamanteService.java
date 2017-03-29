/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.QuilatajeDiamante;
import mx.com.nmp.ms.sivad.catalogo.domain.QuilatajeOro;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.QuilatajeDiamanteRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.QuilatajeOroRepository;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que expone los metodos para la administración del catalogo Quilataje Diamante.
 *
 * @author jbautista
 */
@Service
@Transactional
public class QuilatajeDiamanteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuilatajeDiamanteService.class);

    @Inject
    private QuilatajeDiamanteRepository quilatajeDiamanteRepository;

    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    /**
     * Permite guardar el elemento del catálogo que se recibe como parámetro.
     *
     * @param quilatajeDiamante Elemento del catálogo que se quiere guardar.
     * @return QuilatajeDiamante elemento guardado.
     */
    public QuilatajeDiamante save(@NotNull QuilatajeDiamante quilatajeDiamante) {
        LOGGER.info(">> save: [{}]", quilatajeDiamante.toString());

        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
            ConfiguracionCatalogoEnum.QUILATAJE_DIAMANTE.getDominioUnwrap(),
            ConfiguracionCatalogoEnum.QUILATAJE_DIAMANTE.getTipo());

        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        quilatajeDiamante.setConfiguracion(configuracionCatalogo);

        try {
            return quilatajeDiamanteRepository.save(quilatajeDiamante);
        } catch (DataIntegrityViolationException e) {
            String mensaje = "No fue posible guardar la entidad de tipo QuilatajeDiamante ya " +
                "contiene un elemento con la abreviatura: [" + quilatajeDiamante.getAbreviatura() + "].";
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn(mensaje + " Excepcion: [{}]", e);
            }
            throw e;
        }
    }

    /**
     * Permite eliminar el elemento del catalogo que coincida con la abreviatura.
     *
     * @param abreviatura La abreviatura.
     */
    public void delete(@HasText String abreviatura) {
        if(LOGGER.isInfoEnabled()) {
            LOGGER.info(">> delete: [{}]", abreviatura);
        }

        QuilatajeDiamante quilatajeDiamante = obtenerElemento(abreviatura);
        quilatajeDiamante.getConfiguracion().setUltimaActualizacion(new DateTime());
        quilatajeDiamanteRepository.delete(quilatajeDiamante);
    }

    /**
     * Permite obtener el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return Objeto {@link Catalogo} con el elemento que coincida con la abreviatura indicada.
     */
    @Transactional(readOnly = true)
    public QuilatajeDiamante get(@HasText String abreviatura) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> get: [{}]", abreviatura);
        }

        return obtenerElemento(abreviatura);
    }

    /**
     * Permite obtener todos los elementos del catálogo.
     *
     * @return Objeto {@link Catalogo} con la lista de elementos del catalogo.
     */
    @Transactional(readOnly = true)
    public List<QuilatajeDiamante> getAll() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> getAll");
        }

        List<QuilatajeDiamante> result = quilatajeDiamanteRepository.findAll();
        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catalogo no contiene elementos.");
            return new ArrayList<>();
        }

        return result;
    }

    /**
     * Permite actualizar la información del elemento del catálogo que se recibe como parámetro.
     *
     * @param abreviatura La abreviatura actual del elemento a actualizar.
     * @param quilatajeDiamante Elemento del catálogo con la nueva información.
     * @return QuilatajeDiamante elemento actualizado.
     */
    public QuilatajeDiamante update(@HasText String abreviatura, @NotNull QuilatajeDiamante quilatajeDiamante) {
        if (LOGGER.isInfoEnabled()){
            LOGGER.info(">> update: [{}], [{}]", abreviatura, quilatajeDiamante.toString());
        }

        QuilatajeDiamante quilatajeDiamanteOriginal = obtenerElemento(abreviatura);
        if (ObjectUtils.isEmpty(quilatajeDiamante.getAbreviatura())) {
            LOGGER.warn("No se definio nueva abreviatura. Se conserva la abreviatura actual [{}].",
                quilatajeDiamanteOriginal.getAbreviatura());
        } else {
            quilatajeDiamanteOriginal.setAbreviatura(quilatajeDiamante.getAbreviatura());
        }

        if (ObjectUtils.isEmpty(quilatajeDiamante.getEtiqueta())) {
            LOGGER.warn("No se definio nueva etiqueta. Se conserva la etiqueta actual [{}].",
                quilatajeDiamanteOriginal.getEtiqueta());
        } else {
            quilatajeDiamanteOriginal.setEtiqueta(quilatajeDiamante.getEtiqueta());
        }

        quilatajeDiamanteOriginal.getConfiguracion().setUltimaActualizacion(new DateTime());

        try {
            return quilatajeDiamanteRepository.saveAndFlush(quilatajeDiamanteOriginal);
        } catch (DataIntegrityViolationException e) {
            String mensaje = "No fue posible realizar la actualizacion de la entidad. El catalogo QuilatajeDiamante ya " +
                "contiene un elemento con la abreviatura: [" + quilatajeDiamante.getAbreviatura() + "].";
            LOGGER.warn(mensaje + " Excepcion: [{}]", e);
            throw e;
        }
    }

    /**
     * Metodo auxiliar que factoriza la lógica de obtener un elemento del catálogo por abreviatura.
     *
     * @param abreviatura La abreviatura.
     * @return QuilatajeDiamante elemento obtenido.
     */
    private QuilatajeDiamante obtenerElemento(String abreviatura) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> obtenerElemento: [{}]", abreviatura);
        }

        QuilatajeDiamante quilatajeDiamante = quilatajeDiamanteRepository.findByAbreviatura(abreviatura);
        if (ObjectUtils.isEmpty(quilatajeDiamante)) {
            String mensaje =
                "El catalogo QuilatajeDiamante no contiene un elemento con la abreviatura: [" + abreviatura + "].";
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn(mensaje);
            }
            throw new CatalogoNotFoundException(mensaje, QuilatajeDiamante.class);
        }

        return quilatajeDiamante;
    }

}
