package org.wildfly.grpc.example;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import org.wildfly.extras.grpc.example.helloworld.GreeterGrpc;
import org.wildfly.extras.grpc.example.helloworld.HelloRequest;
import org.wildfly.extras.grpc.example.helloworld.HelloReply;

public class GrpcClient {

    public static void main(String[] args) throws Exception{
        System.out.println("Let's do some gRPC stuff.");

        String target = "localhost:9555";
        String name = "who are you?";

        // Set up non TLS channel.
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();

        try {
            HelloRequest request = HelloRequest.newBuilder().setName(name).build();

            GreeterGrpc.GreeterBlockingStub blockingStub = GreeterGrpc.newBlockingStub(channel);

            HelloReply response = blockingStub.sayHello(request);

            System.out.println("Greeting: " + response.getMessage());
        } finally {
            // Be good and tidy up.
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

}
