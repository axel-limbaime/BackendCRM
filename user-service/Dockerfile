# For microservice1 (repeat similar steps for microservice2 and microservice3)
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/UserService-0.0.1-SNAPSHOT.jar .
EXPOSE 8005
ENTRYPOINT ["java", "-jar", "UserService-0.0.1-SNAPSHOT.jar"]
