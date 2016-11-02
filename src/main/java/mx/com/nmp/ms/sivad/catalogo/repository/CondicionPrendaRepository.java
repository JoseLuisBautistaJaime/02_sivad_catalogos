package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.CondicionPrenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para entidadades de tipo CondicionPrenda, hereda de JpaRepository.
 *
 * @author jbautista
 */
@Repository
public interface CondicionPrendaRepository extends JpaRepository<CondicionPrenda,Long> {

    /**
     * Obtiene el elemento del catalogo CondicionPrenda por abreviatura.
     *
     * @param abreviatura abreviatura.
     * @return CondicionPrenda
     */
    CondicionPrenda findByAbreviatura(String abreviatura);
}
