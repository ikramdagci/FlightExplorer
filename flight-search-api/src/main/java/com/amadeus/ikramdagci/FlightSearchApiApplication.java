package com.amadeus.ikramdagci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FlightSearchApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightSearchApiApplication.class, args);
    }

}
