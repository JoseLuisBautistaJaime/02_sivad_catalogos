/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.sivad.catalogo.domain.QuilatajeOro;
import mx.com.nmp.ms.sivad.catalogo.repository.QuilatajeOroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.inject.Inject;
import java.util.List;

/**
 * Servicio que expone los metodos para la administración del catálogo de quilatajes del oro.
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



    // METODOS

    /**
     * Permite guardar el elemento del catálogo que se recibe como parámetro.
     *
     * @param quilatajeOro Elemento del catálogo que se quiere guardar.
     * @return El elemento guardado.
     */
    public QuilatajeOro save(QuilatajeOro quilatajeOro) {
        LOGGER.info(">> save");
        return quilatajeOroRepository.save(quilatajeOro);
    }

    /**
     * Permite eliminar el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     */
    public void delete(@HasText String abreviatura) {
        LOGGER.info(">> delete: [{}]", abreviatura);
        QuilatajeOro quilatajeOro = quilatajeOroRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(quilatajeOro)) {
            LOGGER.warn("No existe el elemento QuilatajeOro para la abreviatura [{}] indicada.", abreviatura);
        } else {
            quilatajeOroRepository.delete(quilatajeOro);
        }
    }

    /**
     * Permite obtener el elemento del catálogo que coincida con la abreviatura indicada.
     *
     * @param abreviatura La abreviatura.
     * @return La entidad que coincida con la abreviatura indicada. NULL en caso de que no haya coincidencia.
     */
    public QuilatajeOro get(@HasText String abreviatura) {
        LOGGER.info(">> get: [{}]", abreviatura);
        return quilatajeOroRepository.findByAbreviatura(abreviatura);
    }

    /**
     * Permite obtener todos los elementos del catálogo.
     *
     * @return Lista de elementos del catálogo.
     */
    public List<QuilatajeOro> getAll() {
        LOGGER.info(">> getAll");
        return quilatajeOroRepository.findAll();
    }

    /**
     * Permite actualizar el elemento del catálogo que corresponde a la abreviatura indicada.
     *
     * @param abreviatura La abreviatura actual del elemento.
     * @param quilatajeOro Elemento del catálogo con la información que se quiere actualizar.
     * @return El elemento actualizado.
     */
    public QuilatajeOro update(String abreviatura, QuilatajeOro quilatajeOro) {
        LOGGER.info(">> update: [{}]", abreviatura);
        LOGGER.info(">> nueva abreviatura: [{}]", quilatajeOro.getAbreviatura());
        LOGGER.info(">> nueva etiqueta: [{}]", quilatajeOro.getEtiqueta());
        QuilatajeOro quilatajeOroOriginal = quilatajeOroRepository.findByAbreviatura(abreviatura);

        if (ObjectUtils.isEmpty(quilatajeOro)) {
            LOGGER.warn("No existe el elemento QuilatajeOro para la abreviatura [{}] indicada.", abreviatura);
            return null;
        } else {
            quilatajeOroOriginal.setAbreviatura(quilatajeOro.getAbreviatura());
            quilatajeOroOriginal.setEtiqueta(quilatajeOro.getEtiqueta());
            return quilatajeOroRepository.save(quilatajeOroOriginal);
        }
    }

}