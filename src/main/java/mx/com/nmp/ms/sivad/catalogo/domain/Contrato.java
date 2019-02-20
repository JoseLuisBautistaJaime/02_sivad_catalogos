/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.nmp.ms.sivad.catalogo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Quarksoft
 */
@Entity
@Table(name = "cat_contrato")
@JsonIgnoreProperties({"idElemento,configuracion"})
public class Contrato extends BaseCatalogo{
    
    private static final long serialVersionUID = -7789384080852381741L;

    public Contrato() {
        super();
    }
    
    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "cat_contrato_tipo_contrato",
    		joinColumns = {@JoinColumn(name = "elemento_padre", referencedColumnName="id_elemento")},
            inverseJoinColumns = @JoinColumn(name = "elemento_hijo")
            )
    private List<TipoContrato> tipoContrato;

    /**
     * @return the tipoContrato
     */
    public List<TipoContrato> getTipoContrato() {
        return tipoContrato;
    }

    /**
     * @param tipoContrato the tipoContrato to set
     */
    public void setTipoContrato(List<TipoContrato> tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
    
    
    
}
