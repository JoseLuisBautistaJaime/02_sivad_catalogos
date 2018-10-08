/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Propiedades de la aplicacion
 *
 * @author osanchez
 */
@ConfigurationProperties(prefix = "microservicio", ignoreUnknownFields = false)
public class AppProperties {

    private final Cache cache = new Cache();
    private Long rango;

    private final Mail mail = new Mail();

    public Cache getCache() {
        return cache;
    }

    public static class Cache {

        private int timeToLiveSeconds = 3600;
        private final Hazelcast hazelcast = new Hazelcast();

        public int getTimeToLiveSeconds() {
            return timeToLiveSeconds;
        }

        public void setTimeToLiveSeconds(int timeToLiveSeconds) {
            this.timeToLiveSeconds = timeToLiveSeconds;
        }

        public Hazelcast getHazelcast() {
            return hazelcast;
        }

        public static class Hazelcast {

            private int backupCount = 1;

            public int getBackupCount() {
                return backupCount;
            }

            public void setBackupCount(int backupCount) {
                this.backupCount = backupCount;
            }
        }
    }

    public Mail getMail() {
        return mail;
    }

    public class Mail{
        private String plataforma;

        public String getPlataforma() {
            return plataforma;
        }

        public void setPlataforma(String plataforma) {
            this.plataforma = plataforma;
        }
    }

	public Long getRango() {
		return rango;
	}

	public void setRango(Long rango) {
		this.rango = rango;
	}
}
