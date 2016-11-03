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
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoDuplicateKeyException;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
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
     * @return El elemento guardado.
     * @throws CatalogoDuplicateKeyException En caso de que la abreviatura ya exista.
     */
    public QuilatajeOro save(QuilatajeOro quilatajeOro) throws CatalogoDuplicateKeyException {
        LOGGER.info(">> save");

        // Se valida si no existe un elemento del catálogo con la misma abreviatura que la nueva.
        validarAbreviaturaDuplicada(quilatajeOro.getAbreviatura());

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
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    public void delete(@HasText String abreviatura) throws CatalogoNotFoundException {
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
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    public Catalogo get(@HasText String abreviatura) throws CatalogoNotFoundException {
        LOGGER.info(">> get: [{}]", abreviatura);

        QuilatajeOro quilatajeOro = obtenerElemento(abreviatura);
        return CatalogoFactory.build(quilatajeOro);
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
     * Permite actualizar la abreviatura de un elemento del catálogo.
     *
     * @param abreviatura La abreviatura actual del elemento a actualizar.
     * @param abreviaturaNueva La nueva abreviatura.
     * @return El elemento actualizado.
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     * @throws CatalogoDuplicateKeyException En caso de que se quiera registrar una abreviatura duplicada.
     */
    public QuilatajeOro updateAbreviatura(String abreviatura, String abreviaturaNueva)
            throws CatalogoNotFoundException, CatalogoDuplicateKeyException {
        LOGGER.info(">> updateAbreviatura: [{}]", abreviatura);
        LOGGER.info(">> nueva abreviatura: [{}]", abreviaturaNueva);

        // Se valida si no existe un elemento del catálogo con la misma abreviatura que la nueva.
        validarAbreviaturaDuplicada(abreviaturaNueva);

        QuilatajeOro quilatajeOro = obtenerElemento(abreviatura);
        quilatajeOro.setAbreviatura(abreviaturaNueva);
        quilatajeOro.getConfiguracion().setUltimaActualizacion(new DateTime());
        return quilatajeOroRepository.save(quilatajeOro);
    }

    /**
     * Permite actualizar la etiqueta de un elemento del catálogo.
     *
     * @param abreviatura La abreviatura del elemento a actualizar.
     * @param etiquetaNueva La nueva etiqueta.
     * @return El elemento actualizado.
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    public QuilatajeOro updateEtiqueta(String abreviatura, String etiquetaNueva)
            throws CatalogoNotFoundException {
        LOGGER.info(">> updateEtiqueta: [{}]", abreviatura);
        LOGGER.info(">> nueva etiqueta: [{}]", etiquetaNueva);

        QuilatajeOro quilatajeOro = obtenerElemento(abreviatura);
        quilatajeOro.setEtiqueta(etiquetaNueva);
        quilatajeOro.getConfiguracion().setUltimaActualizacion(new DateTime());
        return quilatajeOroRepository.save(quilatajeOro);
    }

    /**
     * Metodo auxiliar que factoriza la lógica de obtener un elemento del catálogo por abreviatura.
     *
     * @param abreviatura La abreviatura.
     * @return El elemento obtenido.
     * @throws CatalogoNotFoundException En caso de no encontrar un elemento que coincida con la abreviatura.
     */
    private QuilatajeOro obtenerElemento(String abreviatura)
            throws CatalogoNotFoundException {
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
            QuilatajeOro quilatajeOro = obtenerElemento(abreviatura);
            if (!ObjectUtils.isEmpty(quilatajeOro)) {
                String mensaje =
                        "El catalogo QuilatajeOro ya contiene un elemento con la abreviatura: [" + abreviatura + "].";
                LOGGER.warn(mensaje);
                throw new CatalogoDuplicateKeyException(mensaje, QuilatajeOro.class);
            }
        } catch (CatalogoNotFoundException e) {
            LOGGER.info("La abreviatura: [" + abreviatura + "] no esta duplicada.");
        }
    }

}