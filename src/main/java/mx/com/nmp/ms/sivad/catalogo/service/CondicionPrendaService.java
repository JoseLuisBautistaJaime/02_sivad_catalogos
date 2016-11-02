package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.domain.CondicionPrenda;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.CondicionPrendaRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import java.util.List;

/**
 * Servicio que provee la logica de negocio para el catalogo CondicionPrenda.
 *
 * @author jbautista
 */
@Service
@Transactional
public class CondicionPrendaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CondicionPrendaService.class);

    private CondicionPrendaRepository condicionPrendaRepository;
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    /**
     * Guarda elemento de catálgo de tipo CondicionPrenda.
     *
     * @param condicionPrenda
     * @return CondicionPrenda
     */
    public CondicionPrenda save(CondicionPrenda condicionPrenda){
        LOGGER.info(">> save({})",condicionPrenda);
        return condicionPrendaRepository.save(condicionPrenda);
    }

    /**
     * Actualiza elemento de catálgo de tipo CondicionPrenda.
     *
     * @param condicionPrenda
     */
    public void saveAndFlush(CondicionPrenda condicionPrenda){
        LOGGER.info(">> save({})",condicionPrenda);
         condicionPrendaRepository.saveAndFlush(condicionPrenda);
    }

    /**
     * Obtiene entidad de tipo CondicionPrenda por identificador.
     *
     * @param id
     * @return CondicionPrenda
     */
    @Transactional(readOnly=true)
    public CondicionPrenda findOne(Long id){
        LOGGER.info(">> findOne({})",id);
        return condicionPrendaRepository.findOne(id);
    }

    /**
     * Elimina elemento del catalogo de tipo CondicionPrenda por identificador.
     *
     * @param id
     */
    public void delete(Long id){
        LOGGER.info(">> delete({})",id);
        condicionPrendaRepository.delete(id);
    }

    /**
     * Obtiene las entidades del catalogo de tipo CondicionPrenda.
     *
     * @return List CondicionPrenda lista de entidades de tipo CondicionPrenda
     */
    @Transactional(readOnly = true)
    public List<CondicionPrenda> findAll() {
        LOGGER.info(">> findAll()");
        List<CondicionPrenda> result = condicionPrendaRepository.findAll();
        LOGGER.debug("<< findAll(): {}", result);
        return result;
    }

    /**
     * Obtiene los elementos del catalogo con formato JSON.
     *
     * @return Catalogo.
     */
    public Catalogo getAll() {
        List<CondicionPrenda> result = condicionPrendaRepository.findAll();
        Catalogo catalogo = null;
        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catalogo no contiene elementos.");
        } else {
            catalogo = CatalogoFactory.build(result);
        }
        return catalogo;
    }


    /**
     * Asigna el valor del repositorio para el catálogo.
     *
     * @param condicionPrendaRepository
     */
    @Inject
    public void setCondicionPrendaRepository(CondicionPrendaRepository condicionPrendaRepository) {
        this.condicionPrendaRepository = condicionPrendaRepository;
    }

    /**
     * Asigna el valor del repositorio para la configuración del catálogo.
     *
     * @param configuracionCatalogoRepository
     */
    @Inject
    public void setConfiguracionCatalogoRepository(ConfiguracionCatalogoRepository configuracionCatalogoRepository) {
        this.configuracionCatalogoRepository = configuracionCatalogoRepository;
    }

}
