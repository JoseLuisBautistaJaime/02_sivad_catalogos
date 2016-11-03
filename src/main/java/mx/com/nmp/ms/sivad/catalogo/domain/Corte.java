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

import static javax.persistence.GenerationType.IDENTITY;
/**
 *
 * @author mmarquez
 */
@Entity
@Table(name = "cat_corte")
@JsonIgnoreProperties({"idElemento", "configuracion"})
@EntityListeners(JournalEntityListener.class)
public class Corte implements CatalogoConfigurable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador del registro.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "elemento_id", nullable = false)
    @JournalData
    private Long idElemento;

    /**
     * Nombre reconocible de este elemento orientado a uso interno de los sistemas.
     */
    @NotNull
    @Size(min = 1)
    @Column(name = "abreviatura", length = 20, nullable = false)
    @JournalData
    private String abreviatura;


    /**
     * Nombre que cualquier sistema de cara al usuario podría utilizar para presentar el elemento.
     */
    @NotNull
    @Size(min = 1)
    @Column(name = "etiqueta", length = 150, nullable = false)
    @JournalData
    private String etiqueta;

    /**
     * Metadata del catálogo. Contiene la definición del catálogo en sí.
     */
    @ManyToOne
    @JoinColumn(name = "id_configuracion")
    private ConfiguracionCatalogo configuracion;



    // METODOS

    /**
     * Constructor de la clase.
     */
    public Corte() {
        // Constructor vacio
    }

    public Long getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Long idElemento) {
        this.idElemento = idElemento;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public ConfiguracionCatalogo getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(ConfiguracionCatalogo configuracion) {
        this.configuracion = configuracion;
    }

    /**
     * Permite obtener la cadena completa de los valores de los atributos de la clase.
     * @return Cadena completa de los valores de los atributos.
     */
    @Override
    public String toString() {
        return "Corte {" +
                "idElemento=" + idElemento +
                ", abreviatura='" + abreviatura + '\'' +
                ", etiqueta='" + etiqueta + '\'' +
                ", configuracion=" + configuracion.toString() +
                '}';
    }
}