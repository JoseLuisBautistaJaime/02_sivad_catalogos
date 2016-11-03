/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entidad que representa los elementos del catálogo Grado Color
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Entity
@Table(name = "cat_diamante_grado_color")
public class GradoColor extends BaseColor {
    /**
     * Constructor.
     */
    public GradoColor() {
        super();
    }
}
