package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;

/**
 * Lógica de negocio para ConfiguracionCatalogo
 *
 * @author osanchez
 */
@Service
@Transactional
public class ConfiguracionCatalogoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfiguracionCatalogoService.class);

    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    /**
     * Obtener entidad de tipo CondicionPrenda por id
     *
     * @param id Identificador
     * @return CondicionPrenda
     */
    @Transactional(readOnly=true)
    public ConfiguracionCatalogo findOne(Long id){
        LOGGER.info(">> findOne({})",id);
        return configuracionCatalogoRepository.findOne(id);
    }

    /**
     * Obtener todas las configuraciones de catalogo
     *
     * @param paginacion información de paginación
     * @return listado de configuraciones
     */
    @Transactional(readOnly = true)
    public Page<ConfiguracionCatalogo> findAll(Pageable paginacion) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(">> findAll({})", paginacion);
        }

        return configuracionCatalogoRepository.findAll(paginacion);
    }

    /**
     * Recupera la configuración de un catálogo, filtrando por {@link ConfiguracionCatalogo#dominio}
     * y {@link ConfiguracionCatalogo#tipo}
     * Actualiza la fecha de última actualización, establece la fecha y hora en la que se realiza la
     * invocación a éste método.
     *
     * @param dominio Nombre del dominio.
     * @param tipo Nombre del tipo de Catálogo.
     *
     * @return Regresa el objeto {@link ConfiguracionCatalogo} modificado.
     *
     * @throws CatalogoNotFoundException Cuando no existe la configuración buscada.
     */
    public ConfiguracionCatalogo getAndUpdateOperationDate(@HasText String dominio, @HasText String tipo) {
        ConfiguracionCatalogo configuracion = configuracionCatalogoRepository.findByDominioAndTipo(dominio, tipo);

        if (ObjectUtils.isEmpty(configuracion)) {
            String mensaje = String.format("ConfiguracionCatalogo[dominio = %s, tipo = %s], no existe.",
                    dominio, tipo);
            LOGGER.warn(mensaje);
            throw new CatalogoNotFoundException(mensaje, ConfiguracionCatalogo.class);
        }

        configuracion.setUltimaActualizacion(DateTime.now());
        LOGGER.info("Se actualiza fecha de ultima actualización UltimaActualizacion = {}",
                configuracion.getUltimaActualizacion());

        return configuracion;
    }
}
