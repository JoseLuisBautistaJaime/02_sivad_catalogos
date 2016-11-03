/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.BaseColor;
import mx.com.nmp.ms.sivad.catalogo.domain.FCWithoutDependenciesProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Repositorio JPA que nos permite manipular(Crear, Leer, Actualizar y Eliminar) los elementos
 * de los catálogos de color.
 *
 * @param <T> Catálogo que será soportado, debe ser un sub tipo de {@link BaseColor}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@NoRepositoryBean
@SuppressWarnings("WeakerAccess")
public interface BaseFamiliasColorRepository<T extends BaseColor> extends JpaRepository<T, Long> {
    /**
     * Recupera un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @return Elemento del catálogo o {@literal null} si no existe.
     */
    T findByAbreviatura(String abreviatura);

    /**
     * Recupera todos los elementos del catálogo sin dependecias.
     * @see FCWithoutDependenciesProjection
     *
     * @return Proyección que contiene los elementos del catálogo.
     */
    List<FCWithoutDependenciesProjection> findAllWithoutDependenciesBy();
}