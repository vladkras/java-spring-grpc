## Docker

```
docker build -t java-spring-grpc .
docker run --rm -it -p 8080:8080 java-spring-grpc
```

### grpcurl
```
./grpcurl -plaintext -d '{"message":"test"}' -proto src/main/proto/EchoService.proto 192.168.0.13:8080 com.phillips.grpc.HelloService/hello
```

