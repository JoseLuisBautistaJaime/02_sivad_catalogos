
package mx.com.nmp.ms.sivad.catalogo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author madelgadillo
 */
@Entity
@Table(name = "cat_perfil")
@JsonIgnoreProperties({"idElemento,configuracion"})
public class Perfil extends BaseCatalogo{

    private static final long serialVersionUID = -6190743683580694405L;
    
    public Perfil() {
        super();
    }
    
    
    
    
    
}
