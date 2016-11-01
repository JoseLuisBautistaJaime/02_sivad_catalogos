package mx.com.nmp.ms.sivad.catalogo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import mx.com.nmp.ms.arquetipo.annotation.journal.JournalData;
import mx.com.nmp.ms.arquetipo.journal.listener.JournalEntityListener;

import javax.persistence.*;

/**
 * Entidad de tipo MotivoBajaPrestamo.
 *
 * @author jbautista
 */
@Entity
@Table(name = "cat_motivo_baja_prestamo")
@JsonIgnoreProperties({"elementoId", "configuracion"})
@EntityListeners(JournalEntityListener.class)
public class MotivoBajaPrestamo implements CatalogoConfigurable{

    private static final long serialVersionUID = 1L;

    /**
     * Id del elemento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "elemento_id")
    @JournalData
    private Long elementoId;

    /**
     * Abreviatura del elemento de catálogo.
     */
    @Column(name = "abreviatura")
    @JournalData
    private String abreviatura;

    /**
     * Descripción del emento de catálogo.
     */
    @Column(name = "etiqueta")
    @JournalData
    private String etiqueta;

    /**
     * Configuración del catálogo, se relaciona con la tabla de configuración.
     */
    @ManyToOne
    @JoinColumn(name="id_configuracion")
    private ConfiguracionCatalogo configuracion;

    /**
     * Cosntructor de la clase.
     */
    public MotivoBajaPrestamo(){
        super();
    }

    /**
     * Recupera el valor del elemento configuración.
     * @return ConfiguracionCatalogo
     */
    @Override
    public ConfiguracionCatalogo getConfiguracion() {
        return configuracion;
    }

    /**
     * Asigna el valor del elemento configuración.
     *
     * @param configuracion
     */
    public void setConfiguracion(ConfiguracionCatalogo configuracion) {
        this.configuracion = configuracion;
    }

    /**
     * Recupera el valor del elemento id.
     *
     * @return elementoId
     */
    public Long getElementoId() {
        return elementoId;
    }

    /**
     * Asigna el valor del elemento id.
     *
     * @param elementoId
     */
    public void setElementoId(Long elementoId) {
        this.elementoId = elementoId;
    }

    /**
     * Recupera el elemento abreviatura.
     *
     * @return abreviatura.
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * Asigna el valor del elemento abreviatura.
     *
     * @param abreviatura
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * Obtiene el valor del elemento etiqueta.
     *
     * @return etiqueta.
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Asigna el valor del elemento eiqueta.
     *
     * @param etiqueta
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * Elementos del objeto MotivoBajaPrestamo.
     *
     * @return MotivoBajaPrestamo.
     */
    @Override
    public String toString() {
        return "MotivoBajaPrestamo{" +
                "id=" + elementoId +
                ", abreviatura='" + abreviatura +
                ", etiqueta='" + etiqueta +
                ", configuracionCatalogo='" + configuracion + '\'' +
                '}';
    }
}
