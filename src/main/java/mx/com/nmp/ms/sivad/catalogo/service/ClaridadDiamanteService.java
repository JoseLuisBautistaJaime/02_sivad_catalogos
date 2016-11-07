/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.ClaridadDiamante;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
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
    public ClaridadDiamante save(@NotNull ClaridadDiamante claridadDiamante){
        LOGGER.info(">> save: [{}]", claridadDiamante.toString());

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
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    public void delete(@HasText String abreviatura) throws CatalogoNotFoundException {
        LOGGER.info(">> delete: [{}]", abreviatura);
        ClaridadDiamante result = claridadDiamanteRespository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(result)){
                String mensaje = "El catalogo ClaridadDiamante no contiene un elemento con la abreviatura [" +  abreviatura + "].";
                throw new CatalogoNotFoundException(mensaje, ClaridadDiamante.class);
            }

        result.getConfiguracion().setUltimaActualizacion(new DateTime());
        claridadDiamanteRespository.delete(result);
    }

    /**
     * Permite obtener el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura
     * @return Objeto {@link ClaridadDiamante} con el elemento que coincida con la abreviatura indicada.
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    @Transactional(readOnly = true)
    public ClaridadDiamante get(@HasText String abreviatura) throws CatalogoNotFoundException{
        LOGGER.info(">> get: [{}]", abreviatura);
        ClaridadDiamante result = claridadDiamanteRespository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(result)){
                String mensaje = "El catalogo ClaridadDiamante no contiene un elemento con la abreviatura [" +  abreviatura + "].";
                throw new CatalogoNotFoundException(mensaje, ClaridadDiamante.class);
            }

        return result;
    }

    /**
     * Permite obtener todos los elementos del catálogo.
     * @return List ClaridadDiamante con la lista de elementos
     */
    @Transactional(readOnly = true)
    public List<ClaridadDiamante> getAll(){
        LOGGER.info(">> getAll");
        List<ClaridadDiamante> result = claridadDiamanteRespository.findAll();

            if(ObjectUtils.isEmpty(result)) {
                LOGGER.warn("El catalogo ClaridadDiamante no contiene elementos.");
                return new ArrayList<>();
            }

        return result;
    }

    /**
     * Permite actualizar el elemento del catálogo que corresponde a la abreviatura indicada.
     *
     * @param abreviatura La abreviatura actual del elemento.
     * @param claridadDiamante Elemento del catálogo con la información que se quiere actualizar.
     * @return El elemento actualizado.
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    public ClaridadDiamante update(@HasText String abreviatura, @NotNull ClaridadDiamante claridadDiamante)
            throws CatalogoNotFoundException {
        LOGGER.info(">> update: [{}]", abreviatura);
        LOGGER.info(">> nueva abreviatura: [{}]", claridadDiamante.getAbreviatura());
        LOGGER.info(">> nueva etiqueta: [{}]", claridadDiamante.getEtiqueta());
        ClaridadDiamante claridadDiamanteOriginal = claridadDiamanteRespository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(claridadDiamanteOriginal)){
                String mensaje = "El catalogo ClaridadDiamante no contiene un elemento con la abreviatura [" +  abreviatura + "].";
                throw new CatalogoNotFoundException(mensaje, ClaridadDiamante.class);
            }

            if (ObjectUtils.isEmpty(claridadDiamante.getAbreviatura())) {
                LOGGER.warn("No se definio nueva abreviatura. Se conserva la abreviatura actual [{}].", claridadDiamanteOriginal.getAbreviatura());
            } else {
                claridadDiamanteOriginal.setAbreviatura(claridadDiamante.getAbreviatura());
            }

            if (ObjectUtils.isEmpty(claridadDiamante.getEtiqueta())) {
                LOGGER.warn("No se definio nueva etiqueta. Se conserva la etiqueta actual [{}].", claridadDiamante.getEtiqueta());
            } else {
                claridadDiamanteOriginal.setEtiqueta(claridadDiamante.getEtiqueta());
            }

        claridadDiamanteOriginal.getConfiguracion().setUltimaActualizacion(new DateTime());
        return claridadDiamanteRespository.save(claridadDiamanteOriginal);

    }
}
