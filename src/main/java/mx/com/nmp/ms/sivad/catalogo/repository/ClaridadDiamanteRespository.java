/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.ClaridadDiamante;

import java.util.List;
import mx.com.nmp.ms.sivad.catalogo.domain.FCWithoutDependenciesProjection;

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
     * @param abreviatura Abreviatura del elemento a recuperar.
     * @param abreviatura Id Rango.
     *
     * @return Elemento del catálogo o {@literal null} si no existe.
     */
    List<ClaridadDiamante> findAllByAbreviaturaAndRangoIdElemento(String abreviatura, Long idRango);

    /**
     * Recupera un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     * @param abreviatura Id Rango.
     * @param padre Bandera que indica si la claridad es padre o hijo
     *
     * @return Elemento del catálogo o {@literal null} si no existe.
     */
    ClaridadDiamante findByAbreviaturaAndRangoIdElementoAndPadre(String abreviatura, Long idRango, boolean padre);

    /**
     * Recupera un elemento del catálogo.
     *
     * @param abreviatura Id Rango.
     *
     * @return Elemento del catálogo o {@literal null} si no existe.
     */
    List<ClaridadDiamante> findByRangoIdElementoAndPadreFalse(Long idRango);

    /**
     * Recupera todos los elementos del catálogo sin dependecias.
     * @param idRango
     * @see FCWithoutDependenciesProjection
     *
     * @return Proyección que contiene los elementos del catálogo.
     */
    List<FCWithoutDependenciesProjection> findAllWithoutDependenciesByRangoIdElementoAndPadreFalse(Long idRango);

    /**
     * Recupera todos los elementos del catálogo sin dependecias.
     * @see FCWithoutDependenciesProjection
     *
     * @return Proyección que contiene los elementos del catálogo.
     */
    List<FCWithoutDependenciesProjection> findAllWithoutDependenciesBy();

}
