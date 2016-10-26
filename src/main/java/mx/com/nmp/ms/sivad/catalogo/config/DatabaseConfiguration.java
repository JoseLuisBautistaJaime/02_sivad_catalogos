/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configuración de BD.
 *
 * @author ngonzalez
 */
@Configuration
@EnableJpaRepositories("mx.com.nmp.ms.sivad.catalogo.repository")
public class DatabaseConfiguration {

}
