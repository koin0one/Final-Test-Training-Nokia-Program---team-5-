FROM openjdk:17-alpine

ARG JAR_FILE

RUN apk update && \
    apk add mysql mysql-client

RUN mkdir /deploy
WORKDIR /deploy

COPY hotel-booking/target/hotelbooking-0.0.1-SNAPSHOT.jar .

#ENTRYPOINT java -jar /deploy/hotelbooking-0.0.1-SNAPSHOT.jar