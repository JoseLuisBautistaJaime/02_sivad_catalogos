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
 * Entidad que representa los elementos del catálogo Grupo Color
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Entity
@Table(name = "cat_diamante_grupo_color")
public class GrupoColor extends BaseColor {
    private static final long serialVersionUID = -1147470982892950181L;

    /**
     * Elementos del catálogo {@link EscalaColor} padres de esté elemento del catálogo Grupo Color
     */
    @ManyToMany(fetch = EAGER)
    @JsonIgnoreProperties("etiqueta")
    @JoinTable(name = "cat_diamante_escala_color_grupo_color",
            joinColumns = @JoinColumn(name = "elemento_hijo"),
            inverseJoinColumns = @JoinColumn(name = "elemento_padre"))
    private List<EscalaColor> padres;

    /**
     * Constructor.
     */
    public GrupoColor() {
        super();
    }

    /**
     * Obtiene la lista de padres de esté elemento.
     *
     * @return Lista de padres de esté elemento.
     */
    public List<EscalaColor> getPadres() {
        return padres;
    }

    /**
     * Establece la lista de padres de esté elemento.
     *
     * @param padres Nueva lista de padres de esté elemento.
     */
    public void setPadres(List<EscalaColor> padres) {
        this.padres = padres;
    }
}
