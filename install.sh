#!/usr/bin/env bash
./gradlew clean install
sudo mkdir -p /usr/local/ahimsa/
sudo cp build/libs/ahimsa-lang-1.0.jar /usr/local/ahimsa/
sudo touch /usr/local/bin/ahimsa
sudo echo 'java -jar /usr/local/ahimsa/ahimsa-lang-1.0.jar "$@"' > /usr/local/bin/ahimsa
sudo chmod +x /usr/local/bin/ahimsa