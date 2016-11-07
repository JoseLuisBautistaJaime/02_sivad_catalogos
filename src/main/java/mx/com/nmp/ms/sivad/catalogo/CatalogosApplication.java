/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo;

import mx.com.nmp.ms.arquetipo.profile.DefaultProfileUtil;
import mx.com.nmp.ms.arquetipo.profile.NmpProfile;
import mx.com.nmp.ms.sivad.catalogo.config.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Aplicación SpringBoot - Microservicio de Catálogos.
 *
 * @author ngonzalez
 */
@ComponentScan
@EnableAutoConfiguration(exclude = { MetricFilterAutoConfiguration.class, MetricRepositoryAutoConfiguration.class })
@EnableConfigurationProperties({AppProperties.class})
@EnableAsync
@EnableAspectJAutoProxy
public class CatalogosApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogosApplication.class);

    @Inject
    private Environment env;

    /**
     * Despues de inicializacion.
     * <p>
     * Se pueden especificar perfiles como argumentos de línea de comandos: --spring.profiles.active=el-perfil-activo
     */
    @PostConstruct
    public void initApplication() {
        LOGGER.info("Ejecutando con perfil(es) de Spring : {}", Arrays.toString(env.getActiveProfiles()));
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains(NmpProfile.DEV) && activeProfiles.contains(NmpProfile.PROD)) {
            LOGGER.error("Hay un problema de configuración. No deberían estar presentes los perfiles Dev y Prod a la vez.");
        }
    }

    /**
     * Metodo principal de la aplicacion.
     * @param args Lista de parametros.
     */
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(CatalogosApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);

        Environment env = app.run(args).getEnvironment();
        LOGGER.info("\n----------------------------------------------------------\n\t" +
                "Aplicacion '{}' en ejecucion. URLs:\n\t" +
                "Local: \t\thttp://127.0.0.1:{}\n\t" +
                "Externa: \thttp://{}:{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            env.getProperty("server.port"),
            InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"));

        String configServerStatus = env.getProperty("configserver.status");
        LOGGER.info("\n----------------------------------------------------------\n\t" +
                "Servidor de Configuracion: \t{}\n----------------------------------------------------------",
            configServerStatus == null ? "No encontrado o no establecido." : configServerStatus);
    }
}
