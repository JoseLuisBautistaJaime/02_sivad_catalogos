/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

/**
 * Entidad que representa los elementos del catálogo Escala Color.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Entity
@Table(name = "cat_diamante_escala_color")
public class EscalaColor extends BaseColor {
    /**
     * Elementos del catálogo {@link Color} padres de esté elemento del catálogo Escala Color
     */
    private List<Color> padres;

    /**
     * Constructor.
     */
    public EscalaColor() {
        super();
    }

    /**
     * Obtiene la lista de padres de esté elemento.
     *
     * @return Lista de padres de esté elemento.
     */
    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "cat_diamante_color_escala_color",
            joinColumns = @JoinColumn(name = "elemento_hijo"),
            inverseJoinColumns = @JoinColumn(name = "elemento_padre"))
    @JsonIgnoreProperties("etiqueta")
    public List<Color> getPadres() {
        return padres;
    }

    /**
     * Establece la lista de padres de esté elemento.
     *
     * @param padres Nueva lista de padres de esté elemento.
     */
    public void setPadres(List<Color> padres) {
        this.padres = padres;
    }
}
