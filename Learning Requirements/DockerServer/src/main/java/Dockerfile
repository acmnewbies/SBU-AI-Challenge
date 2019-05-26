FROM openjdk:8

COPY . /usr/src/javaclient
WORKDIR /usr/src/javaclient
COPY NetworkStuff/ClientSide/ /usr/src/javaclient
RUN javac NetworkStuff/ClientSide/GeneralClient.java

#RUN cd java
CMD [ "java", "NetworkStuff.ClientSide.GeneralClient" ]
#CMD [ "ls" ]
