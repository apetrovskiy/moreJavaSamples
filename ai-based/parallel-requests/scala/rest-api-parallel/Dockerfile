FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/scala-3.3/rest-api-parallel.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]