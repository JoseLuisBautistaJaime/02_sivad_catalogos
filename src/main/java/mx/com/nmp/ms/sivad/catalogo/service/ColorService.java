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
import mx.com.nmp.ms.sivad.catalogo.domain.Color;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.GradoColor;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.repository.ColorRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.GradoColorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que nos permite administrar el catálogo {@link Color}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Service
@Transactional
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class ColorService extends BaseFamiliasColorService<Color> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ColorService.class);

    @Inject
    private ColorRepository colorRepository;

    @Inject
    private GradoColorRepository gradoColorRepository;

    /**
     * Constructor.
     */
    public ColorService() {
        super();
    }

    /**
     * Permite asignar padres al elemento del catálogo {@link Color}
     *
     * @param elemento Abrevitura del elemento a modificar.
     * @param padres Abreviaturas de los elementos padre.
     *
     * @return Elemento al que se le agregaron los padres.
     *
     * @throws CatalogoNotFoundException Cuando no existe el elemento hijo, o ningún padre de la lista.
     */
    public Color addPadres(@HasText String elemento, @NotNull List<String> padres) {
        Color hijo = obtenerElemento(elemento);
        List<GradoColor> result = new ArrayList<>();

        for (String p : padres) {
            GradoColor padre = gradoColorRepository.findByAbreviatura(p);

            if (!ObjectUtils.isEmpty(padre)) {
                result.add(padre);
            }
        }

        validarPadres(result, GradoColor.class);
        asignarPadres(hijo, result);
        actualizarConfiguracion();

        return hijo;
    }

    /**
     * Permite desasignar un padre al elemento del catálogo {@link Color}
     *
     * @param elemento Abrevitura del elemento a modificar.
     * @param padre Abreviatura del elemento padre.
     *
     * @return Elemento al que se le desasigno el padre.
     *
     * @throws CatalogoNotFoundException Cuando no existe el elemento hijo o el padre.
     * @throws IndexOutOfBoundsException Cuando el elemento hijo no contenga padres o el padre especificado.
     */
    public Color removePadre(@HasText String elemento, @HasText String padre) {
        Color hijo = obtenerElemento(elemento);
        GradoColor result = gradoColorRepository.findByAbreviatura(padre);
        validarPadres(result, GradoColor.class);

        if (hijo.getPadres() == null || !hijo.getPadres().remove(result)) {
            String mensaje = String.format("El elemento hijo: %s no contiene al padre especificado: %s",
                elemento, padre);
            LOGGER.warn(mensaje);
            throw new IndexOutOfBoundsException(mensaje);
        }

        return hijo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ColorRepository getRepository() {
        return colorRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ConfiguracionCatalogoEnum getConfiguracionCatalogo() {
        return ConfiguracionCatalogoEnum.COLOR;
    }

    /**
     * Relaciona los padres con el hijo.
     *
     * @param hijo Hijo al que se le asignaran los padres.
     * @param result Lista de padres.
     */
    private static void asignarPadres(Color hijo, List<GradoColor> result) {
        if (hijo.getPadres() == null) {
            hijo.setPadres(result);
        } else {
            hijo.getPadres().addAll(result);
        }
    }
}
