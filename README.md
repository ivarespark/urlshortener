
# URL Shortener

- API para acortar Link.
- Permite generar y redirigir url.

## Características

- Spring Boot (Java 17)
- Maven
- Base de datos AWS RDS `MySQL 8.0.41`
- Instancia EC2


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
spring.jpa.hibernate.ddl-auto=update
spring.jpa.datasource-platform=org.hibernate.dialect.MySQL8Dialect
```

## Base de Datos
- Crear DB `dburlstn` (nombre opcional)
- Crear tabla `tbl_url`

| Campo         | Tipo Dato   | Longitud |
|:--------------|:------------|:----------|
| l_id          | `bigint`    |
| c_originalurl | `varchar`   | 2048 |
| c_shortlink   | `varchar`   | 50 |
| d_creation    | `datetime`  |
| d_expiration  | `datetime`  |
| l_visits      | `int`       |

