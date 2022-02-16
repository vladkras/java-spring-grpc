package com.phillips.grpc;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(8080)
        .addService(new HelloServiceImpl()).build();

		System.out.println("Starting server on port 8080");
		server.start();
		System.out.println("Server started on port 8080");

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("server is shutting down!");
            server.shutdown();
        }));

		server.awaitTermination();
	}

}
