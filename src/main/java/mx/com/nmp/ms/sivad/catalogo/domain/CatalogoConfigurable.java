/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.domain;

import java.io.Serializable;

/**
 * Contrato que pueden cumplir los catálogos configurables, permite recuperar la configuración del catalogo.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public interface CatalogoConfigurable extends Serializable {
    /**
     * Permite recuperar la confguración del catálogo.
     *
     * @return Valor de la configuración del catálogo.
     */
    ConfiguracionCatalogo getConfiguracion();
}