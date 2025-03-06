#!/bin/bash

# Install Java
sudo apt update
sudo apt install -y default-jdk

# Install Scala
wget https://downloads.lightbend.com/scala/3.3.0/scala-3.3.0.deb
sudo dpkg -i scala-3.3.0.deb
rm scala-3.3.0.deb

# Install Docker
sudo apt install -y docker.io
sudo systemctl start docker
sudo systemctl enable docker

# Install sbt
echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | sudo tee /etc/apt/sources.list.d/sbt.list
curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo apt-key add -
sudo apt update
sudo apt install -y sbt

# Install Gradle
sudo apt install -y gradle

# Install Maven
sudo apt install -y maven