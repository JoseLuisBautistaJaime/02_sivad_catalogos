/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.RangoPeso;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.repository.RangoPesoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import javax.validation.Valid;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Servicio que nos permite administrar el catálogo {@link RangoPeso}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Service
@Transactional
public class RangoPesoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RangoPesoService.class);

    @Inject
    private RangoPesoRepository rangoPesoRepository;

    @Inject
    private ConfiguracionCatalogoService configuracionCatalogoService;

    /**
     * Constructor.
     */
    public RangoPesoService() {
        super();
    }

    /**
     * Permite agregar un elemento nuevo al catálogo.
     *
     * @param elemento Elemento a guardar.
     *
     * @return El objeto {@link RangoPeso} que fue creado.
     */
    public RangoPeso save(@Valid RangoPeso elemento) {
        elemento.setConfiguracion(actualizarConfiguracion());

        return rangoPesoRepository.save(elemento);
    }

    /**
     * Permite modificar un elemento del catálogo.
     *
     * @param elemento Elemento modificado.
     * @param abreviatura Abreviatura que identifica el elementos que será modificado.
     *
     * @return El objeto {@link RangoPeso} que fue actualizado.
     *
     * @throws CatalogoNotFoundException Cuando no existe el elemento a actualizar.
     */
    public RangoPeso update(@NotNull RangoPeso elemento, @HasText String abreviatura) {
        RangoPeso cc = obtenerElemento(abreviatura);
        actualizarCatalogo(cc, elemento);

        return getRepository().saveAndFlush(cc);
    }

    /**
     * Permite eliminar un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a eliminar.
     *
     * @return El objeto {@link RangoPeso} que fue eliminado.
     *
     * @throws CatalogoNotFoundException Cuando no existe el elemento a eliminar.
     */
    public RangoPeso delete(@HasText String abreviatura) {
        RangoPeso cc = obtenerElemento(abreviatura);
        actualizarConfiguracion();
        getRepository().delete(cc);

        return cc;
    }

    /**
     * Permite recuperar todos los elementos del catálogo. Se incluyen dependencias.
     *
     * @return Objeto {@link RangoPeso} con todos los elementos.
     */
    @Transactional(readOnly = true)
    public List<RangoPeso> getAll() {
        return getRepository().findAll();
    }

    /**
     * Permite recuperar el rango peso
     * @param idRango
     *
     * @return Objeto {@link RangoPeso} con todos los elementos.
     */
    @Transactional(readOnly = true)
    public RangoPeso getRangoPeso(String abreviatura) {
        return getRepository().findByAbreviatura(abreviatura);
    }

    /**
     * Permite recuperar un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @return Objeto {@link RangoPeso} con el elemento especificado.
     */
    @Transactional(readOnly = true)
    public RangoPeso getOne(@HasText String abreviatura) {
        return getRepository().findByAbreviatura(abreviatura);
    }

    /**
     * Actualiza la fecha de ultima actualización de la configuración del catálogo.
     *
     * @return Regresa el objeto {@link ConfiguracionCatalogo} modificado.
     */
    protected ConfiguracionCatalogo actualizarConfiguracion() {
        ConfiguracionCatalogoEnum config = getConfiguracionCatalogo();

        return configuracionCatalogoService.getAndUpdateOperationDate(config.getDominioUnwrap(), config.getTipo());
    }


    /**
     * Lee un elemento del catálogo filtrando por {@code abreviatura}
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     * @param idRango Rango
     *
     * @throws CatalogoNotFoundException Cuando no existe el elemento a recuperar.
     */
    protected RangoPeso obtenerElemento(String abreviatura) {
        RangoPeso cc = getRepository().findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(cc)) {
            String mensaje = String.format("El elemento con RangoPeso.abreviatura = %s, no existe.", abreviatura);
            LOGGER.warn(mensaje);
            throw new CatalogoNotFoundException(mensaje, RangoPeso.class);
        }

        return cc;
    }

	/**
     * Actualiza un objeto {@link RangoPeso} apartir de otro.
     *
     * @param original Objeto original a ser actualizado.
     * @param nuevo Objeto con las modificaciones.
     */
    private void actualizarCatalogo(RangoPeso original, RangoPeso nuevo) {
        if (ObjectUtils.isEmpty(nuevo.getAbreviatura())) {
            LOGGER.warn("RangoPeso.abreviatura = null, se deja valor anterior {}",
                    original.getAbreviatura());
        } else {
            original.setAbreviatura(nuevo.getAbreviatura());
        }

        if (ObjectUtils.isEmpty(nuevo.getEtiqueta())) {
            LOGGER.warn("RangoPeso.etiqueta = null, se deja valor anterior {}",
                    original.getEtiqueta());
        } else {
            original.setEtiqueta(nuevo.getEtiqueta());
        }
    }

    /**
     * Recupera el tipo ParameterizedType.
     *
     * @return Tipo ParameterizedType
     */
    @SuppressWarnings("unchecked")
    private Class<RangoPeso> getGenericClass() {
        ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();

        return (Class<RangoPeso>) pt.getActualTypeArguments()[0];
    }

    /**
     * {@inheritDoc}
     */
    protected RangoPesoRepository getRepository() {
        return rangoPesoRepository;
    }

    protected ConfiguracionCatalogoEnum getConfiguracionCatalogo() {
        return ConfiguracionCatalogoEnum.RANGO_PESO;
    }

}
