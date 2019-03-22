
package mx.com.nmp.ms.sivad.catalogo.repository;

import java.util.List;
import mx.com.nmp.ms.sivad.catalogo.domain.CatalogoWithoutDependenciesProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author madelgadillo
 */
@NoRepositoryBean
public interface CatalogoRepository<T> extends JpaRepository<T,Long> {
    
    
    T findByAbreviatura(String abreviatura);
    
    List<CatalogoWithoutDependenciesProjection> findAllWithoutDependenciesBy();
    
    CatalogoWithoutDependenciesProjection findWithoutDependenciesByAbreviatura(String abreviatura);
    
    List<T> findAllByAbreviaturaIn(List<String> abreviaturas);
}
