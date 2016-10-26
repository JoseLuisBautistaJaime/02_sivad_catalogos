/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.CatalogoPrueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio de prueba para entidades de tipo "CatalogoPrueba".
 *
 * @author ngonzalez
 */
@Repository
public interface CatalogoPruebaRepository extends JpaRepository<CatalogoPrueba, Long> {

    /**
     * Obtener entidades de tipo "CatalogoPrueba" por coincidencia exacta del atributo "abreviatura".
     * @param abreviatura La abreviatura.
     * @return Lista de entidades.
     */
    CatalogoPrueba findByAbreviatura(String abreviatura);

    /**
     * Obtener entidades de tipo "CatalogoPrueba" por coincidencia del atributo "abreviatura".
     * @param abreviatura La abreviatura.
     * @return Lista de entidades.
     */
    List<CatalogoPrueba> findByAbreviaturaLike(String abreviatura);

    /**
     * Obtener entidades de tipo "CatalogoPrueba" por coincidencia de los atributos "abreviatura" y "descripcion".
     * @param abreviatura La abreviatura.
     * @param descripcion La descripcion.
     * @return Lista de entidades.
     */
    List<CatalogoPrueba> findByAbreviaturaLikeAndDescripcionLike(String abreviatura, String descripcion);

    /**
     * Obtener entidades de tipo "CatalogoPrueba" por coincidencia del atributo "abreviatura".
     * @param abreviatura La abreviatura.
     * @return Lista de entidades.
     */
    @Query("FROM CatalogoPrueba cp WHERE cp.abreviatura LIKE ?1")
    List<CatalogoPrueba> encontrarPorAbreviatura(String abreviatura);

}
