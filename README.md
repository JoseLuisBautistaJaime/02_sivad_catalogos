# Microservicios NMP - Catálogos Siva Diamantes 

## Inicio

Para construir este microservicio se requieren como versiones mínimas:
 
 * Java 7
 * Maven 3
 
 Además, se debe tener instalada localmente (por Maven) la versión del Arquetipo de Microservicios NMP indicada en el
 archivo pom.xml.

## Información General

El microservicio Catálogos Siva Diamantes proporciona los servicios de consulta de catálogos para el empeño de 
Siva Diamantes, por medio de una interfaz REST.

Para facilitar su despliegue junto con otros micro servicios, en los perfiles dev y local el puerto de despliegue es

```
8082
```

En el perfil cloud, el puerto por defecto es el 80.

El listado completo de catálogos puede consultarse en la ruta:

http://localhost:8082/swagger-ui/index.html

## Despliegue

El despliegue del servicio está configurado para que sea realizado con cada push realizado en control de versiones (GitHub).

En caso de querer realizarlo de manera manual, se deben realizar los siguientes pasos:

1. Empaquetamiento del micro servicio
    
    ```
    mvn package -Pcloud[,swagger,metrics]
    ```

2. Despliegue manual
    
    ```
    cf push dev1775-sivad-catalogos -b https://github.com/cloudfoundry/java-buildpack.git
    ```


## Perfiles

El micro servicio proporciona los siguientes perfiles que permiten orientar el código hacia diferentes ambientes, según
sea el ciclo de desarrollo:

* dev           Perfil de desarrollo local(por default), utilizando H2 en disco como base de datos.
* local         Perfil de desarrollo local, utilizando MySQL como base de datos.
* cloud         Perfil para despliegue en servicios de tipo CloudFoundry.
* metrics       Perfil de metricas (utilizado para la recolección de métricas y NO debe ser levantado de manera aislada).
* swagger       Perfil para pantalla Swagger (NO debe ser levantado de manera aislada).

Para hacer uso de estos perfiles en el micro servicio se utilizan las siguientes instrucciones:

```
mvn -Pdev spring-boot:run
```

```
mvn -Plocal spring-boot:run
```

```
mvn -Pcloud spring-boot:run
```

Si deseas levantar el profile con la recolección de métricas activa, sería de la siguiente manera:

```
mvn -Pdev,metrics spring-boot:run
```

```
mvn -Plocal,metrics spring-boot:run
```

```
mvn -Pcloud,metrics spring-boot:run
```

Para levantar el profile con soporte para la pantalla Swagger y además la recolección de métricas activa,
sería de la siguiente manera:

```
mvn -Pdev,swagger,metrics spring-boot:run
```

```
mvn -Plocal,swagger,metrics spring-boot:run
```

```
mvn -Pcloud,swagger,metrics spring-boot:run
```

NOTA: No es recomendable levantar más de un profile a la vez. Únicamente se permiten multiples profiles 
en el caso de que se combine el perfil base con Metrics y/o Swagger.


## Métricas
El micro servicio tiene la capacidad de recolectar métricas y la forma de activarlas consiste en pasar "metrics" como
profile de Spring. Esto se logra anexando la variable de entorno

```
spring.profiles.active=[dev|local|cloud],metrics
```

Por default se recolectan un conjunto de métricas genéricas, las cuales pueden ser consultadas al acceder el siguiente
endpoint de la aplicación:

http://localhost:8082/metrics
