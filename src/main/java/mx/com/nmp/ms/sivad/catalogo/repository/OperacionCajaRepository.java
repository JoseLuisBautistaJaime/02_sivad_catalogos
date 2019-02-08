package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.OperacionCaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author madelgadillo
 */
@Repository
public interface OperacionCajaRepository extends CatalogoRepository<OperacionCaja>{
    
}
