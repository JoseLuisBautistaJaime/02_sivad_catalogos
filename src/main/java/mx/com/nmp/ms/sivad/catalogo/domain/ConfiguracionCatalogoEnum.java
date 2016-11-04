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

    // Ordenar alfabéticamente.

    CALIDAD_LEY("CalidadLey", DominioEnum.ALHAJAS),
    CERTIFICADO_DIAMANTES("CertificadoDiamantes", DominioEnum.DIAMANTES),
    CLARIDAD_DIAMANTE("ClaridadDiamante", DominioEnum.DIAMANTES),
    COLOR("Color", DominioEnum.DIAMANTES),
    COLOR_ORO("ColorOro", DominioEnum.ALHAJAS),
    CONDICION_PRENDA("CondicionPrenda",DominioEnum.DIAMANTES),
    ESCALA_COLOR("EscalaColor", DominioEnum.DIAMANTES),
    GRADO_COLOR("GradoColor", DominioEnum.DIAMANTES),
    GRUPO_COLOR("GrupoColor", DominioEnum.DIAMANTES),
    METAL("Metal", DominioEnum.ALHAJAS),
    MOTIVO_BAJA_PRESTAMO("MotivoBajaPrestamo", DominioEnum.DIAMANTES),
    QUILATAJE_ORO("QuilatajeOro", DominioEnum.ALHAJAS),
    TIPO_PIEDRA_COMPLEMENTARIA("TipoPiedraComplementaria", DominioEnum.DIAMANTES),
    TIPO_PRENDA("TipoPrenda", DominioEnum.ALHAJAS);

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

    /**
     * Obtiene el valor de {@code dominio.dominio}.
     *
     * @return Valor de {@code dominio.dominio}.
     */
    public String getDominioUnwrap() {
        return dominio.getDominio();
    }
}
