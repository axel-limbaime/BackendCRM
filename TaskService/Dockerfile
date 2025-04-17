# For TaskService
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/TaskService-0.0.1-SNAPSHOT.jar .
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "TaskService-0.0.1-SNAPSHOT.jar"]
