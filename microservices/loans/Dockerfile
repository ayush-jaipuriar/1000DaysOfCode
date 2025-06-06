# Use the official OPENJDK 17 image as the base
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file from the host to the container
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# Expose the application port
EXPOSE 8090

# Define the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]