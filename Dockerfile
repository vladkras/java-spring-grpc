FROM openjdk:17-alpine AS build

COPY . /app

RUN apk add --update maven protobuf-dev gcompat

WORKDIR /app

RUN mvn clean package

FROM openjdk:17-alpine

COPY --from=build /app/target/grpc-0.0.1-SNAPSHOT-jar-with-dependencies.jar /opt/grpc.jar

EXPOSE 8080

CMD ["java", "-jar", "/opt/grpc.jar"]