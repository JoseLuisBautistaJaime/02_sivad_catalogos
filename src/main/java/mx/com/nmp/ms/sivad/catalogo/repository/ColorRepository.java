/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.Color;

/**
 * Repositorio JPA que nos permite manipular(Crear, Leer, Actualizar y Eliminar) los elementos
 * del catálogo {@link Color}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public interface ColorRepository extends BaseFamiliasColorRepository<Color> {
}
