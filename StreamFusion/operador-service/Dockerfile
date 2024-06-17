FROM openjdk:17-jdk-alpine
WORKDIR /app
ARG JAR_FILE=target/operador-service-1.0.0.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8083
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
