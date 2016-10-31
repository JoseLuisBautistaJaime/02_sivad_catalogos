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
import mx.com.nmp.ms.sivad.catalogo.domain.TipoPrenda;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.TipoPrendaRepository;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import org.joda.time.DateTime;
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
public class TipoPrendaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TipoPrendaService.class);

    private TipoPrendaRepository tipoPrendaRepository;
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

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
     * @param idConfiguracion Identificador de la configuración del catálogo.
     *
     * @return El objeto {@link Catalogo} que fue creado.
     */
    @Transactional
    public TipoPrenda guardar(@Valid TipoPrenda elemento, @NotNull Long idConfiguracion) {
        elemento.setConfiguracion(actualizarConfiguracion(idConfiguracion));

        return tipoPrendaRepository.save(elemento);
    }

    /**
     * Permite modificar un elemento del catálogo.
     *
     * @param elemento Elemento modificado.
     *
     * @return El objeto {@link Catalogo} que fue actualizado.
     */
    public TipoPrenda actualizar(@NotNull TipoPrenda elemento, @HasText String abreviatura) {
        TipoPrenda tp = obtenerElemento(abreviatura);
        actualizarCatalogo(tp, elemento);

        return guardar(tp, tp.getConfiguracion().getId());
    }

    /**
     * Permite eleminar un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a eliminar.
     *
     * @return El objeto {@link Catalogo} que fue eliminado.
     */
    @Transactional
    public TipoPrenda eliminar(@HasText String abreviatura) {
        TipoPrenda tp = obtenerElemento(abreviatura);
        actualizarConfiguracion(tp.getConfiguracion().getId());
        tipoPrendaRepository.delete(tp);

        return tp;
    }

    /**
     * Permite recuperar todos los elementos del catálogo.
     *
     * @return Objeto {@link Catalogo} con todos los elementos.
     */
    public Catalogo recuperarCatalogo() {
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
    public Catalogo recuperarElemento(@HasText String abreviatura) {
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
     * Establece el repositprio para manejar el catálogo.
     *
     * @param tipoPrendaRepository Repositorio para manejar el catálogo.
     */
    @Inject
    public void setTipoPrendaRepository(TipoPrendaRepository tipoPrendaRepository) {
        this.tipoPrendaRepository = tipoPrendaRepository;
    }

    /**
     * Establece el repositprio para manejar la configuracion del catálogo.
     *
     * @param configuracionCatalogoRepository Repositorio para manejar la configuracion del catálogo..
     */
    @Inject
    public void setConfiguracionCatalogoRepository(ConfiguracionCatalogoRepository configuracionCatalogoRepository) {
        this.configuracionCatalogoRepository = configuracionCatalogoRepository;
    }

    /**
     * Actuliza un objeto {@link TipoPrenda} apartir de otro.
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
     * @param idConfiguracion Identificador de la configuración.
     *
     * @return Regresa el objeto {@link ConfiguracionCatalogo} modificado.
     */
    private ConfiguracionCatalogo actualizarConfiguracion(Long idConfiguracion) {
        ConfiguracionCatalogo configuracion = configuracionCatalogoRepository.findOne(idConfiguracion);

        if (ObjectUtils.isEmpty(configuracion)) {
            String mensage = String.format("ConfiguracionCatalogo.id = %d, no existe.", idConfiguracion);
            LOGGER.warn(mensage, idConfiguracion);
            throw new CatalogoNotFoundException(mensage, ConfiguracionCatalogo.class);
        }

        configuracion.setUltimaActualizacion(DateTime.now());

        return configuracion;
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
            LOGGER.warn(mensage, abreviatura);
            throw new CatalogoNotFoundException(mensage, TipoPrenda.class);
        }

        return tp;
    }
}
