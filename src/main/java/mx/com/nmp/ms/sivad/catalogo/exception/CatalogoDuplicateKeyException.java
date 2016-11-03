/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.exception;

import org.springframework.dao.DuplicateKeyException;

/**
 * Excepción que será lanzada cuando una llave del catálogo este duplicada.
 *
 * @author ngonzalez
 */
public class CatalogoDuplicateKeyException extends DuplicateKeyException {

    private static final long serialVersionUID = 827992683168782593L;

    private Class<?> entidad;



    // METODOS

    /**
     * Constructor.
     *
     * @param msg Mensaje informativo.
     * @param entidad Entidad objetivo.
     */
    public CatalogoDuplicateKeyException(String msg, Class<?> entidad) {
        super(msg);
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
