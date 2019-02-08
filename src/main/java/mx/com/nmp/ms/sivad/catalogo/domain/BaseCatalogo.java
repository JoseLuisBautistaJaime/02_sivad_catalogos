package mx.com.nmp.ms.sivad.catalogo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import mx.com.nmp.ms.arquetipo.annotation.journal.JournalData;
import mx.com.nmp.ms.arquetipo.journal.listener.JournalEntityListener;
import org.hibernate.annotations.Cache;
import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;

/**
 *
 * @author madelgadillo
 */
@MappedSuperclass
@Cache(usage = NONSTRICT_READ_WRITE)
@EntityListeners(JournalEntityListener.class)
@JsonIgnoreProperties({"idElemento,configuracion"})
public abstract class BaseCatalogo implements CatalogoConfigurable{
    
    /**
     * Identificador del registro.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_elemento", nullable = false)
    @JsonIgnore 
    @JournalData
    private Long idElemento;

    /**
     * Nombre reconocible de este elemento orientado a uso interno de los sistemas.
     */
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "abreviatura", length = 20, nullable = false, unique = true)
    @JournalData
    private String abreviatura;


    /**
     * Nombre que cualquier sistema de cara al usuario podría utilizar para presentar el elemento.
     */
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "etiqueta", length = 150, nullable = false)
    @JournalData
    private String etiqueta;
    
    /**
     * Metadata del catálogo. Contiene la definición del catálogo en sí.
     */
    @ManyToOne
    @JoinColumn(name = "id_configuracion")
    @JsonIgnore 
    private ConfiguracionCatalogo configuracion;

    public BaseCatalogo() {
        super();
    }
    
    /**
     * Recupera el identificador
     *
     * @return Identificador
     */
    public Long getIdElemento() {
        return idElemento;
    }

    /**
     * Establece el identificador
     *
     * @param idElemento Identificador
     */
    public void setIdElemento(Long idElemento) {
        this.idElemento = idElemento;
    }

    /**
     * Recupera la abreviatura
     *
     * @return Abreviatura
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * Establece la abreviatura
     *
     * @param abreviatura Abreviatura
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * Recupera la etiqueta
     *
     * @return Etiqueta
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Establece la etiqueta
     *
     * @param etiqueta Etiqueta
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    /**
     * Obtiene el valor de {@code configuracion}.
     *
     * @return Valor de {@code configuracion}.
     */
    @Override
    public ConfiguracionCatalogo getConfiguracion() {
        return configuracion;
    }

    /**
     * Establece el nuevo valor de {@code configuracion}.
     *
     * @param configuracion Nuevo valor de {@code configuracion}.
     */
    public void setConfiguracion(ConfiguracionCatalogo configuracion) {
        this.configuracion = configuracion;
    }
}
