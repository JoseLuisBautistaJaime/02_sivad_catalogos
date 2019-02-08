
package mx.com.nmp.ms.sivad.catalogo.repository;

import java.util.List;
import mx.com.nmp.ms.sivad.catalogo.domain.CatalogoWithoutDependenciesProjection;
import mx.com.nmp.ms.sivad.catalogo.domain.Ramo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author madelgadillo
 */
@Repository
public interface RamoRepository extends CatalogoRepository<Ramo>{
    
    
    
}
