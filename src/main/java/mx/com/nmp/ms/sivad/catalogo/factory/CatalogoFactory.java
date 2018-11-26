/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.factory;

import mx.com.nmp.ms.sivad.catalogo.domain.BaseColor;
import mx.com.nmp.ms.sivad.catalogo.domain.CatalogoConfigurable;
import mx.com.nmp.ms.sivad.catalogo.domain.ClaridadDiamante;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.FCWithoutDependenciesProjection;
import mx.com.nmp.ms.sivad.catalogo.domain.RangoPeso;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Fabrica que se encarga de crear objetos del dto {@link Catalogo}
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public final class CatalogoFactory {
    /**
     * Constructor.
     */
    private CatalogoFactory() {
        super();
    }

    /**
     * Crear un objeto {@link Catalogo}
     *
     * @param configuracion Configuración del catalogo {@link ConfiguracionCatalogo}
     * @param elementos Elemtos del catálogo.
     *
     * @return Objeto {@link Catalogo}
     */
    public static Catalogo build(ConfiguracionCatalogo configuracion, List<? extends Serializable> elementos) {
        Catalogo catalogo = getCatalogo(configuracion);
        catalogo.setElementos(elementos);
        catalogo.setRango(getRango(elementos));
        return catalogo;
    }

    /**
     * Crear un objeto {@link Catalogo}
     *
     * @param elemento Elemento del catálogo {@link CatalogoConfigurable}
     *
     * @return Objeto {@link Catalogo}
     */
    public static Catalogo build(CatalogoConfigurable elemento) {
        return build(Collections.singletonList(elemento));
    }

    /**
     * Crear un objeto {@link Catalogo}
     *
     * @param elementos Elementos del catálogo {@link CatalogoConfigurable}
     *
     * @return Objeto {@link Catalogo}
     */
    public static Catalogo build(List<? extends CatalogoConfigurable> elementos) {
        Catalogo catalogo = getCatalogo(getConfiguracion(elementos));
        catalogo.setElementos(elementos);
        catalogo.setRango(getRango(elementos));
        return catalogo;
    }

    /**
     * Crea un objeto Catalogo apartir de la configuración.
     *
     * @param configuracion Configuración del catalogo {@link ConfiguracionCatalogo}
     *
     * @return Objeto {@link Catalogo}
     */
    private static Catalogo getCatalogo(ConfiguracionCatalogo configuracion) {
        Catalogo catalogo = new Catalogo();

        catalogo.setDominio(configuracion.getDominio());
        catalogo.setTipo(configuracion.getTipo());
        catalogo.setValorDefault(configuracion.getValorDefault());
        catalogo.setDescripcion(configuracion.getDescripcion());
        catalogo.setUltimaActualizacion(configuracion.getUltimaActualizacion());

        return catalogo;
    }

    /**
     * Recupera la configuración del catálogo
     *
     * @param ccs Lista de elementos del catálogo.
     *
     * @return Objeto {@link ConfiguracionCatalogo}
     */
    private static ConfiguracionCatalogo getConfiguracion(List<? extends CatalogoConfigurable> ccs) {
        return ccs.get(0).getConfiguracion();
    }

    /**
     * Obtiene el rango si es un catalogo de colores
     * @param elementos
     * @return
     */
	private static String getRango(List<? extends Serializable> elementos) {
		String rango = null;
		if (elementos != null && elementos.size() > 1) {
        	if (elementos.get(0) instanceof BaseColor) {
        		RangoPeso rangoPeso = ((BaseColor)elementos.get(0)).getRango();
        		rango = rangoPeso != null ? rangoPeso.getEtiqueta() : null;
        	}
        	if (elementos.get(0) instanceof FCWithoutDependenciesProjection) {
        		RangoPeso rangoPeso = ((FCWithoutDependenciesProjection)elementos.get(0)).getRango();
        		rango = rangoPeso != null ? rangoPeso.getEtiqueta() : null;
        	}
        	if (elementos.get(0) instanceof ClaridadDiamante) {
        		RangoPeso rangoPeso = ((ClaridadDiamante)elementos.get(0)).getRango();
        		rango = rangoPeso != null ? rangoPeso.getEtiqueta() : null;
        	}
        }
		return rango;
	}

}
