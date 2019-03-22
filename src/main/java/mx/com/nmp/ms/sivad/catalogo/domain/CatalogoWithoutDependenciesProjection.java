/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.nmp.ms.sivad.catalogo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

/**
 *
 * @author Quarksoft
 */
public interface CatalogoWithoutDependenciesProjection extends Serializable{
    
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
     * Indica que se debe recuperar la configuración del catálogo.
     * @return na
     */
    @JsonIgnore
    ConfiguracionCatalogo getConfiguracion();
    
}
