/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.CertificadoDiamantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Expone los metodos de acceso a datos para el catálogo de Certificado Diamantes
 *
 * @author roramirez
 */
@Repository
public interface CertificadoDiamantesRepository extends JpaRepository<CertificadoDiamantes, Long> {
    /**
     * Recupera un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @return Elemento del catálogo o {@literal null} si no existe.
     */
    CertificadoDiamantes findByAbreviatura(String abreviatura);
}
