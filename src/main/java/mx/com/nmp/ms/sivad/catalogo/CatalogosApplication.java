/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo;

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
import org.springframework.scheduling.annotation.EnableAsync;

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

    /**
     * Metodo principal de la aplicacion.
     * @param args Lista de parametros.
     */
    public static void main(String[] args) {
        LOGGER.info(">> main");
        SpringApplication.run(CatalogosApplication.class, args);
        LOGGER.info("<< main");
    }
}