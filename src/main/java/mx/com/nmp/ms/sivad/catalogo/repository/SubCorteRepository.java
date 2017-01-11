/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.SubCorte;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA que nos permite manipular(Crear, Leer, Actualizar y Eliminar) los elementos
 * del catálogo {@link SubCorte}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public interface SubCorteRepository extends JpaRepository<SubCorte, Long> {
    /**
     * Recupera un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @return Elemento del catálogo o {@literal null} si no existe.
     */
    SubCorte findByAbreviatura(String abreviatura);
}
