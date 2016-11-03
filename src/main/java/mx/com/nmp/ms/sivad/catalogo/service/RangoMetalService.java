/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.sivad.catalogo.domain.RangoMetal;
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



    // METODOS

    /**
     * Permite guardar el elemento del catálogo que se recibe como parámetro.
     *
     * @param rangoMetal Elemento de tipo RangoMetal que se quiere guardar.
     * @return El elemento guardado.
     */
    public RangoMetal save(RangoMetal rangoMetal) {
        LOGGER.info(">> save");
        return rangoMetalRepository.save(rangoMetal);
    }

    /**
     * Elimina elemento del catalogo de tipo RangoMetal por identificador.
     *
     * @param id
     */
    public void delete(Long id){
        LOGGER.info(">> delete({})",id);
        rangoMetalRepository.delete(id);
    }

    /**
     * Permite obtener el elemento del catálogo RangoMetal que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return La entidad que coincida con la abreviatura indicada. NULL en caso de que no haya coincidencia.
     */
    public RangoMetal get(@HasText String abreviatura) {
        LOGGER.info(">> get: [{}]", abreviatura);
        return rangoMetalRepository.findByAbreviatura(abreviatura);
    }

    /**
     * Permite obtener todos los elementos del catálogo RangoMetal.
     *
     * @return Lista de elementos del catálogo.
     */
    public List<RangoMetal> getAll() {
        LOGGER.info(">> getAll");
        return rangoMetalRepository.findAll();
    }

    /**
     * Actualiza elemento de catálgo de tipo Rango Metal.
     *
     * @param rangoMetal
     */
    public void saveAndFlush(RangoMetal rangoMetal){
        LOGGER.info(">> save({})",rangoMetal);
        rangoMetalRepository.saveAndFlush(rangoMetal);
    }

    /**
     * Obtiene entidad de tipo RangoMetal por identificador.
     *
     * @param id
     * @return RangoMetal
     */
    @Transactional(readOnly=true)
    public RangoMetal findOne(Long id){
        LOGGER.info(">> findOne({})",id);
        return rangoMetalRepository.findOne(id);
    }

}