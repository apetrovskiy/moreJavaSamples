# Stage 1: Build
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app
COPY . .
RUN ./gradlew shadowJar

# Stage 2: Run
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/build/libs/rest-api-demo-0.1.0-all.jar ./app.jar
CMD ["java", "-jar", "app.jar"]