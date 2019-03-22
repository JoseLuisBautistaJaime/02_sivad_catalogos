
package mx.com.nmp.ms.sivad.catalogo.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author madelgadillo
 */
public class CatalogoDTO implements Serializable{
    
    private String abreviatura;
    private String etiqueta;
    private List<String> abreviaturasHijas;


    /**
     * @return the abreviatura
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * @param abreviatura the abreviatura to set
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * @return the etiqueta
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * @return the abreviaturasHijas
     */
    public List<String> getAbreviaturasHijas() {
        return abreviaturasHijas;
    }

    /**
     * @param abreviaturasHijas the abreviaturasHijas to set
     */
    public void setAbreviaturasHijas(List<String> abreviaturasHijas) {
        this.abreviaturasHijas = abreviaturasHijas;
    }

    @Override
    public String toString() {
        return "CatalogoDTO{" + "abreviatura=" + abreviatura + ", etiqueta=" + etiqueta + ", abreviaturasHijas=" + abreviaturasHijas + '}';
    }

    
    
}
