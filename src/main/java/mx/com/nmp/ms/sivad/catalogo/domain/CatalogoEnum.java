
package mx.com.nmp.ms.sivad.catalogo.domain;

/**
 *
 * @author madelgadillo
 */
public enum CatalogoEnum {
    
    PERFIL("perfil"),
    RAMO("ramo"),
    SUBRAMO("subramo"),
    SUCURSAL("sucursal"),
    TIPOCONTRATO("tipo_contrato"),
    OPERACIONCAJA("operacion_caja"),
    METAL("metal"),
    QUILATES("quilates"),
    CONTRATO("contrato");
    
    
    private String catalogo;

    CatalogoEnum(String catalogo) {
        this.catalogo = catalogo;
    }

    public String getCatalogo(){
        return catalogo;
    }
    
    
    
    
    
}
