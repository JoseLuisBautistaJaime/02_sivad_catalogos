/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.GradoColor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA que nos permite manipular(Crear, Leer, Actualizar y Eliminar) los elementos
 * del catálogo {@link GradoColor}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public interface GradoColorRepository extends JpaRepository<GradoColor, Long> {
    /**
     * Recupera un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @return Elemento del catálogo o {@literal null} si no existe.
     */
    GradoColor findByAbreviatura(String abreviatura);
    
    /**
     * Recupera un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     * @param idRango Identificador de la tabla RangoPeso
     *
     * @return Elemento del catálogo o {@literal null} si no existe.
     */
    GradoColor findByAbreviaturaAndRangoIdElemento(String abreviatura, Long idRango);
    
    /**
     * Recupera un elemento del catálogo.
     *
     * @param idRango Identificador de la tabla RangoPeso
     *
     * @return Elemento del catálogo o {@literal null} si no existe.
     */
    List<GradoColor> findByRangoIdElemento(Long idRango);

}