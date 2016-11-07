/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.CatalogoPrueba;
import mx.com.nmp.ms.sivad.catalogo.domain.RangoMetal;
import mx.com.nmp.ms.sivad.catalogo.domain.RangoOro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para entidades de tipo "RangoOro".
 *
 * @author mmarquez
 */
@Repository
public interface RangoOroRepository extends JpaRepository<RangoOro, Long> {

    /**
     * Utilizado para obtener el elemento del catalogo RangoOro por su abreviatura.
     *
     * @param abreviatura La abreviatura.
     * @return La entidad que coincida con la abreviatura indicada.
     */
    RangoOro findByAbreviatura(String abreviatura);

}
