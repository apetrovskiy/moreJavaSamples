#!/bin/bash
# Install JDK, Scala, Docker, Docker Compose
sudo apt-get update
sudo apt-get install -y openjdk-17-jdk scala docker.io docker-compose

# Build and run the project
./gradlew build
docker-compose up --build