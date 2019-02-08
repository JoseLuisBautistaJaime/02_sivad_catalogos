package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.Metal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para entidadades de tipo Metal.
 *
 * @author jbautista
 */
@Repository
public interface MetalRepository extends CatalogoRepository<Metal> {

    
}
