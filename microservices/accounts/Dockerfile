# Use the official OPENJDK 17 image as the base
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /appg

# Copy the executable JAR file from the host to the container
COPY build/libs/accounts-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080



# Define the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT"]