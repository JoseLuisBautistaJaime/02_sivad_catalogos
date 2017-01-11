/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.Corte;
import mx.com.nmp.ms.sivad.catalogo.domain.CorteWithoutDependenciesProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para entidades de tipo Corte de diamante.
 *
 * @author mmarquez
 */
@Repository
public interface CorteRepository extends JpaRepository<Corte, Long> {

    /**
     * Utilizado para obtener el elemento del catalogo Corte por su abreviatura.
     *
     * @param abreviatura La abreviatura.
     * @return La entidad que coincida con la abreviatura indicada.
     */
    Corte findByAbreviatura(String abreviatura);

    /**
     * Recupera todos los elementos del catálogo sin dependecias.
     * @see CorteWithoutDependenciesProjection
     *
     * @return Proyección que contiene los elementos del catálogo.
     */
    List<CorteWithoutDependenciesProjection> findAllWithoutDependenciesBy();
}
