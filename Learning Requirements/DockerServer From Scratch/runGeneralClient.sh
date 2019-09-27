#!/usr/bin/env bash
#ls
#exit 0
#cd src/main/java
#pwd
#javac Network/ClientSide/GeneralClient.java
#java Network.ClientSide.GeneralClient
#echo "Success!"

###################################

cd src/main/java
docker build -t sbu-ai-challenge-client-image .
docker run -i --network host --rm --name $1 sbu-ai-challenge-client-image
echo "Ran!"