package mx.com.nmp.ms.sivad.catalogo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author madelgadillo
 */
    
@Entity
@Table(name = "cat_operacion_caja")
public class OperacionCaja extends BaseCatalogo{

    private static final long serialVersionUID = 2941190322635815639L;

    
    public OperacionCaja() {
        super();
    }
    
    
    
}
