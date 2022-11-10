package com.hiberus.practicaExtra2.prendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PrendasApplication {
    public static void main(final String[] args){
        SpringApplication.run(PrendasApplication.class);
    }

}
