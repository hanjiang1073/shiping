package com.ceam.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9999 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9999.class,args);
    }
}

