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
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoDuplicateKeyException;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
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
     * @return El elemento guardado.
     * @throws CatalogoDuplicateKeyException En caso de que la abreviatura ya exista.
     */
    public ColorOro save(ColorOro colorOro) throws CatalogoDuplicateKeyException {
        LOGGER.info(">> save");

        // Se valida si no existe un elemento del catálogo con la misma abreviatura que la nueva.
        validarAbreviaturaDuplicada(colorOro.getAbreviatura());

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
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    public void delete(@HasText String abreviatura) throws CatalogoNotFoundException {
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
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    public Catalogo get(@HasText String abreviatura) throws CatalogoNotFoundException {
        LOGGER.info(">> get: [{}]", abreviatura);

        ColorOro colorOro = obtenerElemento(abreviatura);
        return CatalogoFactory.build(colorOro);
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
     * Permite actualizar la abreviatura de un elemento del catálogo.
     *
     * @param abreviatura La abreviatura actual del elemento a actualizar.
     * @param abreviaturaNueva La nueva abreviatura.
     * @return El elemento actualizado.
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     * @throws CatalogoDuplicateKeyException En caso de que se quiera registrar una abreviatura duplicada.
     */
    public ColorOro updateAbreviatura(String abreviatura, String abreviaturaNueva)
            throws CatalogoNotFoundException, CatalogoDuplicateKeyException {
        LOGGER.info(">> updateAbreviatura: [{}]", abreviatura);
        LOGGER.info(">> nueva abreviatura: [{}]", abreviaturaNueva);

        // Se valida si no existe un elemento del catálogo con la misma abreviatura que la nueva.
        validarAbreviaturaDuplicada(abreviaturaNueva);

        ColorOro colorOro = obtenerElemento(abreviatura);
        colorOro.setAbreviatura(abreviaturaNueva);
        colorOro.getConfiguracion().setUltimaActualizacion(new DateTime());
        return colorOroRepository.save(colorOro);
    }

    /**
     * Permite actualizar la etiqueta de un elemento del catálogo.
     *
     * @param abreviatura La abreviatura del elemento a actualizar.
     * @param etiquetaNueva La nueva etiqueta.
     * @return El elemento actualizado.
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    public ColorOro updateEtiqueta(String abreviatura, String etiquetaNueva)
            throws CatalogoNotFoundException {
        LOGGER.info(">> updateEtiqueta: [{}]", abreviatura);
        LOGGER.info(">> nueva etiqueta: [{}]", etiquetaNueva);

        ColorOro colorOro = obtenerElemento(abreviatura);
        colorOro.setEtiqueta(etiquetaNueva);
        colorOro.getConfiguracion().setUltimaActualizacion(new DateTime());
        return colorOroRepository.save(colorOro);
    }

    /**
     * Metodo auxiliar que factoriza la lógica de obtener un elemento del catálogo por abreviatura.
     *
     * @param abreviatura La abreviatura.
     * @return El elemento obtenido.
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    private ColorOro obtenerElemento(String abreviatura)
            throws CatalogoNotFoundException {
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

    /**
     * Metodo auxiliar utilizado para validar si ya existe o no un elemento del catálogo con la misma abreviatura.
     *
     * @param abreviatura La abreviatura.
     * @throws CatalogoDuplicateKeyException En caso de que la abreviatura ya exista.
     */
    private void validarAbreviaturaDuplicada(String abreviatura)
            throws CatalogoDuplicateKeyException {
        LOGGER.info(">> validarAbreviaturaDuplicada: [{}]", abreviatura);

        try {
            ColorOro colorOro = obtenerElemento(abreviatura);
            if (!ObjectUtils.isEmpty(colorOro)) {
                String mensaje =
                        "El catalogo ColorOro ya contiene un elemento con la abreviatura: [" + abreviatura + "].";
                LOGGER.warn(mensaje);
                throw new CatalogoDuplicateKeyException(mensaje, ColorOro.class);
            }
        } catch (CatalogoNotFoundException e) {
            LOGGER.info("La abreviatura: [" + abreviatura + "] no esta duplicada.");
        }
    }

}