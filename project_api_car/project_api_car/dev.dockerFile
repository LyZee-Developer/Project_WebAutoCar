# Use a base image with Java installed
FROM openjdk:21-jdk-alpine

# Define an argument for the JAR file path
ARG JAR_FILE=target/*.jar

# Copy the JAR file from the host (or previous build stage) into the container
COPY ${JAR_FILE} app.jar

# Expose the default Spring Boot port
EXPOSE 90

# Set the entry point command to run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
