#!/usr/bin/env bash
./gradlew clean install
sudo mkdir -p /usr/local/ahimsa/
sudo cp build/libs/ahimsa-lang-1.0.jar /usr/local/ahimsa/
sudo touch /usr/local/bin/ahimsa
echo 'java -jar /usr/local/ahimsa/ahimsa-lang-1.0.jar "$@"' | sudo tee /usr/local/bin/ahimsa > /dev/null
sudo chmod +x /usr/local/bin/ahimsa