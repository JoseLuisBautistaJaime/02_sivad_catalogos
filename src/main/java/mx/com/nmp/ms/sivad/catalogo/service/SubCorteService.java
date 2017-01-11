package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.arquetipo.annotation.validation.NotNull;
import mx.com.nmp.ms.sivad.catalogo.domain.Corte;
import mx.com.nmp.ms.sivad.catalogo.domain.SubCorte;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.repository.SubCorteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Service
@Transactional
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class SubCorteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubCorteService.class);

    @Inject
    private SubCorteRepository repositorio;

    @Inject
    private CorteService servicioCorte;

    /**
     * Constructor.
     */
    public SubCorteService() {
        super();
    }

    /**
     * Permite agregar un elemento nuevo al catálogo.
     *
     * @param elemento Elemento a guardar.
     *
     * @return El objeto {@link SubCorte} que fue creado.
     */
    public SubCorte save(@Valid SubCorte elemento, @HasText String padre) {
        elemento.setPadre(servicioCorte.get(padre));

        return repositorio.saveAndFlush(elemento);
    }

    /**
     * Permite modificar un elemento del catálogo.
     *
     * @param elemento Elemento modificado.
     * @param abreviatura Abreviatura que identifica el elementos que será modificado.
     *
     * @return El objeto {@link SubCorte} que fue actualizado.
     */
    public SubCorte update(@NotNull SubCorte elemento, @HasText String abreviatura, String padre) {
        SubCorte sc = obtenerElemento(abreviatura);
        actualizarCatalogo(sc, elemento, ObjectUtils.isEmpty(padre) ? null : servicioCorte.get(padre));

        return sc;
    }

    /**
     * Elimina elemento del catalogo de tipo RangoOro por identificador.
     *
     * @param abreviatura Abreviatura que identifica el elementos que será modificado.
     */
    public void delete(@HasText String abreviatura){
        LOGGER.info(">> delete({})",abreviatura);
        SubCorte sc = obtenerElemento(abreviatura);
        repositorio.delete(sc);
    }

    /**
     * Permite recuperar todos los elementos del catálogo.
     *
     * @return Lista tipo {@link SubCorte} con todos los elementos.
     */
    @Transactional(readOnly = true)
    public List<SubCorte> getAll() {
        return repositorio.findAll();
    }

    /**
     * Permite recuperar un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @return Lista tipo {@link SubCorte} con el elemento especificado.
     */
    @Transactional(readOnly = true)
    public SubCorte getOne(@HasText String abreviatura) {
        return repositorio.findByAbreviatura(abreviatura);
    }

    /**
     * Verifica si existe el elemento que se intento recuperar
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     */
    private SubCorte obtenerElemento(String abreviatura) {
        SubCorte sc = repositorio.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(sc)) {
            String mensaje = String.format("El elemento con SubCorte.abreviatura = %s, no existe.", abreviatura);
            LOGGER.warn(mensaje);
            throw new CatalogoNotFoundException(mensaje, SubCorte.class);
        }

        return sc;
    }

    /**
     * Actualiza un objeto {@link SubCorte} apartir de otro.
     *
     * @param original Objeto original a ser actualizado.
     * @param nuevo Objeto con las modificaciones.
     */
    private static void actualizarCatalogo(SubCorte original, SubCorte nuevo, Corte padre) {
        if (ObjectUtils.isEmpty(nuevo.getAbreviatura())) {
            LOGGER.warn("SubCorte.abreviatura = null, se deja valor anterior {}", original.getAbreviatura());
        } else {
            original.setAbreviatura(nuevo.getAbreviatura());
        }

        if (ObjectUtils.isEmpty(nuevo.getEtiqueta())) {
            LOGGER.warn("SubCorte.etiqueta = null, se deja valor anterior {}", original.getEtiqueta());
        } else {
            original.setEtiqueta(nuevo.getEtiqueta());
        }

        if (ObjectUtils.isEmpty(padre)) {
            LOGGER.warn("SubCorte.padre = null, se deja valor anterior {}", original.getPadre());
        } else {
            original.setPadre(padre);
        }
    }
}
