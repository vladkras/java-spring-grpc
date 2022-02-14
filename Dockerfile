FROM openjdk:alpine

COPY . /app

RUN apt update && apt install maven protobuf-compiler

WORKDIR /app

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]