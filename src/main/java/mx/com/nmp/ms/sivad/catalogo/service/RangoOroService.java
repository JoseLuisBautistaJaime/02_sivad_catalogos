/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.sivad.catalogo.domain.RangoOro;
import mx.com.nmp.ms.sivad.catalogo.repository.RangoOroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

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



    // METODOS

    /**
     * Permite guardar el elemento del catálogo que se recibe como parámetro.
     *
     * @param rangoOro Elemento de tipo RangoOro que se quiere guardar.
     * @return El elemento guardado.
     */
    public RangoOro save(RangoOro rangoOro) {
        LOGGER.info(">> save");
        return rangoOroRepository.save(rangoOro);
    }

    /**
     * Elimina elemento del catalogo de tipo RangoOro por identificador.
     *
     * @param id
     */
    public void delete(Long id){
        LOGGER.info(">> delete({})",id);
        rangoOroRepository.delete(id);
    }

    /**
     * Permite obtener el elemento del catálogo RangoOro que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return La entidad que coincida con la abreviatura indicada. NULL en caso de que no haya coincidencia.
     */
    public RangoOro get(@HasText String abreviatura) {
        LOGGER.info(">> get: [{}]", abreviatura);
        return rangoOroRepository.findByAbreviatura(abreviatura);
    }

    /**
     * Permite obtener todos los elementos del catálogo RangoOro.
     *
     * @return Lista de elementos del catálogo.
     */
    public List<RangoOro> getAll() {
        LOGGER.info(">> getAll");
        return rangoOroRepository.findAll();
    }

    /**
     * Actualiza elemento de catálgo de tipo Rango Oro.
     *
     * @param RangoOro
     */
    public void saveAndFlush(RangoOro rangoOro){
        LOGGER.info(">> save({})",rangoOro);
        rangoOroRepository.saveAndFlush(rangoOro);
    }

    /**
     * Obtiene entidad de tipo RangoOro por identificador.
     *
     * @param id
     * @return RangoOro
     */
    @Transactional(readOnly=true)
    public RangoOro findOne(Long id){
        LOGGER.info(">> findOne({})",id);
        return rangoOroRepository.findOne(id);
    }
}