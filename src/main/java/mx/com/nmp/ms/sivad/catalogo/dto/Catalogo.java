/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import mx.com.nmp.ms.arquetipo.date.CustomDateTimeSerializer;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.List;

/**
 * Objeto dto (por sus siglas en inlges Data Transfer Object) será el tipo de dato que regresen todos los catálogos,
 * este objeto permite la correcta serialización al formato json.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@JsonRootName("catalogo")
public class Catalogo implements Serializable {
    private static final long serialVersionUID = -6312079590372674003L;

    /**
     * Debe especificar el nombre del dominio al que pertenece el catálogo (ej. Diamantes, Autos, Alhajas, otro)
     */
    private String dominio;

    /**
     * Nombre que identifica al catálogo/entidad
     */
    private String tipo;

    /**
     * Campo para indicar si el elemento debe tomarse como una opción default. Solamente un elemento de cada
     * catálogo deberá estar indicado como opción default (valor=true)
     */
    private String valorDefault;

    /**
     * Elemento para describir el propósito del catálogo o proveer información adicional para su utilización.
     */
    private String descripcion;

    /**
     * Fecha de última actualización del catálogo.
     */
    private DateTime ultimaActualizacion;

    /**
     * Lista de elementos que contiene el catálogo.
     */
    @JsonProperty("listaValores")
    private List<? extends Serializable> elementos;

    /**
     * Constructor.
     */
    public Catalogo() {
        super();
    }

    /**
     * Obtiene el valor de dominio.
     *
     * @return Valor de dominio.
     */
    public String getDominio() {
        return dominio;
    }

    /**
     * Establece el nuevo valor de dominio.
     *
     * @param dominio Nuevo valor de dominio.
     */
    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    /**
     * Obtiene el valor de tipo.
     *
     * @return Valor de tipo.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el nuevo valor de tipo.
     *
     * @param tipo Nuevo valor de tipo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el valor de valorDefault.
     *
     * @return Valor de valorDefault.
     */
    public String getValorDefault() {
        return valorDefault;
    }

    /**
     * Establece el nuevo valor de valorDefault.
     *
     * @param valorDefault Nuevo valor de valorDefault.
     */
    public void setValorDefault(String valorDefault) {
        this.valorDefault = valorDefault;
    }

    /**
     * Obtiene el valor de descripcion.
     *
     * @return Valor de descripcion.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece el nuevo valor de descripcion.
     *
     * @param descripcion Nuevo valor de descripcion.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el valor de fechaUltimaActualizacion.
     *
     * @return Valor de fechaUltimaActualizacion.
     */
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    public DateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    /**
     * Establece el nuevo valor de fechaUltimaActualizacion.
     *
     * @param ultimaActualizacion Nuevo valor de fechaUltimaActualizacion.
     */
    public void setUltimaActualizacion(DateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    /**
     * Obtiene la lista de elementos que contiene el catálogo.
     *
     * @return Lista de elementos que contiene el catálogo.
     */
    public List<? extends Serializable> getElementos() {
        return elementos;
    }

    /**
     * Establece la nueva lista de elementos del catálogo.
     *
     * @param elementos Valor de la lista de elementos del catálogo.
     */
    public void setElementos(List<? extends Serializable> elementos) {
        this.elementos = elementos;
    }
}
