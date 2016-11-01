/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.sivad.catalogo.domain.ColorOro;
import mx.com.nmp.ms.sivad.catalogo.repository.ColorOroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import java.util.List;

/**
 * Servicio que expone los metodos para la administración del catálogo de color del oro.
 *
 * @author ngonzalez
 * @version 1.0
 * @created 01-Nov-2016
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



    // METODOS

    /**
     * Permite guardar el elemento del catálogo que se recibe como parámetro.
     *
     * @param colorOro Elemento del catálogo que se quiere guardar.
     * @return El elemento guardado.
     */
    public ColorOro save(ColorOro colorOro) {
        LOGGER.info(">> save");
        return colorOroRepository.save(colorOro);
    }

    /**
     * Permite eliminar el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     */
    public void delete(@HasText String abreviatura) {
        LOGGER.info(">> delete: [{}]", abreviatura);
        ColorOro colorOro = colorOroRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(colorOro)) {
            LOGGER.warn("No existe el elemento ColorOro para la abreviatura [{}] indicada.", abreviatura);
        } else {
            colorOroRepository.delete(colorOro);
        }
    }

    /**
     * Permite obtener el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return La entidad que coincida con la abreviatura indicada. NULL en caso de que no haya coincidencia.
     */
    public ColorOro get(@HasText String abreviatura) {
        LOGGER.info(">> get: [{}]", abreviatura);
        return colorOroRepository.findByAbreviatura(abreviatura);
    }

    /**
     * Permite obtener todos los elementos del catálogo.
     *
     * @return Lista de elementos del catálogo.
     */
    public List<ColorOro> getAll() {
        LOGGER.info(">> getAll");
        return colorOroRepository.findAll();
    }

    /**
     * Permite actualizar el elemento del catálogo que corresponde a la abreviatura indicada.
     *
     * @param abreviatura La abreviatura actual del elemento.
     * @param colorOro Elemento del catálogo con la información que se quiere actualizar.
     * @return El elemento actualizado.
     */
    public ColorOro update(String abreviatura, ColorOro colorOro) {
        LOGGER.info(">> update: [{}]", abreviatura);
        LOGGER.info(">> nueva abreviatura: [{}]", colorOro.getAbreviatura());
        LOGGER.info(">> nueva etiqueta: [{}]", colorOro.getEtiqueta());
        ColorOro colorOroOriginal = colorOroRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(colorOro)) {
            LOGGER.warn("No existe el elemento ColorOro para la abreviatura [{}] indicada.", abreviatura);
            return null;
        } else {
            colorOroOriginal.setAbreviatura(colorOro.getAbreviatura());
            colorOroOriginal.setEtiqueta(colorOro.getEtiqueta());
            return colorOroRepository.save(colorOroOriginal);
        }
    }

}