package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.MotivoBajaPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para entidadades de tipo MotivoBajaPrestamo, hereda de JpaRepository.
 *
 * @author jbautista
 */
@Repository
public interface MotivoBajaPrestamoRepository extends JpaRepository<MotivoBajaPrestamo,Long> {
}
