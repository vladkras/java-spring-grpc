package com.phillips.grpc;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        HelloResponse reply = HelloResponse.newBuilder()
                .setMessage(request.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}