FROM openjdk:11

COPY . /app

RUN apt-get update && apt-get install -y \
    maven \
    protobuf-compiler \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]