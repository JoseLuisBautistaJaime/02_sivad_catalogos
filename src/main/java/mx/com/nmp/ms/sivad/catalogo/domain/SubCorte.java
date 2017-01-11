/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import mx.com.nmp.ms.arquetipo.journal.listener.JournalEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Objects;

/**
 * Entidad que representa los elementos del catálogo Sub Cortes
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Entity
@Table(name = "cat_sub_corte")
@EntityListeners(JournalEntityListener.class)
@JsonIgnoreProperties({"idElemento", "padre"})
public class SubCorte extends BaseCorte {
    /**
     * Corte padre de este sub corte.
     */
    @ManyToOne
    @JoinColumn(name = "corte", nullable = false)
    private Corte padre;

    /**
     * Constructor de la clase.
     */
    public SubCorte() {
        super();
    }

    /**
     * Recupera el padre.
     *
     * @return Padre.
     */
    public Corte getPadre() {
        return padre;
    }

    /**
     * Establece el padre.
     *
     * @param padre Padre.
     */
    public void setPadre(Corte padre) {
        this.padre = padre;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SubCorte subCorte = (SubCorte) o;

        return Objects.equals(getIdElemento(), subCorte.getIdElemento());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(getIdElemento());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "SubCorte{" +
            "idElemento=" + getIdElemento() +
            ", abreviatura='" + getAbreviatura() + '\'' +
            ", etiqueta='" + getEtiqueta() + '\'' +
            '}';
    }
}
