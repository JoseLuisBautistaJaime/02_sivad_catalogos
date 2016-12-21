/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.CertificadoDiamantes;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
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
    public CertificadoDiamantes save(@NotNull CertificadoDiamantes certificadoDiamantes) {
        LOGGER.info(">> save: [{}]", certificadoDiamantes.toString());

        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
                ConfiguracionCatalogoEnum.CERTIFICADO_DIAMANTES.getDominioUnwrap(),
                ConfiguracionCatalogoEnum.CERTIFICADO_DIAMANTES.getTipo());

        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        certificadoDiamantes.setConfiguracion(configuracionCatalogo);

        return certificadoDiamantesRepository.saveAndFlush(certificadoDiamantes);
    }

    /**
     * Permite eliminar el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    public void delete(@HasText String abreviatura) throws CatalogoNotFoundException {
        LOGGER.info(">> delete: [{}]", abreviatura);
        CertificadoDiamantes result = certificadoDiamantesRepository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(result)){
                String mensaje = "El catalogo CertificadoDiamantes no contiene un elemento con la abreviatura [" +  abreviatura + "].";
                throw new CatalogoNotFoundException(mensaje, CertificadoDiamantes.class);
            }

        result.getConfiguracion().setUltimaActualizacion(new DateTime());
        certificadoDiamantesRepository.delete(result);
    }

    /**
     * Permite obtener el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return Objeto {@link CertificadoDiamantes} con el elemento que coincida con la abreviatura indicada.
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    @Transactional(readOnly = true)
    public CertificadoDiamantes get(@HasText String abreviatura){
        LOGGER.info(">> get: [{}]", abreviatura);
        CertificadoDiamantes result = certificadoDiamantesRepository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(result)){
                String mensaje = "El catalogo CertificadoDiamantes no contiene un elemento con la abreviatura [" +  abreviatura + "].";
                throw new CatalogoNotFoundException(mensaje, CertificadoDiamantes.class);
            }

        return result;
    }

    /**
     * Permite obtener todos los elementos del catálogo.
     *
     * @return List CertificadoDiamantes con la lista de elementos
     */
    @Transactional(readOnly = true)
    public List<CertificadoDiamantes> getAll(){
        LOGGER.info(">> getAll");
        List<CertificadoDiamantes> result = certificadoDiamantesRepository.findAll();

            if(ObjectUtils.isEmpty(result)) {
                LOGGER.warn("El catalogo CertificadoDiamantes no contiene elementos.");
                return new ArrayList<>();
            }

        return result;
    }

    /**
     * Permite actualizar el elemento del catálogo que corresponde a la abreviatura indicada.
     *
     * @param abreviatura La abreviatura actual del elemento.
     * @param certificadoDiamantes Elemento del catálogo con la información que se quiere actualizar.
     * @return El elemento actualizado.
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    public CertificadoDiamantes update(String abreviatura, CertificadoDiamantes certificadoDiamantes)
            throws CatalogoNotFoundException {
        LOGGER.info(">> update: [{}]", abreviatura);
        LOGGER.info(">> nueva abreviatura: [{}]", certificadoDiamantes.getAbreviatura());
        LOGGER.info(">> nueva etiqueta: [{}]", certificadoDiamantes.getEtiqueta());
        CertificadoDiamantes certificadoDiamantesOriginal = certificadoDiamantesRepository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(certificadoDiamantesOriginal)){
                String mensaje = "El catalogo CertificadoDiamantes no contiene un elemento con la abreviatura [" +  abreviatura + "].";
                throw new CatalogoNotFoundException(mensaje, CertificadoDiamantes.class);
            }

            if (ObjectUtils.isEmpty(certificadoDiamantes.getAbreviatura())) {
                LOGGER.warn("No se definio nueva abreviatura. Se conserva la abreviatura actual [{}].", certificadoDiamantesOriginal.getAbreviatura());
            } else {
                certificadoDiamantesOriginal.setAbreviatura(certificadoDiamantes.getAbreviatura());
            }

            if (ObjectUtils.isEmpty(certificadoDiamantes.getEtiqueta())) {
                LOGGER.warn("No se definio nueva etiqueta. Se conserva la etiqueta actual [{}].", certificadoDiamantesOriginal.getEtiqueta());
            } else {
                certificadoDiamantesOriginal.setEtiqueta(certificadoDiamantes.getEtiqueta());
            }

        certificadoDiamantesOriginal.getConfiguracion().setUltimaActualizacion(new DateTime());
        return certificadoDiamantesRepository.saveAndFlush(certificadoDiamantesOriginal);

    }

}
