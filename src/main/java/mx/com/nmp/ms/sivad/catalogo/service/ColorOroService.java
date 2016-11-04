/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.ColorOro;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.repository.ColorOroRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
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
     * @return El elemento guardado.
     */
    public ColorOro save(@NotNull ColorOro colorOro) {
        LOGGER.info(">> save: [{}]", colorOro.toString());

        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
                ConfiguracionCatalogoEnum.COLOR_ORO.getDominioUnwrap(),
                ConfiguracionCatalogoEnum.COLOR_ORO.getTipo());

        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        colorOro.setConfiguracion(configuracionCatalogo);

        try {
            return colorOroRepository.save(colorOro);
        } catch (DataIntegrityViolationException e) {
            String mensaje = "No fue posible realizar el guardado de la entidad. El catalogo ColorOro ya " +
                    "contiene un elemento con la abreviatura: [" + colorOro.getAbreviatura() + "].";
            LOGGER.warn(mensaje + " Excepcion: [{}]", e);
            throw e;
        }
    }

    /**
     * Permite eliminar el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     */
    public void delete(@HasText String abreviatura) {
        LOGGER.info(">> delete: [{}]", abreviatura);

        ColorOro colorOro = obtenerElemento(abreviatura);
        colorOro.getConfiguracion().setUltimaActualizacion(new DateTime());
        colorOroRepository.delete(colorOro);
    }

    /**
     * Permite obtener el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return Objeto {@link Catalogo} con el elemento que coincida con la abreviatura indicada.
     */
    @Transactional(readOnly = true)
    public ColorOro get(@HasText String abreviatura) {
        LOGGER.info(">> get: [{}]", abreviatura);

        return obtenerElemento(abreviatura);
    }

    /**
     * Permite obtener todos los elementos del catálogo.
     *
     * @return Objeto {@link Catalogo} con la lista de elementos del catálogo.
     */
    @Transactional(readOnly = true)
    public List<ColorOro> getAll() {
        LOGGER.info(">> getAll");

        List<ColorOro> result = colorOroRepository.findAll();
        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catalogo ColorOro no contiene elementos.");
            return new ArrayList<>();
        }

        return result;
    }

    /**
     * Permite actualizar la información del elemento del catálogo que se recibe como parámetro.
     *
     * @param abreviatura La abreviatura actual del elemento a actualizar.
     * @param colorOro Elemento del catálogo con la nueva información.
     * @return El elemento actualizado.
     */
    public ColorOro update(@HasText String abreviatura, @NotNull ColorOro colorOro) {
        LOGGER.info(">> update: [{}], [{}]", abreviatura, colorOro.toString());

        ColorOro colorOroOriginal = obtenerElemento(abreviatura);
        if (ObjectUtils.isEmpty(colorOro.getAbreviatura())) {
            LOGGER.warn("No se definio nueva abreviatura. Se conserva la abreviatura actual [{}].",
                    colorOroOriginal.getAbreviatura());
        } else {
            colorOroOriginal.setAbreviatura(colorOro.getAbreviatura());
        }

        if (ObjectUtils.isEmpty(colorOro.getEtiqueta())) {
            LOGGER.warn("No se definio nueva etiqueta. Se conserva la etiqueta actual [{}].",
                    colorOroOriginal.getEtiqueta());
        } else {
            colorOroOriginal.setEtiqueta(colorOro.getEtiqueta());
        }

        colorOroOriginal.getConfiguracion().setUltimaActualizacion(new DateTime());

        try {
            return colorOroRepository.save(colorOroOriginal);
        } catch (DataIntegrityViolationException e) {
            String mensaje = "No fue posible realizar la actualizacion de la entidad. El catalogo ColorOro ya " +
                    "contiene un elemento con la abreviatura: [" + colorOro.getAbreviatura() + "].";
            LOGGER.warn(mensaje + " Excepcion: [{}]", e);
            throw e;
        }
    }

    /**
     * Metodo auxiliar que factoriza la lógica de obtener un elemento del catálogo por abreviatura.
     *
     * @param abreviatura La abreviatura.
     * @return El elemento obtenido.
     */
    private ColorOro obtenerElemento(String abreviatura) {
        LOGGER.info(">> obtenerElemento: [{}]", abreviatura);

        ColorOro colorOro = colorOroRepository.findByAbreviatura(abreviatura);
        if (ObjectUtils.isEmpty(colorOro)) {
            String mensaje =
                    "El catalogo ColorOro no contiene un elemento con la abreviatura: [" + abreviatura + "].";
            LOGGER.warn(mensaje);
            throw new CatalogoNotFoundException(mensaje, ColorOro.class);
        }

        return colorOro;
    }

}