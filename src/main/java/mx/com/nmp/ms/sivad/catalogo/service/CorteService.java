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
import mx.com.nmp.ms.sivad.catalogo.domain.Corte;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.repository.CorteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import java.util.List;

/**
 * Servicio para entidades de tipo Corte.
 *
 * @author mmarquez
 */
@Service
@Transactional
public class CorteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CorteService.class);

    @Inject
    private CorteRepository corteRepository;

    @Inject
    private ConfiguracionCatalogoService configuracionCatalogoService;

    // METODOS


    /**
     * Permite guardar el elemento del catálogo que se recibe como parámetro.
     *
     * @param corte Elemento de tipo Corte que se quiere guardar.
     * @return El elemento guardado.
     */
    public Corte save(@NotNull Corte corte) {
        LOGGER.info(">> save({})", corte);
        corte.setConfiguracion(actualizarConfiguracion());
        return corteRepository.save(corte);
    }

    /**
     * Elimina elemento del catalogo de tipo RangoOro por identificador.
     *
     * @param abreviatura
     */
    public void delete(@HasText String abreviatura){
        LOGGER.info(">> delete({})",abreviatura);
        corteRepository.delete(this.get(abreviatura));
        this.actualizarConfiguracion();
    }

    /**
     * Permite obtener el elemento del catálogo Corte que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return La entidad que coincida con la abreviatura indicada. NULL en caso de que no haya coincidencia.
     */
    @Timed
    @Transactional(readOnly = true)
    public Corte get(@HasText String abreviatura) {
        LOGGER.info(">> get({})", abreviatura);
        Corte corte = corteRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(corte)) {
            String mensaje = String.format("El elemento con Corte abreviatura = %s, no existe.", abreviatura);
            LOGGER.warn(mensaje);
            throw new CatalogoNotFoundException(mensaje, Corte.class);
        }
        return corte;
    }

    /**
     * Permite obtener todos los elementos del catálogo Corte.
     *
     * @return Lista de elementos del catálogo.
     */
    @Timed
    @Transactional(readOnly = true)
    public List<Corte> getAll() {
        LOGGER.info(">> getAll()");
        return corteRepository.findAll();
    }

    /**
     * Actualiza elemento de catálgo de tipo Rango Oro.
     *
     * @param corteNuevo
     * @param abreviatura
     * @return Corte
     */
    public Corte saveAndFlush(@NotNull Corte corteNuevo, @HasText String abreviatura){
        LOGGER.info(">> saveAndFlush({})", corteNuevo);

        Corte corteOriginal = this.get(abreviatura);

        if (ObjectUtils.isEmpty(corteNuevo.getAbreviatura())) {
            LOGGER.warn("Corte.abreviatura = null, se deja valor anterior {}", corteOriginal.getAbreviatura());
        } else {
            corteOriginal.setAbreviatura(corteNuevo.getAbreviatura());
        }

        if (ObjectUtils.isEmpty(corteNuevo.getEtiqueta())) {
            LOGGER.warn("TipoPrenda.etiqueta = null, se deja valor anterior {}", corteOriginal.getEtiqueta());
        } else {
            corteOriginal.setEtiqueta(corteNuevo.getEtiqueta());
        }

        corteOriginal.setConfiguracion(this.actualizarConfiguracion());
        corteRepository.saveAndFlush(corteOriginal);
        return this.get(corteOriginal.getAbreviatura());
    }

    /**
     * Obtiene entidad de tipo Corte por identificador.
     *
     * @param id
     * @return Corte
     */
    @Timed
    @Transactional(readOnly = true)
    public Corte findOne(Long id){
        LOGGER.info(">> findOne({})",id);
        return corteRepository.findOne(id);
    }

    /**
     * Actualiza la fecha de ultima actualización de la configuración del catálogo.
     *
     * @return Regresa el objeto {@link ConfiguracionCatalogo} modificado.
     */
    private ConfiguracionCatalogo actualizarConfiguracion() {
        ConfiguracionCatalogoEnum config = ConfiguracionCatalogoEnum.CORTE;
        return configuracionCatalogoService.getAndUpdateOperationDate(config.getDominioUnwrap(), config.getTipo());
    }

}
