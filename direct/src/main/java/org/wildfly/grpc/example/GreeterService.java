package org.wildfly.grpc.example;

import io.grpc.stub.StreamObserver;

import org.wildfly.extras.grpc.example.helloworld.GreeterGrpc;
import org.wildfly.extras.grpc.example.helloworld.HelloRequest;
import org.wildfly.extras.grpc.example.helloworld.HelloReply;

public class GreeterService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String name = request.getName();
        String message = "Hello " + name;

        responseObserver.onNext(HelloReply.newBuilder().setMessage(message).build());
        responseObserver.onCompleted();
    }

}
