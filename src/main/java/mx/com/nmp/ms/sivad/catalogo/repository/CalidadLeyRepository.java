package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.CalidadLey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para entidadades de tipo CalidadLey.
 *
 * @author jbautista
 */
@Repository
public interface CalidadLeyRepository extends JpaRepository<CalidadLey,Long> {

    /**
     * Obtiene el elemento del catalogo CalidadLey por abreviatura.
     *
     * @param abreviatura abreviatura.
     * @return CalidadLey
     */
    CalidadLey findByAbreviatura(String abreviatura);
}
