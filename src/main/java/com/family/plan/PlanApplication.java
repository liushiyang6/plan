package com.family.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanApplication.class, args);
    }

}
