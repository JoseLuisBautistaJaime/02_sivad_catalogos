/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.exception;

import javax.persistence.EntityNotFoundException;

/**
 * Excepción que sera lanzada cudo no se encuetre la configuración de un catálogo.
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
public class CatalogoNotFoundException extends EntityNotFoundException {
    private static final long serialVersionUID = 827992683178785293L;

    private Class<?> entidad;

    /**
     * Constructor.
     *
     * @param message Mensaje informativo.
     * @param entidad Entidad objetivo.
     */
    public CatalogoNotFoundException(String message, Class<?> entidad) {
        super(message);
        this.entidad = entidad;
    }

    /**
     * Obtiene el valor de entidad.
     *
     * @return Valor de entidad.
     */
    public Class<?> getEntidad() {
        return entidad;
    }
}
