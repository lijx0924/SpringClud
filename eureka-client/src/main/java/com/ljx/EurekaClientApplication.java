package com.ljx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "SpringCloud") String name) {
        String service = "Services:" + discoveryClient.getServices();
        System.out.println(service);
        return "hi " + name + " ,i am from port:" + port + "SERVICE:" + service;
    }

}
