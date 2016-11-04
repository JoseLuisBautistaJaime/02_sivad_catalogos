/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import mx.com.nmp.ms.arquetipo.annotation.journal.JournalData;
import mx.com.nmp.ms.arquetipo.journal.listener.JournalEntityListener;
import org.hibernate.annotations.Cache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;

/**
 * Entidad que representa los elementos del catálogo Tipos de prenda.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@Entity
@Cache(usage = NONSTRICT_READ_WRITE)
@Table(name = "cat_diamante_tipo_prenda")
@EntityListeners(JournalEntityListener.class)
@JsonIgnoreProperties({"idElemento", "configuracion"})
public class TipoPrenda implements CatalogoConfigurable {
    private static final long serialVersionUID = -2912682434670276479L;

    /**
     * Identificador del registro.
     */
    @Id
    @JournalData
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "elemento_id", nullable = false)
    private Long idElemento;

    /**
     * Nombre reconocible de este elemento orientado a uso interno de los sistemas.
     */
    @NotNull
    @JournalData
    @Size(min = 1)
    @Column(name = "abreviatura", length = 20, nullable = false, unique = true)
    private String abreviatura;

    /**
     * Es el nombre que cualquier sistema de cara al usuario podría utilizar para presentar el elemento.
     */
    @NotNull
    @JournalData
    @Size(min = 1)
    @Column(name = "etiqueta", length = 150, nullable = false)
    private String etiqueta;

    /**
     * Metadata del catálogo. Contiene la definición del catálogo en sí.
     */
    @ManyToOne
    @JoinColumn(name = "id_configuracion")
    private ConfiguracionCatalogo configuracion;

    /**
     * Constructor.
     */
    public TipoPrenda() {
        super();
    }

    /**
     * Obtiene el valor de idElemento.
     *
     * @return Valor de idElemento.
     */
    public Long getIdElemento() {
        return idElemento;
    }

    /**
     * Establece el nuevo valor de idElemento.
     *
     * @param idElemento Nuevo valor de idElemento.
     */
    public void setIdElemento(Long idElemento) {
        this.idElemento = idElemento;
    }

    /**
     * Obtiene el valor de abreviatura.
     *
     * @return Valor de abreviatura.
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * Establece el nuevo valor de abreviatura.
     *
     * @param abreviatura Nuevo valor de etiqueta.
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * Obtiene el valor de etiqueta.
     *
     * @return Valor de etiqueta.
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Establece el nuevo valor de etiqueta.
     *
     * @param etiqueta Nuevo valor de etiqueta.
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * Obtiene el valor de configuracion.
     *
     * @return Valor de configuracion.
     */
    @Override
    public ConfiguracionCatalogo getConfiguracion() {
        return configuracion;
    }

    /**
     * Establece el nuevo valor de configuracion.
     *
     * @param configuracion Nuevo valor de configuracion.
     */
    public void setConfiguracion(ConfiguracionCatalogo configuracion) {
        this.configuracion = configuracion;
    }
}
