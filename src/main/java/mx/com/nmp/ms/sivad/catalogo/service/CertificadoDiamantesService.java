/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.sivad.catalogo.domain.CertificadoDiamantes;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.CertificadoDiamantesRepository;
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
 * Servicio que expone los metodos para la administración del catálogo de Certificado Diamantes
 *
 * @author roramirez
 */
@Service
@Transactional
public class CertificadoDiamantesService {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CertificadoDiamantesService.class);
    /**
     * Referencia al repositorio de ClaridadDiamanteRepository.
     */
    @Inject
    private CertificadoDiamantesRepository certificadoDiamantesRepository;

    /**
     * Referencia al repositorio de ConfiguracionCatalogoRepository.
     */
    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    //METODOS

    /**
     * Permite guardar el elemento del catálogo que se recibe como parámetro.
     *
     * @param certificadoDiamantes Elemento del catálogo que se quiere guardar.
     * @return El elemento guardado.
     */
    public CertificadoDiamantes save(CertificadoDiamantes certificadoDiamantes){
        LOGGER.info(">> save");
        CertificadoDiamantes result =  certificadoDiamantesRepository.findByAbreviatura(certificadoDiamantes.getAbreviatura());

            if(!ObjectUtils.isEmpty(result)){
                LOGGER.error("No fue posible realizar el guardado. " +
                        "El catalogo CertificadoDiamantes ya contiene un elemento con la abreviatura: [{}].",
                        certificadoDiamantes.getAbreviatura());
                return null;
            }
        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
                ConfiguracionCatalogoEnum.CERTIFICADO_DIAMANTES.getDominioUnwrap(),
                ConfiguracionCatalogoEnum.CERTIFICADO_DIAMANTES.getTipo());

        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        certificadoDiamantes.setConfiguracion(configuracionCatalogo);
        return certificadoDiamantesRepository.save(certificadoDiamantes);
    }

    /**
     * Permite eliminar el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return TRUE si se eliminó el elemento del catálogo y FALSE en caso contrario.
     */
    public boolean delete(@HasText String abreviatura){
        LOGGER.info(">> delete: [{}]", abreviatura);
        CertificadoDiamantes result = certificadoDiamantesRepository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(result)){
                LOGGER.warn("No fue posible realizar la eliminacion. "  +
                        "El catalogo CertificadoDiamantes no contiene un elemento con la abreviatura [{}]", abreviatura);
                return false;
            }

        result.getConfiguracion().setUltimaActualizacion(new DateTime());
        certificadoDiamantesRepository.delete(result);
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
        CertificadoDiamantes result = certificadoDiamantesRepository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(result)){
                LOGGER.warn("No fue posible realizar la consulta. " +
                        "El catalogo CertificadoDiamantes no contiene un elemento con la abreviatura: [{}].", abreviatura);
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
        List<CertificadoDiamantes> result = certificadoDiamantesRepository.findAll();

            if(ObjectUtils.isEmpty(result)) {
                LOGGER.warn("El catalogo CertificadoDiamantes no contiene elementos.");
                return CatalogoFactory.build(new ArrayList<CertificadoDiamantes>());
            }

        return CatalogoFactory.build(result);
    }

    /**
     * Permite actualizar el elemento del catálogo que corresponde a la abreviatura indicada.
     *
     * @param abreviatura La abreviatura actual del elemento.
     * @param certificadoDiamantes Elemento del catálogo con la información que se quiere actualizar.
     * @return El elemento actualizado o NULL en caso de no poder realizar la actualización.
     */
    public CertificadoDiamantes update(String abreviatura, CertificadoDiamantes certificadoDiamantes){
        LOGGER.info(">> update: [{}]", abreviatura);
        LOGGER.info(">> nueva abreviatura: [{}]", certificadoDiamantes.getAbreviatura());
        LOGGER.info(">> nueva etiqueta: [{}]", certificadoDiamantes.getEtiqueta());
        CertificadoDiamantes certificadoDiamantesOriginal = certificadoDiamantesRepository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(certificadoDiamantesOriginal)){
                LOGGER.warn("No fue posible realizar la actualizacion. " +
                        "El catalogo CertificadoDiamantes no contiene un elemento con la abreviatura: [{}].", abreviatura);
                return null;
            }

        certificadoDiamantesOriginal.setAbreviatura(certificadoDiamantes.getAbreviatura());
        certificadoDiamantesOriginal.setEtiqueta(certificadoDiamantes.getEtiqueta());
        certificadoDiamantesOriginal.getConfiguracion().setUltimaActualizacion(new DateTime());
        return certificadoDiamantesRepository.save(certificadoDiamantesOriginal);

    }

}
