package mx.com.nmp.ms.sivad.catalogo.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.instance.HazelcastInstanceFactory;
import mx.com.nmp.ms.arquetipo.config.CoreDatabaseConfiguration;
import mx.com.nmp.ms.arquetipo.config.CoreMetricsConfiguration;
import mx.com.nmp.ms.arquetipo.profile.NmpProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PreDestroy;
import javax.inject.Inject;

/**
 * Configuración de caché.
 *
 * @author osanchez
 */
@SuppressWarnings("unused")
@Configuration
@EnableCaching
@AutoConfigureAfter(value = {CoreMetricsConfiguration.class, CoreDatabaseConfiguration.class, DatabaseConfiguration.class})
public class CacheConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheConfiguration.class);

    private static HazelcastInstance hazelcastInstance;

    @Inject
    private Environment env;

    @Inject
    private DiscoveryClient discoveryClient;

    @Inject
    private ServerProperties serverProperties;

    private CacheManager cacheManager;

    @PreDestroy
    public void destroy() {
        LOGGER.info("Cerrando Administrador de Cache");
        Hazelcast.shutdownAll();
    }

    @Bean
    public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
        LOGGER.debug("Iniciando HazelcastCacheManager");
        cacheManager = new com.hazelcast.spring.cache.HazelcastCacheManager(hazelcastInstance);
        return cacheManager;
    }

    @Bean
    public HazelcastInstance hazelcastInstance(AppProperties appProperties) {
        LOGGER.debug("Configurando Hazelcast");
        Config config = new Config();
        config.setInstanceName("sivad-catalogos");
        // serviceId is por default el nombre de la aplicación, ver propiedad Spring Boot's eureka.instance.appname
        String serviceId = discoveryClient.getLocalServiceInstance().getServiceId();
        LOGGER.debug("Configurando cluster Hazelcast para instanceId: {}", serviceId);

        // En desarrollo va por 127.0.0.1, con puerto diferente
        if (env.acceptsProfiles(NmpProfile.DEV)) {
            LOGGER.debug("La aplicacion se esta ejecutando con el profile \"dev\", el cluster Hazelcast " +
                    "trabajara solamente con instancias de localhost");

            System.setProperty("hazelcast.local.localAddress", "127.0.0.1");
            config.getNetworkConfig().setPort(serverProperties.getPort() + 5701);
            config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
            config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(true);
            for (ServiceInstance instance : discoveryClient.getInstances(serviceId)) {
                String clusterMember = "127.0.0.1:" + (instance.getPort() + 5701);
                LOGGER.debug("Agregando miembro de cluster Hazelcast (dev) " + clusterMember);
                config.getNetworkConfig().getJoin().getTcpIpConfig().addMember(clusterMember);
            }
        } else { // Configuración de Producción, un host por instancia, todos usando el puerto 5701
            config.getNetworkConfig().setPort(5701);
            config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
            config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(true);
            for (ServiceInstance instance : discoveryClient.getInstances(serviceId)) {
                String clusterMember = instance.getHost() + ":5701";
                LOGGER.debug("Agregando miembro de cluster Hazelcast (prod) " + clusterMember);
                config.getNetworkConfig().getJoin().getTcpIpConfig().addMember(clusterMember);
            }
        }


        config.getMapConfigs().put("default", initializeDefaultMapConfig());
        config.getMapConfigs().put("mx.com.nmp.ms.catalogo.domain.*", initializeDomainMapConfig(appProperties));

        hazelcastInstance = HazelcastInstanceFactory.newHazelcastInstance(config);

        return hazelcastInstance;
    }

    private MapConfig initializeDefaultMapConfig() {
        MapConfig mapConfig = new MapConfig();

        /*
            Numero de backups. Si se establece 1 como el contador de backup,
            entonces todas las entradas del mapa serán copiadas a otra JVM
            por seguridad. Numeros válidos son 0 (sin copia de respaldo, 1, 2, 3.
         */
        mapConfig.setBackupCount(0);

        /*
            Valores válidos son:
            NONE (sin desalojo),
            LRU (Least Recently Used, ultimo recientemente utilizado),
            LFU (Least Frequently Used, ultimo frecuentemente utilizado).
            NONE es el default.
         */
        mapConfig.setEvictionPolicy(EvictionPolicy.LRU);

        /*
            Tamaño máximo del mapa. Cuando el tamaño máximo es alcanzado
            el mapa es desalojado con base en la política definida.
            Cualquier entero entre 0 y Integer.MAX_VALUE
            0 significa Integer.MAX_VALUE. Default es 0.
         */
        mapConfig.setMaxSizeConfig(new MaxSizeConfig(0, MaxSizeConfig.MaxSizePolicy.USED_HEAP_SIZE));

        /*
            Cuando se alcanza el tamaño máximo, el porcentaje espeficicado es desalojado.
            Cualquier entero entre 0 y 100.
            Si se establece 25, por ejemplo, 25% de las entradas serán desalojadas.
         */
        mapConfig.setEvictionPercentage(25);

        return mapConfig;
    }

    private MapConfig initializeDomainMapConfig(AppProperties appProperties) {
        MapConfig mapConfig = new MapConfig();

        mapConfig.setTimeToLiveSeconds(appProperties.getCache().getTimeToLiveSeconds());
        return mapConfig;
    }

    /**
     * @return instancia unica
     */
    public static HazelcastInstance getHazelcastInstance() {
        return hazelcastInstance;
    }
}
