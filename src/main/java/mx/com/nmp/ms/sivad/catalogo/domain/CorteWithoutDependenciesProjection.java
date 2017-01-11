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
 * Interfaz para filtrar las dependencias del catálogo Corte Diamante.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public interface CorteWithoutDependenciesProjection extends Serializable {
    /**
     * Indica que se debe recuperar la abreviatura.
     * @return Abreviatura
     */
    String getAbreviatura();

    /**
     * Indica que se debe recuperar la etiqueta.
     * @return Etiqueta
     */
    String getEtiqueta();

    /**
     * Indica que se debe recuperar la configuración del catálogo.
     * @return Configutación
     */
    @JsonIgnore
    ConfiguracionCatalogo getConfiguracion();
}
