/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.QuilatajeOro;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.QuilatajeOroRepository;
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
     * @return El elemento guardado. NULL en caso de no poder realizar el guardado.
     */
    public QuilatajeOro save(QuilatajeOro quilatajeOro) {
        LOGGER.info(">> save");
        QuilatajeOro result = quilatajeOroRepository.findByAbreviatura(quilatajeOro.getAbreviatura());

        if (!ObjectUtils.isEmpty(result)) {
            LOGGER.error("No fue posible realizar el guardado. " +
                    "El catalogo QuilatajeOro ya contiene un elemento con la abreviatura: [{}].",
                    quilatajeOro.getAbreviatura());
            return null;
        }

        ConfiguracionCatalogo configuracionCatalogo = configuracionCatalogoRepository.findByDominioAndTipo(
                ConfiguracionCatalogoEnum.QUILATAJE_ORO.getDominioUnwrap(),
                ConfiguracionCatalogoEnum.QUILATAJE_ORO.getTipo());

        configuracionCatalogo.setUltimaActualizacion(new DateTime());
        quilatajeOro.setConfiguracion(configuracionCatalogo);
        return quilatajeOroRepository.save(quilatajeOro);
    }

    /**
     * Permite eliminar el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return TRUE si se eliminó el elemento del catálogo y FALSE en caso contrario.
     */
    public boolean delete(@HasText String abreviatura) {
        LOGGER.info(">> delete: [{}]", abreviatura);
        QuilatajeOro result = quilatajeOroRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("No fue posible realizar la eliminacion. " +
                    "El catalogo QuilatajeOro no contiene un elemento con la abreviatura: [{}].", abreviatura);
            return false;
        }

        result.getConfiguracion().setUltimaActualizacion(new DateTime());
        quilatajeOroRepository.delete(result);
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
        QuilatajeOro result = quilatajeOroRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("No fue posible realizar la consulta. " +
                    "El catalogo QuilatajeOro no contiene un elemento con la abreviatura: [{}].", abreviatura);
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
        List<QuilatajeOro> result = quilatajeOroRepository.findAll();

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catalogo QuilatajeOro no contiene elementos.");
            return CatalogoFactory.build(new ArrayList<QuilatajeOro>());
        }

        return CatalogoFactory.build(result);
    }

    /**
     * Permite actualizar el elemento del catálogo que corresponde a la abreviatura indicada.
     *
     * @param abreviatura La abreviatura actual del elemento.
     * @param quilatajeOro Elemento del catálogo con la información que se quiere actualizar.
     * @return El elemento actualizado. NULL en caso de no poder realizar la actualización.
     */
    public QuilatajeOro update(String abreviatura, QuilatajeOro quilatajeOro) {
        LOGGER.info(">> update: [{}]", abreviatura);
        LOGGER.info(">> nueva abreviatura: [{}]", quilatajeOro.getAbreviatura());
        LOGGER.info(">> nueva etiqueta: [{}]", quilatajeOro.getEtiqueta());
        QuilatajeOro quilatajeOroOriginal = quilatajeOroRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(quilatajeOroOriginal)) {
            LOGGER.warn("No fue posible realizar la actualizacion. " +
                    "El catalogo QuilatajeOro no contiene un elemento con la abreviatura: [{}].", abreviatura);
            return null;
        }

        quilatajeOroOriginal.setAbreviatura(quilatajeOro.getAbreviatura());
        quilatajeOroOriginal.setEtiqueta(quilatajeOro.getEtiqueta());
        quilatajeOroOriginal.getConfiguracion().setUltimaActualizacion(new DateTime());
        return quilatajeOroRepository.save(quilatajeOroOriginal);
    }
}