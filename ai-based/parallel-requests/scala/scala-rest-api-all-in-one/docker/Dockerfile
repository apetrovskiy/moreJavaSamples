FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app
COPY . .
RUN ./sbt stage

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/universal/stage .
EXPOSE 8080
CMD ["bin/scala-rest-api"]