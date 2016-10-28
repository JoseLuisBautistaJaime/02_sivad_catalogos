package mx.com.nmp.ms.sivad.catalogo.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import mx.com.nmp.ms.arquetipo.date.CustomDateTimeDeserializer;
import mx.com.nmp.ms.arquetipo.date.CustomDateTimeSerializer;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entidad empleada para clasificar los diferentes catálogos que se manejarán dentro de NMP.
 * Esta configuración permite separar por dominio y tipo, cada catálogo para los diferentes productos.
 *
 * @author osanchez
 */
@Entity
@Table(name = "cnf_configuracion_catalogo")
public class ConfiguracionCatalogo {

    /**
     * Identificador y clave de la configuración.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Nombre del dominio asociado a un catálogo, por ejemplo: Diamantes, Alhajas, Autos.
     */
    @NotNull
    @Size(min = 1)
    @Column(name = "dominio", nullable = false)
    private String dominio;

    /**
     * Nombre del tipo de catálogo, permite especificar a detalle el tipo de catálogo dentro de determinado dominio.
     */
    @NotNull
    @Size(min = 1)
    @Column(name = "tipo", nullable = false)
    private String tipo;

    /**
     * Usado para identificar el valor por defecto para determinado catálogo.
     */
    @Column(name = "valor_default")
    private String valorDefault;

    /**
     * Descripción asociada a la entrada del catálogo; uso informativo.
     */
    @Column(name = "descripcion")
    private String descripcion;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    @Column(name = "ultima_actualizacion", nullable = true)
    private DateTime ultimaActualizacion;

    /**
     * Constructor vacio
     */
    public ConfiguracionCatalogo() {
        // Constructor vacio
    }

    /**
     * @param id                  Identificador y clave de la configuración.
     * @param dominio             Nombre del dominio asociado a un catálogo, por ejemplo: Diamantes, Alhajas, Autos.
     * @param tipo                Nombre del tipo de catálogo, permite especificar a detalle el tipo de catálogo dentro de determinado dominio.
     * @param valorDefault        Usado para identificar el valor por defecto para determinado catálogo.
     * @param descripcion         Descripción asociada a la entrada del catálogo; uso informativo.
     * @param ultimaActualizacion Fecha de última actualización del catálogo.
     */
    public ConfiguracionCatalogo(Long id, String dominio, String tipo, String valorDefault, String descripcion, DateTime ultimaActualizacion) {
        this.id = id;
        this.dominio = dominio;
        this.tipo = tipo;
        this.valorDefault = valorDefault;
        this.descripcion = descripcion;
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConfiguracionCatalogo id(Long id) {
        this.id = id;
        return this;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public ConfiguracionCatalogo dominio(String dominio) {
        this.dominio = dominio;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ConfiguracionCatalogo tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getValorDefault() {
        return valorDefault;
    }

    public void setValorDefault(String valor_default) {
        this.valorDefault = valor_default;
    }

    public ConfiguracionCatalogo valorDefault(String valor_default) {
        this.valorDefault = valor_default;
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ConfiguracionCatalogo descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public DateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(DateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public ConfiguracionCatalogo ultimaActualizacion(DateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConfiguracionCatalogo{");
        sb.append("id=").append(id);
        sb.append(", dominio='").append(dominio).append('\'');
        sb.append(", tipo='").append(tipo).append('\'');
        sb.append(", valorDefault='").append(valorDefault).append('\'');
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", ultimaActualizacion='").append(ultimaActualizacion).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
