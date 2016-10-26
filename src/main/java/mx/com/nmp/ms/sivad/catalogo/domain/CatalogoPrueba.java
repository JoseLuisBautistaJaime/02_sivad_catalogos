/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Entidad de prueba de tipo "CatalogoPrueba".
 *
 * @author ngonzalez
 */
@Entity
@Table(name = "catalogo_prueba")
public class CatalogoPrueba implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1)
    @Column(name = "abreviatura", nullable = false)
    private String abreviatura;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "catalogo")
    private String catalogo;



    // METODOS

    /**
     * Constructor de la clase.
     */
    public CatalogoPrueba() {

    }



    // GETTERS Y SETTERS

    /**
     * Permite obtener el valor de la propiedad "id".
     * @return Valor de la propiedad "id".
     */
    public Long getId() {
        return id;
    }

    /**
     * Permite establecer el valor de la propiedad "id".
     * @param id El nuevo valor de la propiedad "id".
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Permite obtener el valor de la propiedad "abreviatura".
     * @return Valor de la propiedad "abreviatura".
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * Permite establecer el valor de la propiedad "abreviatura".
     * @param abreviatura El nuevo valor de la propiedad "abreviatura".
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     * Permite obtener el valor de la propiedad "descripcion".
     * @return Valor de la propiedad "descripcion".
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Permite establecer el valor de la propiedad "descripcion".
     * @param descripcion El nuevo valor de la propiedad "descripcion".
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Permite obtener el valor de la propiedad "catalogo".
     * @return Valor de la propiedad "catalogo".
     */
    public String getCatalogo() {
        return catalogo;
    }

    /**
     * Permite establecer el valor de la propiedad "catalogo".
     * @param catalogo El nuevo valor de la propiedad "catalogo".
     */
    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    /**
     * Permite obtener la cadena completa de los valores de los atributos de la clase.
     * @return Cadena completa de los valores de los atributos.
     */
    @Override
    public String toString() {
        return "Catalogo{" +
                "id=" + id +
                ", abreviatura='" + abreviatura + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", catalogo='" + catalogo + '\'' +
                '}';
    }
}