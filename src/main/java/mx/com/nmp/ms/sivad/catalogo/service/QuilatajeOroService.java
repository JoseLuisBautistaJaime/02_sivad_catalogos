/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.QuilatajeOro;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.QuilatajeOroRepository;
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
 * Servicio que expone los metodos para la administración del catálogo Quilataje Oro.
 *
 * @author ngonzalez
 */
@Service
@Transactional
public class QuilatajeOroService {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(QuilatajeOroService.class);

    /**
     * Referencia al repositorio de QuilatajeOroRepository.
     */
    @Inject
    private QuilatajeOroRepository quilatajeOroRepository;

    /**
     * Referencia al repositorio de ConfiguracionCatalogoRepository.
     */
    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;



    // METODOS

    /**
     * Permite guardar el elemento del catálogo que se recibe como parámetro.
     *
     * @param quilatajeOro Elemento del catálogo que se quiere guardar.
     * @return El elemento guardado.
     */
    public QuilatajeOro save(@NotNull QuilatajeOro quilatajeOro) {
        LOGGER.info(">> save: [{}]", quilatajeOro.toString());

        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
                ConfiguracionCatalogoEnum.QUILATAJE_ORO.getDominioUnwrap(),
                ConfiguracionCatalogoEnum.QUILATAJE_ORO.getTipo());

        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        quilatajeOro.setConfiguracion(configuracionCatalogo);

        try {
            return quilatajeOroRepository.save(quilatajeOro);
        } catch (DataIntegrityViolationException e) {
            String mensaje = "No fue posible realizar el guardado de la entidad. El catalogo QuilatajeOro ya " +
                    "contiene un elemento con la abreviatura: [" + quilatajeOro.getAbreviatura() + "].";
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

        QuilatajeOro quilatajeOro = obtenerElemento(abreviatura);
        quilatajeOro.getConfiguracion().setUltimaActualizacion(new DateTime());
        quilatajeOroRepository.delete(quilatajeOro);
    }

    /**
     * Permite obtener el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return Objeto {@link Catalogo} con el elemento que coincida con la abreviatura indicada.
     */
    @Transactional(readOnly = true)
    public QuilatajeOro get(@HasText String abreviatura) {
        LOGGER.info(">> get: [{}]", abreviatura);

        return obtenerElemento(abreviatura);
    }

    /**
     * Permite obtener todos los elementos del catálogo.
     *
     * @return Objeto {@link Catalogo} con la lista de elementos del catálogo.
     */
    @Transactional(readOnly = true)
    public List<QuilatajeOro> getAll() {
        LOGGER.info(">> getAll");

        List<QuilatajeOro> result = quilatajeOroRepository.findAll();
        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catalogo QuilatajeOro no contiene elementos.");
            return new ArrayList<>();
        }

        return result;
    }

    /**
     * Permite actualizar la información del elemento del catálogo que se recibe como parámetro.
     *
     * @param abreviatura La abreviatura actual del elemento a actualizar.
     * @param quilatajeOro Elemento del catálogo con la nueva información.
     * @return El elemento actualizado.
     */
    public QuilatajeOro update(@HasText String abreviatura, @NotNull QuilatajeOro quilatajeOro) {
        LOGGER.info(">> update: [{}], [{}]", abreviatura, quilatajeOro.toString());

        QuilatajeOro quilatajeOroOriginal = obtenerElemento(abreviatura);
        if (ObjectUtils.isEmpty(quilatajeOro.getAbreviatura())) {
            LOGGER.warn("No se definio nueva abreviatura. Se conserva la abreviatura actual [{}].",
                    quilatajeOroOriginal.getAbreviatura());
        } else {
            quilatajeOroOriginal.setAbreviatura(quilatajeOro.getAbreviatura());
        }

        if (ObjectUtils.isEmpty(quilatajeOro.getEtiqueta())) {
            LOGGER.warn("No se definio nueva etiqueta. Se conserva la etiqueta actual [{}].",
                    quilatajeOroOriginal.getEtiqueta());
        } else {
            quilatajeOroOriginal.setEtiqueta(quilatajeOro.getEtiqueta());
        }

        quilatajeOroOriginal.getConfiguracion().setUltimaActualizacion(new DateTime());

        try {
            return quilatajeOroRepository.saveAndFlush(quilatajeOroOriginal);
        } catch (DataIntegrityViolationException e) {
            String mensaje = "No fue posible realizar la actualizacion de la entidad. El catalogo QuilatajeOro ya " +
                    "contiene un elemento con la abreviatura: [" + quilatajeOro.getAbreviatura() + "].";
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
    private QuilatajeOro obtenerElemento(String abreviatura) {
        LOGGER.info(">> obtenerElemento: [{}]", abreviatura);

        QuilatajeOro quilatajeOro = quilatajeOroRepository.findByAbreviatura(abreviatura);
        if (ObjectUtils.isEmpty(quilatajeOro)) {
            String mensaje =
                    "El catalogo QuilatajeOro no contiene un elemento con la abreviatura: [" + abreviatura + "].";
            LOGGER.warn(mensaje);
            throw new CatalogoNotFoundException(mensaje, QuilatajeOro.class);
        }

        return quilatajeOro;
    }

}