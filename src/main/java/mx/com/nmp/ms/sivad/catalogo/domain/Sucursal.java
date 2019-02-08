
package mx.com.nmp.ms.sivad.catalogo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author madelgadillo
 */
@Entity
@Table(name = "cat_sucursal")
public class Sucursal extends BaseCatalogo{

    private static final long serialVersionUID = -7286059880706594698L;

    
    public Sucursal() {
        super();
    }
    
    
    
}
