FROM eclipse-temurin:17-alpine
RUN mkdir /app
WORKDIR /app
COPY target/urlshortering-0.0.1-SNAPSHOT.jar /app/urlshortering.jar
EXPOSE 8080
CMD java -jar urlshortering.jar