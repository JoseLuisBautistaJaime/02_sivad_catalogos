/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.QuilatajeDiamante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para entidadades de tipo QuilatajeDiamante, hereda de JpaRepository..
 *
 * @author jbautista
 */
@Repository
public interface QuilatajeDiamanteRepository extends JpaRepository<QuilatajeDiamante, Long> {

    /**
     * Utilizado para obtener la entidad de tipo QuilatajeDiamante buscado por abreviatura.
     *
     * @param abreviatura La abreviatura.
     * @return La entidad que coincida con la abreviatura indicada.
     */
    QuilatajeDiamante findByAbreviatura(String abreviatura);

}
