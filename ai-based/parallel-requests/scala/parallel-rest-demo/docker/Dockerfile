FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app
COPY . .
RUN ./sbt stage

EXPOSE 8080
CMD ["./target/universal/stage/bin/parallel-rest-demo"]