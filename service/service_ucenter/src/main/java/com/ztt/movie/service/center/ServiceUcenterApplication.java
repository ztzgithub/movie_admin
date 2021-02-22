package com.ztt.movie.service.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.ztt.movie"})
@EnableDiscoveryClient
public class ServiceUcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceUcenterApplication.class, args);
	}
}