package com.example.hystrixturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class HystrixturbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixturbineApplication.class, args);
    }

}
