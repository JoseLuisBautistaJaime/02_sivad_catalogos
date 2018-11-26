/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Interfaz para filtrar las dependencias de los catálogos Familia de colores.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public interface FCWithoutDependenciesProjection extends Serializable {
    /**
     * Indica que se debe recuperar la abreviatura.
     * @return na
     */
    String getAbreviatura();

    /**
     * Indica que se debe recuperar la etiqueta.
     * @return na
     */
    String getEtiqueta();

    /**
     * Indica que se debe recuperar el rango.
     * @return na
     */
    @JsonIgnore
    RangoPeso getRango();

    /**
     * Indica que se debe recuperar la configuración del catálogo.
     * @return na
     */
    @JsonIgnore
    ConfiguracionCatalogo getConfiguracion();
}