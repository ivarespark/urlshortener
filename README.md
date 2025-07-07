
# URL Shortener

- API para acortar Link.
- Permite generar y redirigir url.

## Características

- Spring Boot (Java 17)
- Maven `4.0.0`
- Base de datos `MySQL 8.0`
- Microservicio y db dockerizados


## Dependencias

| Dependencia     | Versión  |
|:----------------|:---------|
| Spring-boot     | `3.2.1`  |
| MySql Connector | `8.1`    |
| Apache Commons  | `3.0`    |
| Google Guava    | `20.0`   |


## Configuración

Crear archivo `.env` en la raiz del proyecto con la siguiente información (sin braces):
```bash
SPRING_DATASOURCE_USERNAME={Usuario conexion db}
SPRING_DATASOURCE_PASSWORD={Password conexion db}
SPRING_DATASOURCE_URL={Ejemplo: jdbc:mysql://db:3306/nombrebasedatos}
MYSQL_ROOT_PASSWORD={Password root}
MYSQL_DATABASE={nombrebasedatos}
MYSQL_USER=={Usuario conexion db}
MYSQL_PASSWORD={Password conexion db}
```
Estos datos son usados por los archivos: `application.properties` y `docker-compose.yml` 

## Ejecución

- Iniciar Docker desktop.


- Ejecutar en bash:
```bash
docker-compose up --build
```
- Si hay problemas ejecutar al ejecutar compose:
```bash
docker-compose down
```

## Base de Datos
- La base de datos se crea en la ejecución con el nombre `{nombrebasedatos}` del archivo `.env`
 
- La tabla `tbl_url` se crea en la ejecución con los siguientes datos:

| Campo         | Tipo Dato  | Longitud |
|:--------------|:-----------|:----------|
| l_id          | `bigint`   |
| c_originalurl | `varchar`  | 2048 |
| c_shortlink   | `varchar`  | 50 |
| d_creation    | `datetime` |
| d_expiration  | `datetime` |
| l_visits      | `bigint`   |
