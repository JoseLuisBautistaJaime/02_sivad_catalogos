package mx.com.nmp.ms.sivad.catalogo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author madelgadillo
 */
@Entity
@Table(name = "cat_tipo_contrato")
@JsonIgnoreProperties({"idElemento,configuracion"})
public class TipoContrato extends BaseCatalogo{

    private static final long serialVersionUID = 7701660426788910825L;

    
    public TipoContrato() {
        super();
    }

    
}
