FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=build/libs/config-server-0.0.1-SNAPSHOT.jar
WORKDIR /app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"] 