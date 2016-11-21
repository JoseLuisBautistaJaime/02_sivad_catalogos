/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.config;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import mx.com.nmp.ms.arquetipo.profile.NmpProfile;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLException;

/**
 * Configuración de BD.
 *
 * @author ngonzalez
 */
@Configuration
@EnableJpaRepositories("mx.com.nmp.ms.sivad.catalogo.repository")
public class DatabaseConfiguration {

    @Bean(initMethod = "start", destroyMethod = "stop")
    @Profile(NmpProfile.DEV)
    public Server h2TCPServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers");
    }

    @Bean
    public Hibernate4Module hibernate4Module() {
        return new Hibernate4Module();
    }

}
