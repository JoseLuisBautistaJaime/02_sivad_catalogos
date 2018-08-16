/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.ClaridadDiamante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Expone los metodos de acceso a datos para el catálogo de Tipo Piedra Complementaria
 *
 * @author roramirez
 */
@Repository
public interface ClaridadDiamanteRespository extends JpaRepository<ClaridadDiamante, Long> {
    /**
     * Recupera un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     * @param abreviatura Id Rango.
     *
     * @return Elemento del catálogo o {@literal null} si no existe.
     */
    ClaridadDiamante findByAbreviaturaAndRangoIdElemento(String abreviatura, Long idRango);

    /**
     * Recupera un elemento del catálogo.
     *
     * @param abreviatura Id Rango.
     *
     * @return Elemento del catálogo o {@literal null} si no existe.
     */
    List<ClaridadDiamante> findByRangoIdElemento(Long idRango);

}
