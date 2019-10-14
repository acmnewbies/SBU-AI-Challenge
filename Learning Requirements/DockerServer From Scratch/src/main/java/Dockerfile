FROM openjdk:8

COPY . /usr/src/AIChallengeDockerServer
WORKDIR /usr/src/AIChallengeDockerServer

# RUN cd src/main/java/
# RUN ls

RUN javac Network/ClientSide/GeneralClient.java
RUN apt-get update && apt-get -y install g++ python3 && rm -rf /var/lib/apt/lists/*

CMD [ "java", "Network.ClientSide.GeneralClient" ]

