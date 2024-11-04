package com.pg.llm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class MovieKafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieKafkaApplication.class, args);
    }
}
