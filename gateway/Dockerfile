# For Gateway
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/Gateway-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Gateway-0.0.1-SNAPSHOT.jar"]
