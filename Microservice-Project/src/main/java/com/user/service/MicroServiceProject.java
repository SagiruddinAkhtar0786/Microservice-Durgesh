package com.user.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MicroServiceProject {

	public static void main(String[] args) {
		
		/*
		 * @Bean public RestTemplate restTemplate() { return new RestTemplate(); }
		 */
		
		SpringApplication.run(MicroServiceProject.class, args);
	}

}
