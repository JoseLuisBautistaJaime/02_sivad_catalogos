/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.domain;

/**
 * Enumeración que contienen las configuraciones de catálogos existentes, por ejemplo: TipoPrenda, GradoColor, Color.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public enum ConfiguracionCatalogoEnum {
    TIPO_PRENDA("TipoPrenda", DominioEnum.ALHAJAS),
    GRADO_COLOR("GradoColor", DominioEnum.DIAMANTES),
    COLOR("Color", DominioEnum.DIAMANTES),
    ESCALA_COLOR("EscalaColor", DominioEnum.DIAMANTES),
    GRUPO_COLOR("GrupoColor", DominioEnum.DIAMANTES);

    private String tipo;
    private DominioEnum dominio;

    /**
     * Constructor.
     *
     * @param tipo Nombre del tipo de Catálogo.
     * @param dominio Constante que identifica el dominio del catálogo.
     */
    ConfiguracionCatalogoEnum(String tipo, DominioEnum dominio) {
        this.tipo = tipo;
        this.dominio = dominio;
    }

    /**
     * Obtiene el valor de {@code tipo}.
     *
     * @return Valor de {@code tipo}.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el valor de {@code dominio}.
     *
     * @return Valor de {@code dominio}.
     */
    public DominioEnum getDominio() {
        return dominio;
    }
}
