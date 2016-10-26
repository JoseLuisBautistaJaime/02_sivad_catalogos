/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest.util;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URISyntaxException;

/**
 * Clase de ayuda para manejar paginación.
 * <p>
 * La paginación usa los mismos principios que <a href="https://developer.github.com/v3/#pagination">Github API</a>,
 * y sigue <a href="http://tools.ietf.org/html/rfc5988">RFC 5988 (Link header)</a>.
 *
 * @author osanchez
 */
public class PaginationUtil {

    /**
     * Constructor.
     */
    private PaginationUtil() {
        throw new IllegalAccessError("Utility class");
    }

    /**
     * Permite crear los headers de la página indicada.
     * @param page La página.
     * @param baseUrl La URL base.
     * @return El HttpHeaders creado.
     * @throws URISyntaxException
     */
    public static HttpHeaders generatePaginationHttpHeaders(Page<?> page, String baseUrl)
            throws URISyntaxException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", "" + page.getTotalElements());
        String link = "";
        if ((page.getNumber() + 1) < page.getTotalPages()) {
            link = "<" + generateUri(baseUrl, page.getNumber() + 1, page.getSize()) + ">; rel=\"next\",";
        }
        // prev link
        if ((page.getNumber()) > 0) {
            link += "<" + generateUri(baseUrl, page.getNumber() - 1, page.getSize()) + ">; rel=\"prev\",";
        }
        // last and first link
        int lastPage = 0;
        if (page.getTotalPages() > 0) {
            lastPage = page.getTotalPages() - 1;
        }
        link += "<" + generateUri(baseUrl, lastPage, page.getSize()) + ">; rel=\"last\",";
        link += "<" + generateUri(baseUrl, 0, page.getSize()) + ">; rel=\"first\"";
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }

    private static String generateUri(String baseUrl, int page, int size) throws URISyntaxException {
        return UriComponentsBuilder.fromUriString(baseUrl).queryParam("page", page).queryParam("size", size).toUriString();
    }
}