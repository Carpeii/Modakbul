package com.example.modakbul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ModakbulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModakbulApplication.class, args);
    }

}
