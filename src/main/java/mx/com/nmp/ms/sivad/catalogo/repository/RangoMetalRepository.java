/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.RangoMetal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para entidades de tipo "RangoMetal".
 *
 * @author mmarquez
 */
@Repository
public interface RangoMetalRepository extends JpaRepository<RangoMetal, Long> {

    /**
     * Utilizado para obtener el elemento del catalogo RangoMetal por su abreviatura.
     *
     * @param abreviatura La abreviatura.
     * @return La entidad que coincida con la abreviatura indicada.
     */
    RangoMetal findByAbreviatura(String abreviatura);

}
