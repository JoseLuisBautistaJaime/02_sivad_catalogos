/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.Corte;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.repository.CorteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import java.awt.print.Pageable;
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



    // METODOS


    /**
     * Permite guardar el elemento del catálogo que se recibe como parámetro.
     *
     * @param corte Elemento de tipo Corte que se quiere guardar.
     * @return El elemento guardado.
     */
    public Corte save(Corte corte) {
        LOGGER.info(">> save");
        return corteRepository.save(corte);
    }

    /**
     * Elimina elemento del catalogo de tipo Corte por identificador.
     *
     * @param id
     */
    public void delete(Long id){
        LOGGER.info(">> delete({})",id);
        corteRepository.delete(id);
    }

    /**
     * Permite obtener el elemento del catálogo Corte que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return La entidad que coincida con la abreviatura indicada. NULL en caso de que no haya coincidencia.
     */
    public Corte get(@HasText String abreviatura) {
        LOGGER.info(">> get: [{}]", abreviatura);
        return corteRepository.findByAbreviatura(abreviatura);
    }

    /**
     * Permite obtener todos los elementos del catálogo Corte.
     *
     * @return Lista de elementos del catálogo.
     */
    public List<Corte> getAll() {
        LOGGER.info(">> getAll");
        return corteRepository.findAll();
    }

    /**
     * Actualiza elemento de catálgo de tipo Corte Diamante.
     *
     * @param corte
     */
    public void saveAndFlush(Corte corte){
        LOGGER.info(">> save({})", corte);
        corteRepository.saveAndFlush(corte);
    }

    /**
     * Obtiene entidad de tipo Corte por identificador.
     *
     * @param id
     * @return Corte
     */
    @Transactional(readOnly=true)
    public Corte findOne(Long id){
        LOGGER.info(">> findOne({})",id);
        return corteRepository.findOne(id);
    }

}