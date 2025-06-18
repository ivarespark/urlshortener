
# URL Shortener

- API para acortar Link.
- Permite generar y redirigir url.

## Características

- Spring Boot (Java 17)
- Maven
- Base de datos AWS RDS `MySQL 8.0.41`


## Dependencias


| Dependencia     | Versión  |
|:----------------|:---------|
| Spring-boot     | `3.2.1`  |
| MySql Connector | `8.1`    |
| Apache Commons  | `3.0`    |
| Google Guava    | `20.0`   |


## Necesarios

Crear en carpeta `/resources` archivo `application.properties` con la siguiente información:

```bash
spring.datasource.url=jdbc:mysql://[url-instancia/database]
spring.datasource.username=[user-database]
spring.datasource.password=[user-password]
spring.jpa.hibernate.ddl-auto=none
```

