FROM openjdk:17-jdk-alpine
WORKDIR /app
ARG JAR_FILE=target/buscador-service-1.0.0.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
