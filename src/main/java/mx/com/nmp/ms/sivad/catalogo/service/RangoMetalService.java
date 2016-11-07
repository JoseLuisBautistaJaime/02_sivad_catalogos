/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import com.codahale.metrics.annotation.Timed;
import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.RangoMetal;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.repository.RangoMetalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import java.util.List;

/**
 * Servicio para entidades de tipo "RangoMetal".
 *
 * @author mmarquez
 */
@Service
@Transactional
public class RangoMetalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RangoMetalService.class);

    @Inject
    private RangoMetalRepository rangoMetalRepository;

    @Inject
    private ConfiguracionCatalogoService configuracionCatalogoService;

    // METODOS

    /**
     * Permite guardar el elemento del catálogo que se recibe como parámetro.
     *
     * @param rangoMetal Elemento de tipo RangoMetal que se quiere guardar.
     * @return RangoMetal El elemento guardado.
     */
    public RangoMetal save(@NotNull RangoMetal rangoMetal) {
        LOGGER.info(">> save({})", rangoMetal);
        rangoMetal.setConfiguracion(actualizarConfiguracion());
        return rangoMetalRepository.save(rangoMetal);
    }

    /**
     * Elimina elemento del catalogo de tipo RangoMetal por identificador.
     *
     * @param abreviatura
     */
    public void delete(@HasText String abreviatura){
        LOGGER.info(">> delete({})",abreviatura);
        rangoMetalRepository.delete(this.get(abreviatura));
        this.actualizarConfiguracion();
    }

    /**
     * Permite obtener el elemento del catálogo RangoMetal que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return La entidad que coincida con la abreviatura indicada. NULL en caso de que no haya coincidencia.
     */
    @Timed
    @Transactional(readOnly = true)
    public RangoMetal get(@HasText String abreviatura) {
        LOGGER.info(">> get({})", abreviatura);
        RangoMetal rangoMetal = rangoMetalRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(rangoMetal)) {
            String mensaje = String.format("El elemento con RangoMetal.abreviatura = %s, no existe.", abreviatura);
            LOGGER.warn(mensaje);
            throw new CatalogoNotFoundException(mensaje, RangoMetal.class);
        }
        return rangoMetalRepository.findByAbreviatura(abreviatura);
    }

    /**
     * Permite obtener todos los elementos del catálogo RangoMetal.
     *
     * @return Lista de elementos del catálogo.
     */
    @Timed
    @Transactional(readOnly = true)
    public List<RangoMetal> getAll() {
        LOGGER.info(">> getAll()");
        return rangoMetalRepository.findAll();
    }

    /**
     * Actualiza elemento de catálgo de tipo Rango Metal.
     *
     * @param rangoMetalNuevo
     * @param abreviatura
     */
    public RangoMetal saveAndFlush(@NotNull RangoMetal rangoMetalNuevo, @HasText String abreviatura){
            LOGGER.info(">> saveAndFlush({})",rangoMetalNuevo);

            RangoMetal rangoMetalOriginal = this.get(abreviatura);

            if (ObjectUtils.isEmpty(rangoMetalNuevo.getAbreviatura())) {
                LOGGER.warn("RangoOro.abreviatura = null, se deja valor anterior {}", rangoMetalOriginal.getAbreviatura());
            } else {
                rangoMetalOriginal.setAbreviatura(rangoMetalNuevo.getAbreviatura());
            }

            if (ObjectUtils.isEmpty(rangoMetalNuevo.getEtiqueta())) {
                LOGGER.warn("TipoPrenda.etiqueta = null, se deja valor anterior {}", rangoMetalOriginal.getEtiqueta());
            } else {
                rangoMetalOriginal.setEtiqueta(rangoMetalNuevo.getEtiqueta());
            }

            rangoMetalOriginal.setConfiguracion(this.actualizarConfiguracion());
            rangoMetalRepository.saveAndFlush(rangoMetalOriginal);
            return this.get(rangoMetalOriginal.getAbreviatura());
    }

    /**
     * Obtiene entidad de tipo RangoMetal por identificador.
     *
     * @param id
     * @return RangoMetal
     */
    @Timed
    @Transactional(readOnly = true)
    public RangoMetal findOne(Long id){
        LOGGER.info(">> findOne({})",id);
        return rangoMetalRepository.findOne(id);
    }

    /**
     * Actualiza la fecha de ultima actualización de la configuración del catálogo.
     *
     * @return Regresa el objeto {@link ConfiguracionCatalogo} modificado.
     */
    private ConfiguracionCatalogo actualizarConfiguracion() {
        ConfiguracionCatalogoEnum config = ConfiguracionCatalogoEnum.RANGO_METAL;
        return configuracionCatalogoService.getAndUpdateOperationDate(config.getDominioUnwrap(), config.getTipo());
    }

}
