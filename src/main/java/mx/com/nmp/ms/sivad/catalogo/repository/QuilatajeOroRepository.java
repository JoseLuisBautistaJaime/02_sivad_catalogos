/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.QuilatajeOro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Expone los metodos de acceso a datos para el catálogo Quilataje Oro.
 *
 * @author ngonzalez
 */
@Repository
public interface QuilatajeOroRepository extends CatalogoRepository<QuilatajeOro> {

    /**
     * Utilizado para obtener la entidad de tipo "QuilatajeOro" por coincidencia exacta del atributo "abreviatura".
     *
     * @param abreviatura La abreviatura.
     * @return La entidad que coincida con la abreviatura indicada.
     */
//    QuilatajeOro findByAbreviatura(String abreviatura);

}
