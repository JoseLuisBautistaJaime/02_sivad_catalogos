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
import mx.com.nmp.ms.sivad.catalogo.domain.GradoColor;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.repository.GradoColorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * Servicio que nos permite administrar el catálogo {@link GradoColor}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Service
@Transactional
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class GradoColorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GradoColorService.class);

    @Inject
    private GradoColorRepository gradoColorRepository;

    @Inject
    private ConfiguracionCatalogoService configuracionCatalogoService;

    /**
     * Constructor.
     */
    public GradoColorService() {
        super();
    }

    /**
     * Permite agregar un elemento nuevo al catálogo.
     * @see ConfiguracionCatalogoService#getAndUpdateOperationDate(String, String)
     *
     * @param elemento Elemento a guardar.
     *
     * @return El objeto {@link GradoColor} que fue creado.
     */
    public GradoColor save(@Valid GradoColor elemento) {
        elemento.setConfiguracion(actualizarConfiguracion());

        return gradoColorRepository.save(elemento);
    }

    /**
     * Permite modificar un elemento del catálogo.
     *
     * @param elemento Elemento modificado.
     * @param abreviatura Abreviatura que identifica el elementos que será modificado.
     *
     * @return El objeto {@link GradoColor} que fue actualizado.
     *
     * @throws CatalogoNotFoundException Cuando no existe el elemento a actualizar.
     */
    public GradoColor update(@NotNull GradoColor elemento, @HasText String abreviatura) {
        GradoColor gc = obtenerElemento(abreviatura);
        actualizarCatalogo(gc, elemento);

        return save(gc);
    }

    /**
     * Permite eliminar un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a eliminar.
     *
     * @return El objeto {@link GradoColor} que fue eliminado.
     *
     * @throws CatalogoNotFoundException Cuando no existe el elemento a eliminar.
     */
    public GradoColor delete(@HasText String abreviatura) {
        GradoColor gc = obtenerElemento(abreviatura);
        actualizarConfiguracion();
        gradoColorRepository.delete(gc);

        return gc;
    }

    /**
     * Permite recuperar todos los elementos del catálogo.
     *
     * @return Objeto {@link Catalogo} con todos los elementos.
     */
    @Transactional(readOnly = true)
    public List<GradoColor> getAll() {
        return gradoColorRepository.findAll();
    }

    /**
     * Permite recuperar un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @return Objeto {@link Catalogo} con el elemento especificado.
     */
    @Transactional(readOnly = true)
    public GradoColor getOne(@HasText String abreviatura) {
        return gradoColorRepository.findByAbreviatura(abreviatura);
    }

    /**
     * Actualiza la fecha de ultima actualización de la configuración del catálogo.
     *
     * @return Regresa el objeto {@link ConfiguracionCatalogo} modificado.
     */
    private ConfiguracionCatalogo actualizarConfiguracion() {
        ConfiguracionCatalogoEnum config = ConfiguracionCatalogoEnum.GRADO_COLOR;

        return configuracionCatalogoService.getAndUpdateOperationDate(config.getDominioUnwrap(), config.getTipo());
    }

    /**
     * Lee un elemento del catálogo filtrando por {@code abreviatura}
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @throws CatalogoNotFoundException Cuando no existe el elemento a recuperar.
     */
    private GradoColor obtenerElemento(String abreviatura) {
        GradoColor gc = gradoColorRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(gc)) {
            String mensaje = String.format("El elemento con GradoColor.abreviatura = %s, no existe.", abreviatura);
            LOGGER.warn(mensaje);
            throw new CatalogoNotFoundException(mensaje, GradoColor.class);
        }

        return gc;
    }

    /**
     * Actualiza un objeto {@link GradoColor} apartir de otro.
     *
     * @param original Objeto original a ser actualizado.
     * @param nuevo Objeto con las modificaciones.
     */
    private void actualizarCatalogo(GradoColor original, GradoColor nuevo) {
        if (ObjectUtils.isEmpty(nuevo.getAbreviatura())) {
            LOGGER.warn("{}.abreviatura = null, se deja valor anterior {}", original.getClass().getSimpleName(),
                    original.getAbreviatura());
        } else {
            original.setAbreviatura(nuevo.getAbreviatura());
        }

        if (ObjectUtils.isEmpty(nuevo.getEtiqueta())) {
            LOGGER.warn("{}.etiqueta = null, se deja valor anterior {}", original.getClass().getSimpleName(),
                    original.getEtiqueta());
        } else {
            original.setEtiqueta(nuevo.getEtiqueta());
        }
    }
}
