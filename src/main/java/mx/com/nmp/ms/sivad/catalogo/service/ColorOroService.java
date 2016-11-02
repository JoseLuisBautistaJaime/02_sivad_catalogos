/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.sivad.catalogo.domain.ColorOro;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.ColorOroRepository;
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
 * Servicio que expone los metodos para la administración del catálogo Color Oro.
 *
 * @author ngonzalez
 */
@Service
@Transactional
public class ColorOroService {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ColorOroService.class);

    /**
     * Referencia al repositorio de ColorOroRepository.
     */
    @Inject
    private ColorOroRepository colorOroRepository;

    /**
     * Referencia al repositorio de ConfiguracionCatalogoRepository.
     */
    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;



    // METODOS

    /**
     * Permite guardar el elemento del catálogo que se recibe como parámetro.
     *
     * @param colorOro Elemento del catálogo que se quiere guardar.
     * @return El elemento guardado. NULL en caso de no poder realizar el guardado.
     */
    public ColorOro save(ColorOro colorOro) {
        LOGGER.info(">> save");
        ColorOro result = colorOroRepository.findByAbreviatura(colorOro.getAbreviatura());

        if (!ObjectUtils.isEmpty(result)) {
            LOGGER.error("No fue posible realizar el guardado. " +
                    "El catalogo ColorOro ya contiene un elemento con la abreviatura: [{}].",
                    colorOro.getAbreviatura());
            return null;
        }

        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
                ConfiguracionCatalogoEnum.COLOR_ORO.getDominioUnwrap(),
                ConfiguracionCatalogoEnum.COLOR_ORO.getTipo());

        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        colorOro.setConfiguracion(configuracionCatalogo);
        return colorOroRepository.save(colorOro);
    }

    /**
     * Permite eliminar el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return TRUE si se eliminó el elemento del catálogo y FALSE en caso contrario.
     */
    public boolean delete(@HasText String abreviatura) {
        LOGGER.info(">> delete: [{}]", abreviatura);
        ColorOro result = colorOroRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("No fue posible realizar la eliminacion. " +
                    "El catalogo ColorOro no contiene un elemento con la abreviatura: [{}].", abreviatura);
            return false;
        }

        result.getConfiguracion().setUltimaActualizacion(new DateTime());
        colorOroRepository.delete(result);
        return true;
    }

    /**
     * Permite obtener el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return Objeto {@link Catalogo} con el elemento que coincida con la abreviatura indicada.
     * NULL en caso de no existir coincidencia.
     */
    public Catalogo get(@HasText String abreviatura) {
        LOGGER.info(">> get: [{}]", abreviatura);
        ColorOro result = colorOroRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("No fue posible realizar la consulta. " +
                    "El catalogo ColorOro no contiene un elemento con la abreviatura: [{}].", abreviatura);
            return null;
        }

        return CatalogoFactory.build(result);
    }

    /**
     * Permite obtener todos los elementos del catálogo.
     *
     * @return Objeto {@link Catalogo} con la lista de elementos del catálogo.
     */
    public Catalogo getAll() {
        LOGGER.info(">> getAll");
        List<ColorOro> result = colorOroRepository.findAll();

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catalogo ColorOro no contiene elementos.");
            return CatalogoFactory.build(new ArrayList<ColorOro>());
        }

        return CatalogoFactory.build(result);
    }

    /**
     * Permite actualizar el elemento del catálogo que corresponde a la abreviatura indicada.
     *
     * @param abreviatura La abreviatura actual del elemento.
     * @param colorOro Elemento del catálogo con la información que se quiere actualizar.
     * @return El elemento actualizado. NULL en caso de no poder realizar la actualización.
     */
    public ColorOro update(String abreviatura, ColorOro colorOro) {
        LOGGER.info(">> update: [{}]", abreviatura);
        LOGGER.info(">> nueva abreviatura: [{}]", colorOro.getAbreviatura());
        LOGGER.info(">> nueva etiqueta: [{}]", colorOro.getEtiqueta());
        ColorOro colorOroOriginal = colorOroRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(colorOroOriginal)) {
            LOGGER.warn("No fue posible realizar la actualizacion. " +
                    "El catalogo ColorOro no contiene un elemento con la abreviatura: [{}].", abreviatura);
            return null;
        }

        colorOroOriginal.setAbreviatura(colorOro.getAbreviatura());
        colorOroOriginal.setEtiqueta(colorOro.getEtiqueta());
        colorOroOriginal.getConfiguracion().setUltimaActualizacion(new DateTime());
        return colorOroRepository.save(colorOroOriginal);
    }
}