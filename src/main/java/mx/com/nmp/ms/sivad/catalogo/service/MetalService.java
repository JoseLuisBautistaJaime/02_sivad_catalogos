package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.Metal;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.MetalRepository;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        LOGGER.info(">> save({})", metal);
        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
                ConfiguracionCatalogoEnum.METAL.getDominioUnwrap(),
                ConfiguracionCatalogoEnum.METAL.getTipo());
        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        metal.setConfiguracion(configuracionCatalogo);

        return metalRepository.save(metal);
    }

    /**
     * Actualiza elemento de catalogo de tipo Metal.
     *
     * @param abreviatura abreviatura del elemento que sera modificado.
     * @param metal       objeto a modificar.
     * @return Metal
     */
    public Metal update(@NotNull String abreviatura, @NotNull Metal metal) {
        LOGGER.info(">> update({})", abreviatura);

        Metal metalActual = metalRepository.findByAbreviatura(abreviatura);
        metalActual.setEtiqueta(metal.getEtiqueta());
        metalActual.setAbreviatura(metal.getAbreviatura());
        metalActual.getConfiguracion().setUltimaActualizacion(new DateTime());

        return metalRepository.save(metalActual);
    }

    /**
     * Obtiene entidad de tipo Metal por identificador.
     *
     * @param id identificador de elemento que sera buscado
     * @return Metal
     */
    @Transactional(readOnly = true)
    public Metal findOne(@NotNull Long id) {
        LOGGER.info(">> findOne({})", id);
        return metalRepository.findOne(id);
    }

    /**
     * Elimina elemento del catalogo de tipo Metal por identificador.
     *
     * @param id del elemento que sera eliminado
     */
    public void delete(@NotNull Long id) {
        LOGGER.info(">> delete({})", id);
        Metal metal = metalRepository.findOne(id);
        metal.getConfiguracion().setUltimaActualizacion(new DateTime());
        metalRepository.delete(id);
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
        List<Metal> result = metalRepository.findAll();
        Catalogo catalogo = null;
        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catalogo Metal no contiene elementos.");
        } else {
            catalogo = CatalogoFactory.build(result);
        }
        return catalogo;
    }

}
