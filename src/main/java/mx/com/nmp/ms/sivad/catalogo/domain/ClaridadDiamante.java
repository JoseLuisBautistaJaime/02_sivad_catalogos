/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import mx.com.nmp.ms.arquetipo.annotation.journal.JournalData;
import mx.com.nmp.ms.arquetipo.journal.listener.JournalEntityListener;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entidad que representa el catálogo de Claridad de Diamante
 *
 * @author roramirez
 */

@Entity
@Table(name = "cat_claridad_diamante")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"idElemento", "configuracion", "rango"})
@EntityListeners(JournalEntityListener.class)
public class ClaridadDiamante implements CatalogoConfigurable{

    private static final long serialVersionUID = 7287797032664347379L;

    /**
     * Constructor.
     */
    public ClaridadDiamante(){ super();}

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

    /**
     * Rango del catálogo. Contiene la definición del catálogo en sí.
     */
    @ManyToOne
    @JoinColumn(name = "id_rango")
    private RangoPeso rango;

    /**
     * Permite obtener la cadena completa de los valores de los atributos de la clase.
     *
     * @return Cadena con los valores de los atributos de la clase.
     */
    @Override
    public String toString() {
        return "ClaridadDiamante{" +
                "idElemento=" + idElemento +
                ", abreviatura='" + abreviatura + '\'' +
                ", etiqueta='" + etiqueta + '\'' +
                ", configuracion=" + ((configuracion != null) ? configuracion.toString() : "null") +
                ", rango=" + ((rango != null) ? rango.toString() : "null") +
                '}';
    }

    /**
     * Permite obtener el valor de la propiedad "configuracion".
     *
     * @return Valor de la propiedad "configuracion".
     */
    @Override
    public ConfiguracionCatalogo getConfiguracion() {
        return this.configuracion;
    }

    /**
     * Permite establecer el valor de la propiedad "configuracion".
     *
     * @param configuracion El nuevo valor de la propiedad "configuracion".
     */
    public void setConfiguracion(ConfiguracionCatalogo configuracion) {
        this.configuracion = configuracion;
    }


    // GETTERS Y SETTERS
    /**
     * Permite obtener el valor de la propiedad "idElemento".
     *
     * @return Valor de la propiedad "idElemento".
     */
    public Long getIdElemento() {
        return idElemento;
    }

    /**
     * Permite establecer el valor de la propiedad "idElemento".
     *
     * @param idElemento El nuevo valor de la propiedad "idElemento".
     */
    public void setIdElemento(Long idElemento) {
        this.idElemento = idElemento;
    }

    /**
     * Permite obtener el valor de la propiedad "abreviatura".
     *
     * @return Valor de la propiedad "abreviatura".
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * Permite establecer el valor de la propiedad "abreviatura".
     *
     * @param abreviatura El nuevo valor de la propiedad "abreviatura".
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * Permite obtener el valor de la propiedad "etiqueta".
     *
     * @return Valor de la propiedad "etiqueta".
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Permite establecer el valor de la propiedad "etiqueta".
     *
     * @param etiqueta El nuevo valor de la propiedad "etiqueta".
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

	public RangoPeso getRango() {
		return rango;
	}

	public void setRango(RangoPeso rango) {
		this.rango = rango;
	}
}
