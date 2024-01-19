
# URL Shortener

- API para acortar Link.
- Permite generar y redirigir url.

## Características

- Spring Boot (Java 17)
- Maven
- Base de datos MySQL
- Uso de Fly.io y PlanetScale


## Dependenciass


| Dependencia | Versión     |
| :-----------| :------- |
| Spring-boot | `3.2.1` |
| MySql Connector | `8.1` |
| Apache Commons | `3.0` |
| Google Guava | `20.0` |


## Necesarios

Crear en carpeta `/resources` archivo `application.properties` con la siguiente información:

```bash
spring.datasource.url=jdbc:mysql:[url-database]
spring.datasource.username=[user-database]
spring.datasource.password=[user-password]
spring.jpa.hibernate.ddl-auto=none
```
Generar archivo `.jar` se guardara en carpeta `/target` con nombre: `[nombre-proyecto]-0.0.1-SNAPSHOT.jar`  

Crear archivo `Dockerfile` en la raíz del proyecto con la siguiente información:

```bash
FROM eclipse-temurin:17-alpine
RUN mkdir /app
WORKDIR /app
COPY target/[nombre-proyecto]-0.0.1-SNAPSHOT.jar /app/[nombre-proyecto].jar
EXPOSE 8080
CMD java -jar [nombre-proyecto].jar
```

## Fly.io & PlanetScale
Comming soon...
