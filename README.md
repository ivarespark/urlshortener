
# URL Shortener 

- API para acortar Link.
- Permite generar y redirigir url.

## Características ténicas

- Java `17`
- Spring Boot `3.2.1` 
- Maven `4.0.0`
- Base de datos `MySQL 8.0`
- Microservicio y db dockerizados
- Autenticación no implementada


## Dependencias

| Dependencia     | Versión  |
|:----------------|:---------|
| Spring-boot     | `3.2.1`  |
| MySql Connector | `8.1`    |
| Apache Commons  | `3.0`    |
| Google Guava    | `20.0`   |


## Configuración

Crear archivo `.env` en la raiz del proyecto con la siguiente información (sin braces):
```
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

## Endpoints

### Generar
- Endpoint: `http://[ruta]:[puerto]/api/v1/generate`
- Método: `POST`
- Body:
```
{
  "url":"https://www.google.com/",
  "expirationDate":"2026-01-02 18:00"
}
```
- Retorno:
```
{
  "originalUrl": "https://www.google.com/",
  "shortLink": "{shortlink generado}",
  "expirationDate": "2026-01-02T18:00:00"
}
```

### Redireccionar
- Endpoint: `http://[ruta]:[puerto]/{shortlink generado}`
- Método: `GET`
- Retorno: redirecciona a url original.


## Base de Datos
- La base de datos se crea en la ejecución con el nombre `{nombrebasedatos}` del archivo `.env`
 
- La tabla `tbl_url` se crea en la ejecución con los siguientes campos:

| Campo         | Tipo Dato  | Longitud |
|:--------------|:-----------|:---------|
| l_id          | `bigint`   |
| c_originalurl | `varchar`  | 2048     |
| c_shortlink   | `varchar`  | 50       |
| d_creation    | `datetime` |
| d_expiration  | `datetime` |
| l_visits      | `bigint`   |
