package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad {@link mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo}
 *
 * @author osanchez
 */
public interface ConfiguracionCatalogoRepository extends JpaRepository<ConfiguracionCatalogo, Long> {
}
