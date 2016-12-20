/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import com.codahale.metrics.annotation.Timed;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.RangoOro;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.repository.RangoOroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.dao.DataIntegrityViolationException;

import javax.inject.Inject;
import java.util.List;

/**
 * Servicio para entidades de tipo "RangoOro".
 *
 * @author mmarquez
 */
@Service
@Transactional
public class RangoOroService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RangoOroService.class);

    @Inject
    private RangoOroRepository rangoOroRepository;

    @Inject
    private ConfiguracionCatalogoService configuracionCatalogoService;

    // METODOS

    /**
     * Permite guardar el elemento del catálogo que se recibe como parámetro.
     *
     * @param rangoOro Elemento de tipo RangoOro que se quiere guardar.
     * @return El elemento guardado.
     */
    public RangoOro save(@NotNull RangoOro rangoOro) {
        LOGGER.info(">> save({})", rangoOro);
        rangoOro.setConfiguracion(actualizarConfiguracion());
        try {
            return rangoOroRepository.save(rangoOro);
        } catch (DataIntegrityViolationException e) {
            String mensaje = "No fue posible realizar el guardado de la entidad. El catalogo RangoOro ya " +
                "contiene un elemento con la abreviatura: [" + rangoOro.getAbreviatura() + "].";
            LOGGER.warn(mensaje + " Excepcion: [{}]", e);
            throw e;
        }
    }

    /**
     * Elimina elemento del catalogo de tipo RangoOro por identificador.
     *
     * @param abreviatura
     */
    public void delete(@HasText String abreviatura){
        LOGGER.info(">> delete({})",abreviatura);
        rangoOroRepository.delete(this.get(abreviatura));
        this.actualizarConfiguracion();
    }

    /**
     * Permite obtener el elemento del catálogo RangoOro que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return La entidad que coincida con la abreviatura indicada. NULL en caso de que no haya coincidencia.
     */
    @Timed
    @Transactional(readOnly = true)
    public RangoOro get(@HasText String abreviatura) {
        LOGGER.info(">> get({})", abreviatura);
        RangoOro rangoOro = rangoOroRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(rangoOro)) {
            String mensaje = String.format("El elemento con RangoOro.abreviatura = %s, no existe.", abreviatura);
            LOGGER.warn(mensaje);
            throw new CatalogoNotFoundException(mensaje, RangoOro.class);
        }
        return rangoOro;
    }

    /**
     * Permite obtener todos los elementos del catálogo RangoOro.
     *
     * @return Lista de elementos del catálogo.
     */
    @Timed
    @Transactional(readOnly = true)
    public List<RangoOro> getAll() {
        LOGGER.info(">> getAll()");
        return rangoOroRepository.findAll();
    }

    /**
     * Actualiza elemento de catálgo de tipo Rango Oro.
     *
     * @param rangoOroNuevo
     * @param abreviatura
     * @return RangoOro
     */
    public RangoOro saveAndFlush(@NotNull RangoOro rangoOroNuevo, @HasText String abreviatura){
        LOGGER.info(">> saveAndFlush({})",rangoOroNuevo);

        RangoOro rangoOroOriginal = this.get(abreviatura);

        if (ObjectUtils.isEmpty(rangoOroNuevo.getAbreviatura())) {
            LOGGER.warn("RangoOro.abreviatura = null, se deja valor anterior {}", rangoOroOriginal.getAbreviatura());
        } else {
            rangoOroOriginal.setAbreviatura(rangoOroNuevo.getAbreviatura());
        }

        if (ObjectUtils.isEmpty(rangoOroNuevo.getEtiqueta())) {
            LOGGER.warn("TipoPrenda.etiqueta = null, se deja valor anterior {}", rangoOroOriginal.getEtiqueta());
        } else {
            rangoOroOriginal.setEtiqueta(rangoOroNuevo.getEtiqueta());
        }

        rangoOroOriginal.setConfiguracion(this.actualizarConfiguracion());
        rangoOroRepository.saveAndFlush(rangoOroOriginal);
        return this.get(rangoOroOriginal.getAbreviatura());
    }

    /**
     * Obtiene entidad de tipo RangoOro por identificador.
     *
     * @param id
     * @return RangoOro
     */
    @Timed
    @Transactional(readOnly = true)
    public RangoOro findOne(Long id){
        LOGGER.info(">> findOne({})",id);
        return rangoOroRepository.findOne(id);
    }

    /**
     * Actualiza la fecha de ultima actualización de la configuración del catálogo.
     *
     * @return Regresa el objeto {@link ConfiguracionCatalogo} modificado.
     */
    private ConfiguracionCatalogo actualizarConfiguracion() {
        ConfiguracionCatalogoEnum config = ConfiguracionCatalogoEnum.RANGO_ORO;
        return configuracionCatalogoService.getAndUpdateOperationDate(config.getDominioUnwrap(), config.getTipo());
    }

}
