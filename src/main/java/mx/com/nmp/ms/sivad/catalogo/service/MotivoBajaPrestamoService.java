package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.domain.MotivoBajaPrestamo;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.MotivoBajaPrestamoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import java.util.List;

/**
 * Servicio que provee la lógica de negocio para el catalogo de tipo MotivoBajaPrestamo.
 *
 * @author jbautista
 */
@Service
@Transactional
public class MotivoBajaPrestamoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MotivoBajaPrestamoService.class);

    private MotivoBajaPrestamoRepository motivoBajaPrestamoRepository;
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    /**
     * Guarda elemento de catálgo de tipo MotivoBajaPrestamo
     *
     * @param motivoBajaPrestamo
     * @return MotivoBajaPrestamo
     */
    public MotivoBajaPrestamo save(MotivoBajaPrestamo motivoBajaPrestamo){
        LOGGER.info(">> save({})",motivoBajaPrestamo);
        return motivoBajaPrestamoRepository.save(motivoBajaPrestamo);
    }

    /**
     *  Actualiza elemento de catálgo de tipo MotivoBajaPrestamo
     *
     * @param motivoBaja
     */
    public void saveAndFlush(MotivoBajaPrestamo motivoBaja){
        LOGGER.info(">> save({})",motivoBaja);
        motivoBajaPrestamoRepository.saveAndFlush(motivoBaja);
    }

    /**
     * Obtiene entidad de tipo MotivoBajaPrestamo por identificador
     *
     * @param id
     * @return MotivoBajaPrestamo
     */
    @Transactional(readOnly=true)
    public MotivoBajaPrestamo findOne(Long id){
        LOGGER.info(">> findOne({})",id);
        return motivoBajaPrestamoRepository.findOne(id);
    }

    /**
     * Borrar elemento de tipo MotivoBajaPrestamo por id
     *
     * @param id
     */
    public void delete(Long id){
        LOGGER.info(">> delete({})",id);
        motivoBajaPrestamoRepository.delete(id);
    }

    /**
     * Obtiene las entidades del catalogo de tipo MotivoBajaPrestamo.
     *
     * @return List<MotivoBajaPrestamo> lista de entidades de tipo MotivoBajaPrestamo
     */
    @Transactional(readOnly = true)
    public List<MotivoBajaPrestamo> findAll() {
        LOGGER.info(">> findAll()");
        List<MotivoBajaPrestamo> result = motivoBajaPrestamoRepository.findAll();
        LOGGER.debug("<< findAll(): {}", result);
        return result;
    }

    /**
     * Obtiene las entidades del catalogo de tipo MotivoBajaPrestamo.
     *
     * @return List<MotivoBajaPrestamo>
     */
    @Transactional(readOnly=true)
    public Catalogo getAll() {
        List<MotivoBajaPrestamo> result = motivoBajaPrestamoRepository.findAll();
        Catalogo catalogo = null;
        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catálogo TipoPrenda no contiene elementos.");
        } else {
            catalogo = CatalogoFactory.build(result);
        }
        return catalogo;
    }

    /**
     * Asigna el valor del repositorio para el catálogo.
     *
     * @param motivoBajaPrestamoRepository Repositorio para manejar el catálogo.
     */
    @Inject
    public void setMotivoBajaPrestamoRepository(MotivoBajaPrestamoRepository motivoBajaPrestamoRepository) {
        this.motivoBajaPrestamoRepository = motivoBajaPrestamoRepository;
    }

    /**
     * Asigna el valor del repositorio para la configuración del catálogo.
     *
     * @param configuracionCatalogoRepository Repositorio para manejar la configuracion del catálogo..
     */
    @Inject
    public void setConfiguracionCatalogoRepository(ConfiguracionCatalogoRepository configuracionCatalogoRepository) {
        this.configuracionCatalogoRepository = configuracionCatalogoRepository;
    }
}
