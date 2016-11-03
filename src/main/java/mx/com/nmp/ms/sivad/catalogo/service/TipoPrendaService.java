/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import com.codahale.metrics.annotation.Timed;
import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.TipoPrenda;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.TipoPrendaRepository;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * Servicio que nos permite administrar el catálogo {@link TipoPrenda}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Service
@Transactional
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class TipoPrendaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TipoPrendaService.class);

    @Inject
    private TipoPrendaRepository tipoPrendaRepository;

    @Inject
    private ConfiguracionCatalogoService configuracionCatalogoService;

    /**
     * Constructor.
     */
    public TipoPrendaService() {
        super();
    }

    /**
     * Permite agregar un elemento nuevo al catálogo.
     *
     * @param elemento Elemento a guardar.
     *
     * @return El objeto {@link TipoPrenda} que fue creado.
     */
    public TipoPrenda save(@Valid TipoPrenda elemento) {
        elemento.setConfiguracion(actualizarConfiguracion());

        return tipoPrendaRepository.save(elemento);
    }

    /**
     * Permite modificar un elemento del catálogo.
     *
     * @param elemento Elemento modificado.
     * @param abreviatura Abreviatura que identifica el elementos que será modificado.
     *
     * @return El objeto {@link TipoPrenda} que fue actualizado.
     */
    public TipoPrenda update(@NotNull TipoPrenda elemento, @HasText String abreviatura) {
        TipoPrenda tp = obtenerElemento(abreviatura);
        actualizarCatalogo(tp, elemento);

        return save(tp);
    }

    /**
     * Permite eliminar un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a eliminar.
     *
     * @return El objeto {@link TipoPrenda} que fue eliminado.
     */
    public TipoPrenda delete(@HasText String abreviatura) {
        TipoPrenda tp = obtenerElemento(abreviatura);
        actualizarConfiguracion();
        tipoPrendaRepository.delete(tp);

        return tp;
    }

    /**
     * Permite recuperar todos los elementos del catálogo.
     *
     * @return Objeto {@link Catalogo} con todos los elementos.
     */
    @Timed
    @Transactional(readOnly = true)
    public Catalogo getAll() {
        List<TipoPrenda> result = tipoPrendaRepository.findAll();
        Catalogo catalogo = null;

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El catálogo TipoPrenda no contiene elementos.");
        } else {
            catalogo = CatalogoFactory.build(result);
        }

        return catalogo;
    }

    /**
     * Permite recuperar un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @return Objeto {@link Catalogo} con el elemento especificado.
     */
    @Timed
    @Transactional(readOnly = true)
    public Catalogo getOne(@HasText String abreviatura) {
        TipoPrenda result = tipoPrendaRepository.findByAbreviatura(abreviatura);
        Catalogo catalogo = null;

        if (ObjectUtils.isEmpty(result)) {
            LOGGER.warn("El elemento con TipoPrenda.abreviatura = {}, no existe.", abreviatura);
        } else {
            catalogo = CatalogoFactory.build(result);
        }

        return catalogo;
    }

    /**
     * Actualiza un objeto {@link TipoPrenda} apartir de otro.
     *
     * @param original Objeto original a ser actualizado.
     * @param nuevo Objeto con las modificaciones.
     */
    private static void actualizarCatalogo(TipoPrenda original, TipoPrenda nuevo) {
        if (ObjectUtils.isEmpty(nuevo.getAbreviatura())) {
            LOGGER.warn("TipoPrenda.abreviatura = null, se deja valor anterior {}", original.getAbreviatura());
        } else {
            original.setAbreviatura(nuevo.getAbreviatura());
        }

        if (ObjectUtils.isEmpty(nuevo.getEtiqueta())) {
            LOGGER.warn("TipoPrenda.etiqueta = null, se deja valor anterior {}", original.getEtiqueta());
        } else {
            original.setEtiqueta(nuevo.getEtiqueta());
        }
    }

    /**
     * Actualiza la fecha de ultima actualización de la configuración del catálogo.
     *
     * @return Regresa el objeto {@link ConfiguracionCatalogo} modificado.
     */
    private ConfiguracionCatalogo actualizarConfiguracion() {
        ConfiguracionCatalogoEnum config = ConfiguracionCatalogoEnum.TIPO_PRENDA;
        return configuracionCatalogoService.getAndUpdateOperationDate(config.getDominioUnwrap(), config.getTipo());
    }

    /**
     * Verifica si existe el elemento que se intento recuperar
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     */
    private TipoPrenda obtenerElemento(String abreviatura) {
        TipoPrenda tp = tipoPrendaRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(tp)) {
            String mensage = String.format("El elemento con TipoPrenda.abreviatura = %s, no existe.", abreviatura);
            LOGGER.warn(mensage);
            throw new CatalogoNotFoundException(mensage, TipoPrenda.class);
        }

        return tp;
    }
}
