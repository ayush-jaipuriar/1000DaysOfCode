# Use the official OPENJDK 17 image as the base
FROM eclipse-temurin:17-jre-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file from the host to the container
ARG JAR_FILE=build/libs/loans-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Define the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]