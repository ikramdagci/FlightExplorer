FROM maven:3.8.4-openjdk-17 AS dependency
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

FROM dependency AS build
COPY src src
RUN mvn package -DskipTests

FROM openjdk:17-oracle
COPY --from=build /app/target/flight-search-api-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
