# For Gateway_service_registry
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/Gateway_service_registry-0.0.1-SNAPSHOT.jar .
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "Gateway_service_registry-0.0.1-SNAPSHOT.jar"]
