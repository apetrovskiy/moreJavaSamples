# Stage 1: Build
FROM openjdk:17-jdk-slim AS build

WORKDIR /app

COPY . .

RUN sbt assembly

# Stage 2: Runtime
FROM openjdk:17-jre-slim

WORKDIR /app

COPY --from=build /app/target/scala-3.3/rest-api-parallel.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]