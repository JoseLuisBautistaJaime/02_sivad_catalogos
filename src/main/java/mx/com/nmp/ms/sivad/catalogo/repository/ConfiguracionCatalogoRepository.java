package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad {@link mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo}
 *
 * @author osanchez
 */
public interface ConfiguracionCatalogoRepository extends JpaRepository<ConfiguracionCatalogo, Long> {
    /**
     * Busca la configuración de un catálogo en base a {@link ConfiguracionCatalogo#dominio}
     * y {@link ConfiguracionCatalogo#tipo}
     *
     * @param dominio Dominio asociado a un catálogo
     * @param tipo Nombre del tipo de catálogo
     *
     * @return Regresa el objeto {@link ConfiguracionCatalogo} o {@literal null} si no existe.
     */
    ConfiguracionCatalogo findByDominioAndTipo(String dominio, String tipo);
}
