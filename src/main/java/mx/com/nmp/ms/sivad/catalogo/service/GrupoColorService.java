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
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.EscalaColor;
import mx.com.nmp.ms.sivad.catalogo.domain.GrupoColor;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.repository.EscalaColorRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.GrupoColorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que nos permite administrar el catálogo {@link GrupoColor}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Service
@Transactional
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class GrupoColorService extends BaseFamiliasColorService<GrupoColor> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GrupoColorService.class);

    @Inject
    private GrupoColorRepository grupoColorRepository;

    @Inject
    private EscalaColorRepository escalaColorRepository;

    /**
     * Constructor.
     */
    public GrupoColorService() {
        super();
    }

    /**
     * Permite asignar padres al elemento del catálogo {@link GrupoColor}
     *
     * @param elemento Abrevitura del elemento a modificar.
     * @param padres Abreviaturas de los elementos padre.
     *
     * @return Elemento al que se le agregaron los padres.
     *
     * @throws CatalogoNotFoundException Cuando no existe el elemento hijo, o ningún padre de la lista.
     */
    public GrupoColor addPadres(@HasText String elemento, @NotNull List<String> padres) {
        GrupoColor hijo = obtenerElemento(elemento);
        List<EscalaColor> result = new ArrayList<>();

        for (String p : padres) {
            EscalaColor padre = escalaColorRepository.findByAbreviatura(p);

            if (!ObjectUtils.isEmpty(padre)) {
                result.add(padre);
            }
        }

        validarPadres(result, EscalaColor.class);
        asignarPadres(hijo, result);
        actualizarConfiguracion();

        return hijo;
    }

    /**
     * Permite desasignar un padre al elemento del catálogo {@link GrupoColor}
     *
     * @param elemento Abrevitura del elemento a modificar.
     * @param padre Abreviatura del elemento padre.
     *
     * @return Elemento al que se le desasigno el padre.
     *
     * @throws CatalogoNotFoundException Cuando no existe el elemento hijo o el padre.
     * @throws IndexOutOfBoundsException Cuando el elemento hijo no contenga padres o el padre especificado.
     */
    public GrupoColor removePadre(@HasText String elemento, @HasText String padre) {
        GrupoColor hijo = obtenerElemento(elemento);
        EscalaColor result = escalaColorRepository.findByAbreviatura(padre);
        validarPadres(result, EscalaColor.class);

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
    protected GrupoColorRepository getRepository() {
        return grupoColorRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ConfiguracionCatalogoEnum getConfiguracionCatalogo() {
        return ConfiguracionCatalogoEnum.GRUPO_COLOR;
    }

    /**
     * Relaciona los padres con el hijo.
     *
     * @param hijo Hijo al que se le asignaran los padres.
     * @param result Lista de padres.
     */
    private static void asignarPadres(GrupoColor hijo, List<EscalaColor> result) {
        if (hijo.getPadres() == null) {
            hijo.setPadres(result);
        } else {
            hijo.getPadres().addAll(result);
        }
    }
}
