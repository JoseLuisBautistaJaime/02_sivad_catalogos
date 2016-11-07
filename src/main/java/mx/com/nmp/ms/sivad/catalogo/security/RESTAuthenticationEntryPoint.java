package mx.com.nmp.ms.sivad.catalogo.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Authentication entry point for REST services
 * <p>
 * We can tell Spring Security exactly what to do if someone tries to access a protected resource
 * without being authenticated.
 */
@Component
public class RESTAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * If the client accesses a resource but is not authenticated, we respond with a 401 Unauthorized status
     *
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
        throws IOException, ServletException {

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}
