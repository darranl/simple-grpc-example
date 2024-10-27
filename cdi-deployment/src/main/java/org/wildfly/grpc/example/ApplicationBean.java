package org.wildfly.grpc.example;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationBean {

    public ApplicationBean() {
        System.out.println("ApplicationBean.<init>");
        throw new RuntimeException("ApplicationBean.<init>");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("ApplicationBean.postConstruct");
    }

}
