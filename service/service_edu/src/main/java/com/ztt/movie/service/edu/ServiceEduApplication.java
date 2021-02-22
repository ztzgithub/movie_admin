package com.ztt.movie.service.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.ztt.movie"})
public class ServiceEduApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ServiceEduApplication.class, args);
    }
}