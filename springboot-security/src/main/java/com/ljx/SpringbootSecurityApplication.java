package com.ljx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityApplication.class, args);
	}

}
