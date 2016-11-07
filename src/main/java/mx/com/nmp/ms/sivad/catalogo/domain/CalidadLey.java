package mx.com.nmp.ms.sivad.catalogo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import mx.com.nmp.ms.arquetipo.annotation.journal.JournalData;
import mx.com.nmp.ms.arquetipo.journal.listener.JournalEntityListener;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * Entidad de tipo CalidadLey.
 *
 * @author jbautista
 */
@Entity
@Table(name = "cat_calidad_ley")
@JsonIgnoreProperties({"elementoId", "configuracion"})
@EntityListeners(JournalEntityListener.class)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CalidadLey implements CatalogoConfigurable{

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
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @ManyToOne
    @JoinColumn(name="id_configuracion")
    private ConfiguracionCatalogo configuracion;

    /**
     * Cosntructor de la clase.
     */
    public CalidadLey(){
        super();
    }

    /**
     * Recupera el valor del elemento configuración.
     * @return ConfiguracionCatalogo elemento actual.
     */
    @Override
    public ConfiguracionCatalogo getConfiguracion() {
        return configuracion;
    }

    /**
     * Asigna el valor del elemento configuración.
     *
     * @param configuracion elemento actualizable.
     */
    public void setConfiguracion(ConfiguracionCatalogo configuracion) {
        this.configuracion = configuracion;
    }

    /**
     * Recupera el valor del elemento id.
     *
     * @return elementoId elemento actual
     */
    public Long getElementoId() {
        return elementoId;
    }

    /**
     * Asigna el valor del elemento id.
     *
     * @param elementoId elemento actualizable
     */
    public void setElementoId(Long elementoId) {
        this.elementoId = elementoId;
    }

    /**
     * Recupera el elemento abreviatura.
     *
     * @return abreviatura elemento actual
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * Asigna el valor del elemento abreviatura.
     *
     * @param abreviatura elemento actualizable
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * Obtiene el valor del elemento etiqueta.
     *
     * @return etiqueta elemento actual
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Asigna el valor del elemento eiqueta.
     *
     * @param etiqueta elemento actualizable.
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * Builder para elemento abreviatura
     *
     * @param abreviatura elemento
     * @return CondicionPrenda
     */
    public CalidadLey abreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
        return this;
    }

    /**
     * Builder para elemento etiqueta
     *
     * @param etiqueta elemento
     * @return CondicionPrenda
     */
    public CalidadLey etiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
        return this;
    }

    /**
     * Elementos del objeto CalidadLey.
     *
     * @return CalidadLey.
     */
    @Override
    public String toString() {
        return "CalidadLey{" +
                "id=" + elementoId +
                ", abreviatura='" + abreviatura +
                ", etiqueta='" + etiqueta +
                ", configuracion=" + ((configuracion != null) ? configuracion.toString() : "null") +
                '}';
    }
}
