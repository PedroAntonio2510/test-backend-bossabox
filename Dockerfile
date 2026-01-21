# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -DskipTests

# Stage 2: Create the final image
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/vuttr-0.0.1-SNAPSHOT.jar .

# Environment variables
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/vuttrdb
ENV SPRING_DATASOURCE_USERNAME=vuttr
ENV SPRING_DATASOURCE_PASSWORD=vuttr123

EXPOSE 3000
ENTRYPOINT ["java", "-jar", "vuttr-0.0.1-SNAPSHOT.jar"]
