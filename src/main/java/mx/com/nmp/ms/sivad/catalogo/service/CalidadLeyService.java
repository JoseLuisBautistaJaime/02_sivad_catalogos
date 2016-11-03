package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.CalidadLey;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.CalidadLeyRepository;
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
        LOGGER.info(">> save({})", calidadLey);
        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
                ConfiguracionCatalogoEnum.CALIDAD_LEY.getDominioUnwrap(),
                ConfiguracionCatalogoEnum.CALIDAD_LEY.getTipo());
        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        calidadLey.setConfiguracion(configuracionCatalogo);

        return calidadLeyRepository.save(calidadLey);
    }

    /**
     * Actualiza elemento de catalogo de tipo CalidadLey.
     *
     * @param abreviatura abreviatura del elemento que sera modificado.
     * @param calidadLey  objeto a modificar.
     * @return CalidadLey
     */
    public CalidadLey update(@NotNull String abreviatura, @NotNull CalidadLey calidadLey) {
        LOGGER.info(">> update({})", abreviatura);

        CalidadLey calidadLeyActual = calidadLeyRepository.findByAbreviatura(abreviatura);
        calidadLeyActual.setEtiqueta(calidadLey.getEtiqueta());
        calidadLeyActual.setAbreviatura(calidadLey.getAbreviatura());
        calidadLeyActual.getConfiguracion().setUltimaActualizacion(new DateTime());

        return calidadLeyRepository.save(calidadLeyActual);
    }

    /**
     * Obtiene entidad de tipo CalidadLey por identificador.
     *
     * @param id identificador de elemento que sera buscado
     * @return CalidadLey
     */
    @Transactional(readOnly = true)
    public CalidadLey findOne(@NotNull Long id) {
        LOGGER.info(">> findOne({})", id);
        return calidadLeyRepository.findOne(id);
    }

    /**
     * Elimina elemento del catalogo de tipo CalidadLey por identificador.
     *
     * @param id del elemento que sera eliminado
     */
    public void delete(@NotNull Long id) {
        LOGGER.info(">> delete({})", id);
        CalidadLey calidadLey = calidadLeyRepository.findOne(id);
        calidadLey.getConfiguracion().setUltimaActualizacion(new DateTime());
        calidadLeyRepository.delete(id);
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
        LOGGER.debug("<< findAll(): {}", result);
        return result;
    }

    /**
     * Obtiene los elementos del catalogo con formato JSON.
     *
     * @return Catalogo.
     */
    @Transactional(readOnly = true)
    public Catalogo getAll() {
        List<CalidadLey> result = calidadLeyRepository.findAll();
        Catalogo catalogo = null;
        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catalogo CalidadLey no contiene elementos.");
        } else {
            catalogo = CatalogoFactory.build(result);
        }
        return catalogo;
    }

}
