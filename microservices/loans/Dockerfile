# Use the official OPENJDK 17 image as the base
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file from the host to the container
COPY /target/loans-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8090

# Define the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]