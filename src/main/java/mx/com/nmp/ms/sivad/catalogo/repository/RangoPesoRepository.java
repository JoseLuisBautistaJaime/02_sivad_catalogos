/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.nmp.ms.sivad.catalogo.domain.RangoPeso;

/**
 * Repositorio JPA que nos permite manipular(Crear, Leer, Actualizar y Eliminar) los elementos
 * del catálogo {@link RangoPeso}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public interface RangoPesoRepository extends JpaRepository<RangoPeso, Long> {
	
	RangoPeso findByAbreviatura(String abreviatura);

}
