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
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;

/**
 * Entidad abstracta que representa los elementos en común de las familias de colores del diamante.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@MappedSuperclass
@Cache(usage = NONSTRICT_READ_WRITE)
@EntityListeners(JournalEntityListener.class)
@JsonIgnoreProperties({"idElemento", "configuracion"})
public abstract class BaseColor implements CatalogoConfigurable {
    private static final long serialVersionUID = 5974580214479800292L;

    /**
     * Identificador del registro.
     */
    @Id
    @JournalData
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "elemento_id", nullable = false)
    private Long idElemento;

    /**
     * Es el nombre que cualquier sistema de cara al usuario podría utilizar para presentar el elemento.
     */
    @NotNull
    @JournalData
    @Size(min = 1, max = 20)
    @Column(name = "abreviatura", length = 20, nullable = false, unique = true)
    private String abreviatura;

    /**
     * Es el nombre que cualquier sistema de cara al usuario podría utilizar para presentar el elemento.
     */
    @NotNull
    @JournalData
    @Size(max = 150)
    @Column(name = "etiqueta", length = 150, nullable = false)
    private String etiqueta;

    /**
     * Metadata del catálogo. Contiene la definición del catálogo en sí.
     */
    @ManyToOne
    @JoinColumn(name = "id_configuracion")
    private ConfiguracionCatalogo configuracion;

    /**
     * Metadata del catálogo. Contiene la definición del catálogo en sí.
     */
    @ManyToOne
    @JoinColumn(name = "id_rango")
    private RangoPeso rango;

    /**
     * Constructor
     */
    @SuppressWarnings("WeakerAccess")
    protected BaseColor() {
        super();
    }

    /**
     * Obtiene el valor de {@code idElemento}.
     *
     * @return Valor de {@code idElemento}.
     */
    public Long getIdElemento() {
        return idElemento;
    }

    /**
     * Establece el nuevo valor de {@code idElemento}.
     *
     * @param idElemento Nuevo valor de {@code idElemento}.
     */
    @SuppressWarnings("unused")
    public void setIdElemento(Long idElemento) {
        this.idElemento = idElemento;
    }

    /**
     * Obtiene el valor de {@code abreviatura}.
     *
     * @return Valor de {@code abreviatura}.
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * Establece el nuevo valor de {@code abreviatura}.
     *
     * @param abreviatura Nuevo valor de {@code abreviatura}.
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * Obtiene el valor de {@code etiqueta}.
     *
     * @return Valor de {@code etiqueta}.
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Establece el nuevo valor de {@code etiqueta}.
     *
     * @param etiqueta Nuevo valor de {@code etiqueta}.
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

	public RangoPeso getRango() {
		return rango;
	}

	public void setRango(RangoPeso rango) {
		this.rango = rango;
	}

}