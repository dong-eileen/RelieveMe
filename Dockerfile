FROM openjdk:8-jdk-alpine
MAINTAINER Kathleen Burkhardt, Michelle Hu, Eileen Dong, Rachel Rabideau
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/relieveme-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} relieveme.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/relieveme.jar"]
