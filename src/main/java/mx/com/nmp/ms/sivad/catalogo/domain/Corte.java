/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import mx.com.nmp.ms.arquetipo.annotation.journal.JournalData;
import mx.com.nmp.ms.arquetipo.journal.listener.JournalEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
/**
 *
 * @author mmarquez
 */
@Entity
@Table(name = "cat_corte")
@JsonIgnoreProperties({"idElemento", "configuracion"})
@EntityListeners(JournalEntityListener.class)
public class Corte extends BaseCorte implements CatalogoConfigurable {

    private static final long serialVersionUID = 1L;

    /**
     * Metadata del catálogo. Contiene la definición del catálogo en sí.
     */
    @ManyToOne
    @JoinColumn(name = "id_configuracion")
    private ConfiguracionCatalogo configuracion;

    @OneToMany(mappedBy = "padre", fetch = FetchType.EAGER)
    private Set<SubCorte> hijos;

    // METODOS

    /**
     * Constructor de la clase.
     */
    public Corte() {
        // Constructor vacio
    }

    public ConfiguracionCatalogo getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(ConfiguracionCatalogo configuracion) {
        this.configuracion = configuracion;
    }

    public Set<SubCorte> getHijos() {
        return hijos;
    }

    public void setHijos(Set<SubCorte> hijos) {
        this.hijos = hijos;
    }

    /**
     * Permite obtener la cadena completa de los valores de los atributos de la clase.
     * @return Cadena completa de los valores de los atributos.
     */
    @Override
    public String toString() {
        return "Corte {" +
                "idElemento=" + getIdElemento() +
                ", abreviatura='" + getAbreviatura() + '\'' +
                ", etiqueta='" + getEtiqueta() + '\'' +
                ", configuracion=" +  ((configuracion != null) ? configuracion.toString() : "null") +
                ", hijos=" + (hijos != null ? hijos.size() : 0) +
                '}';
    }
}
