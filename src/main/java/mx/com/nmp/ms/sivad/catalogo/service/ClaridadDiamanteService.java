/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.sivad.catalogo.domain.ClaridadDiamante;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.ClaridadDiamanteRespository;

import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que expone los metodos para la administración del catálogo de Claridad Diamante
 *
 * @author roramirez
 */
@Service
@Transactional
public class ClaridadDiamanteService {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ClaridadDiamanteService.class);

    /**
     * Referencia al repositorio de ClaridadDiamanteRepository.
     */
    @Inject
    private ClaridadDiamanteRespository claridadDiamanteRespository;

    /**
     * Referencia al repositorio de ConfiguracionCatalogoRepository.
     */
    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    //METODOS

    /**
     * Permite guardar el elemento del catálogo que se recibe como parámetro.
     *
     * @param claridadDiamante Elemento del catálogo que se quiere guardar.
     * @return El elemento guardado.
     */
    public ClaridadDiamante save(ClaridadDiamante claridadDiamante){
        LOGGER.info(">> save");
        ClaridadDiamante result =  claridadDiamanteRespository.findByAbreviatura(claridadDiamante.getAbreviatura());

            if(!ObjectUtils.isEmpty(result)){
                LOGGER.error("No fue posible realizar el guardado. " +
                                "El catalogo ClaridadDiamnte ya contiene un elemento con la abreviatura: [{}].",
                        claridadDiamante.getAbreviatura());
                return null;
            }

        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
                ConfiguracionCatalogoEnum.CLARIDAD_DIAMANTE.getDominioUnwrap(),
                ConfiguracionCatalogoEnum.CLARIDAD_DIAMANTE.getTipo());

        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        claridadDiamante.setConfiguracion(configuracionCatalogo);
        return claridadDiamanteRespository.save(claridadDiamante);
    }

    /**
     * Permite eliminar el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return TRUE si se eliminó el elemento del catálogo y FALSE en caso contrario.
     */
    public boolean delete(@HasText String abreviatura){
        LOGGER.info(">> delete: [{}]", abreviatura);
        ClaridadDiamante result = claridadDiamanteRespository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(result)){
                LOGGER.warn("No fue posible realizar la eliminacion. " +
                        "El catalogo ClaridadDiamante no contiene un elemento con la abreviatura [{}]", abreviatura);
                return false;
            }

        result.getConfiguracion().setUltimaActualizacion(new DateTime());
        claridadDiamanteRespository.delete(result);
        return true;
    }

    /**
     * Permite obtener el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return Objeto {@link Catalogo} con el elemento que coincida con la abreviatura indicada.
     * NULL en caso de no existir coincidencia.
     */
    public Catalogo get(@HasText String abreviatura){
        LOGGER.info(">> get: [{}]", abreviatura);
        ClaridadDiamante result = claridadDiamanteRespository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(result)){
                LOGGER.warn("No fue posible realizar la consulta. " +
                        "El catalogo ClaridadDiamante no contiene un elemento con la abreviatura: [{}].", abreviatura);
                return null;
            }

        return CatalogoFactory.build(result);
    }

    /**
     * Permite obtener todos los elementos del catálogo.
     *
     * @return Objeto {@link Catalogo} con la lista de elementos del catálogo.
     */
    public Catalogo getAll(){
        LOGGER.info(">> getAll");
        List<ClaridadDiamante> result = claridadDiamanteRespository.findAll();

            if(ObjectUtils.isEmpty(result)) {
                LOGGER.warn("El catalogo ClaridadDiamante no contiene elementos.");
                return CatalogoFactory.build(new ArrayList<ClaridadDiamante>());
            }

        return CatalogoFactory.build(result);
    }

    /**
     * Permite actualizar el elemento del catálogo que corresponde a la abreviatura indicada.
     *
     * @param abreviatura La abreviatura actual del elemento.
     * @param claridadDiamante Elemento del catálogo con la información que se quiere actualizar.
     * @return El elemento actualizado o NULL en caso de no poder realizar la actualización.
     */
    public ClaridadDiamante update(String abreviatura, ClaridadDiamante claridadDiamante){
        LOGGER.info(">> update: [{}]", abreviatura);
        LOGGER.info(">> nueva abreviatura: [{}]", claridadDiamante.getAbreviatura());
        LOGGER.info(">> nueva etiqueta: [{}]", claridadDiamante.getEtiqueta());
        ClaridadDiamante claridadDiamanteOriginal = claridadDiamanteRespository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(claridadDiamanteOriginal)){
                LOGGER.warn("No fue posible realizar la actualizacion. " +
                        "El catalogo ClaridadDiamantes no contiene un elemento con la abreviatura: [{}].", abreviatura);
                return null;
            }

        claridadDiamanteOriginal.setAbreviatura(claridadDiamante.getAbreviatura());
        claridadDiamanteOriginal.setEtiqueta(claridadDiamante.getEtiqueta());
        claridadDiamanteOriginal.getConfiguracion().setUltimaActualizacion(new DateTime());
        return claridadDiamanteRespository.save(claridadDiamanteOriginal);

    }
}
