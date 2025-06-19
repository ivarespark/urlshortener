# Build aplicacion
FROM maven-3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

# Deploy aplicacion
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/urlshortering-0.0.1-SNAPSHOT.jar ./urlshortering.jar
EXPOSE 8080
CMD ["jav","-jar", "urlshortering.jar"]