
package mx.com.nmp.ms.sivad.catalogo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Quarksoft
 */
@Entity
@Table(name = "cat_reportes")
@JsonIgnoreProperties({"idElemento,configuracion"})
public class Reportes extends BaseCatalogo {

    private static final long serialVersionUID = -7600242951338257157L;

    
    public Reportes() {
        super();
    }
    
    
    
}
