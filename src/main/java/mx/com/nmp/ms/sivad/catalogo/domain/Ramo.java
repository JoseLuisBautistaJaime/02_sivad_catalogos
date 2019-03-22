
package mx.com.nmp.ms.sivad.catalogo.domain;

import java.util.List;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author madelgadillo
 */
@Entity
@Table(name = "cat_ramo")
public class Ramo extends BaseCatalogo{

    private static final long serialVersionUID = -521066058139171720L;

    
    
    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "cat_ramo_subramo",
    		joinColumns = {@JoinColumn(name = "elemento_padre", referencedColumnName="id_elemento")},
            inverseJoinColumns = @JoinColumn(name = "elemento_hijo")
            )
    private List<Subramo> subramos;
    
    public Ramo() {
        super();
    }

    /**
     * Obtiene la lista de subramos
     * @return Lista de subramos
     */
    public List<Subramo> getSubramos() {
        return subramos;
    }

    /**
     * Establece la nueva lista de subramos por ramo
     * @param subramos Nueva lista de subramos
     */
    public void setSubramos(List<Subramo> subramos) {
        this.subramos = subramos;
    }
    
    
    
    
}
