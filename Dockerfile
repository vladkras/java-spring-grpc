FROM openjdk:17-alpine

COPY . /app

RUN apk add --update maven protobuf-dev gcompat

WORKDIR /app

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]