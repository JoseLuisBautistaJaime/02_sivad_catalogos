/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.domain;

/**
 * Enumeración que contienen los dominios asociados a los catálogos, por ejemplo: Diamantes, Alhajas, Autos.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public enum DominioEnum {

    // Ordenar alfabéticamente.

    ALHAJAS("Alhajas"),
    DIAMANTES("Diamantes"),
    PERFILES("Perfiles"),
    RAMOS("Ramos"),
    SUBRAMOS("Subramos"),
    SUCURSALES("Sucursales"),
    TIPOSCONTRATOS("Contratos"),
    OPERACIONES("Operaciones");

    private String dominio;

    /**
     * Constructor.
     *
     * @param dominio Nombre del dominio
     */
    DominioEnum(String dominio) {
        this.dominio = dominio;
    }

    /**
     * Obtiene el valor de {@code dominio}.
     *
     * @return Valor de {@code dominio}.
     */
    public String getDominio() {
        return dominio;
    }
}
