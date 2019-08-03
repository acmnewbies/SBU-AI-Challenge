FROM openjdk:8

COPY . /usr/src/AIChallengeDockerServer
WORKDIR /usr/src/AIChallengeDockerServer

RUN javac Network/ClientSide/GeneralClient.java
RUN apt-get update && apt-get -y install g++ && rm -rf /var/lib/apt/lists/*

CMD [ "java", "Network.ClientSide.GeneralClient" ]

