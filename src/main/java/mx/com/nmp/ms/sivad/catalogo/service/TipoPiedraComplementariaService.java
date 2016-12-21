/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.TipoPiedraComplementaria;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.TipoPiedraComplementariaRepository;
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
public class TipoPiedraComplementariaService {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
   private static final Logger LOGGER = LoggerFactory.getLogger(TipoPiedraComplementariaService.class);

    /**
     * Referencia al repositorio de TipoPiedraComplementariaRepository.
     */
    @Inject
    private TipoPiedraComplementariaRepository tipoPiedraComplementariaRepository;

    /**
     * Referencia al repositorio de ConfiguracionCatalogoRepository.
     */
    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    //METODOS

    /**
     * Permite guardar el elemento del catálogo que se recibe como parámetro.
     *
     * @param tipoPiedraComplementaria Elemento del catálogo que se quiere guardar.
     * @return El elemento guardado.
     */
    public TipoPiedraComplementaria save(@NotNull TipoPiedraComplementaria tipoPiedraComplementaria) {
        LOGGER.info(">> save: [{}]", tipoPiedraComplementaria.toString());

        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
                ConfiguracionCatalogoEnum.TIPO_PIEDRA_COMPLEMENTARIA.getDominioUnwrap(),
                ConfiguracionCatalogoEnum.TIPO_PIEDRA_COMPLEMENTARIA.getTipo());

        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        tipoPiedraComplementaria.setConfiguracion(configuracionCatalogo);
        return tipoPiedraComplementariaRepository.saveAndFlush(tipoPiedraComplementaria);
    }

    /**
     * Permite eliminar el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    public void delete(@HasText String abreviatura) throws CatalogoNotFoundException {
        LOGGER.info(">> delete: [{}]", abreviatura);
        TipoPiedraComplementaria result = tipoPiedraComplementariaRepository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(result)){
                    String mensaje = "El catalogo TipoPiedraComplementaria no contiene un elemento con la abreviatura [" +  abreviatura + "].";
                throw new CatalogoNotFoundException(mensaje, TipoPiedraComplementaria.class);
            }

        result.getConfiguracion().setUltimaActualizacion(new DateTime());
        tipoPiedraComplementariaRepository.delete(result);
    }

    /**
     * Permite obtener el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return Objeto {@link TipoPiedraComplementaria} con el elemento que coincida con la abreviatura indicada.
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    @Transactional(readOnly = true)
    public TipoPiedraComplementaria get(@HasText String abreviatura) throws CatalogoNotFoundException {
        LOGGER.info(">> get: [{}]", abreviatura);
        TipoPiedraComplementaria result = tipoPiedraComplementariaRepository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(result)){
                String mensaje = "El catalogo TipoPiedraComplementaria no contiene un elemento con la abreviatura [" +  abreviatura + "].";
                throw new CatalogoNotFoundException(mensaje, TipoPiedraComplementaria.class);
            }

        return result;
    }

    /**
     * Permite obtener todos los elementos del catálogo.
     *
     * @return List TipoPiedraComplementaria con la lista de elementos
     */
    @Transactional(readOnly = true)
    public List<TipoPiedraComplementaria> getAll(){
        LOGGER.info(">> getAll");
        List<TipoPiedraComplementaria> result = tipoPiedraComplementariaRepository.findAll();

            if(ObjectUtils.isEmpty(result)) {
                LOGGER.warn("El catalogo TipoPiedraComplementaria no contiene elementos.");
                return new ArrayList<>();
            }

        return result;
    }

    /**
     * Permite actualizar el elemento del catálogo que corresponde a la abreviatura indicada.
     *
     * @param abreviatura La abreviatura actual del elemento.
     * @param tipoPiedraComplementaria Elemento del catálogo con la información que se quiere actualizar.
     * @return El elemento actualizado.
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    public TipoPiedraComplementaria update(@HasText String abreviatura, @NotNull TipoPiedraComplementaria tipoPiedraComplementaria)
            throws CatalogoNotFoundException {
        LOGGER.info(">> update: [{}]", abreviatura);
        LOGGER.info(">> nueva abreviatura: [{}]", tipoPiedraComplementaria.getAbreviatura());
        LOGGER.info(">> nueva etiqueta: [{}]", tipoPiedraComplementaria.getEtiqueta());
        TipoPiedraComplementaria tipoPiedraComplementariaOriginal = tipoPiedraComplementariaRepository.findByAbreviatura(abreviatura);

            if(ObjectUtils.isEmpty(tipoPiedraComplementariaOriginal)){
                String mensaje = "El catalogo TipoPiedraComplementaria no contiene un elemento con la abreviatura [" +  abreviatura + "].";
                throw new CatalogoNotFoundException(mensaje, TipoPiedraComplementaria.class);
            }

            if (ObjectUtils.isEmpty(tipoPiedraComplementaria.getAbreviatura())) {
                LOGGER.warn("No se definio nueva abreviatura. Se conserva la abreviatura actual [{}].", tipoPiedraComplementariaOriginal.getAbreviatura());
            } else {
                tipoPiedraComplementariaOriginal.setAbreviatura(tipoPiedraComplementaria.getAbreviatura());
            }

            if (ObjectUtils.isEmpty(tipoPiedraComplementaria.getEtiqueta())) {
                LOGGER.warn("No se definio nueva etiqueta. Se conserva la etiqueta actual [{}].", tipoPiedraComplementariaOriginal.getEtiqueta());
            } else {
                tipoPiedraComplementariaOriginal.setEtiqueta(tipoPiedraComplementaria.getEtiqueta());
            }

        tipoPiedraComplementariaOriginal.getConfiguracion().setUltimaActualizacion(new DateTime());
        return tipoPiedraComplementariaRepository.saveAndFlush(tipoPiedraComplementariaOriginal);

    }

}
