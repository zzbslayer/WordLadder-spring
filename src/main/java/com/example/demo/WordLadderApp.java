package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages ="com.example.demo")
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
@EntityScan(basePackages = "com.example.demo.model")
public class WordLadderApp extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WordLadderApp.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WordLadderApp.class, args);
    }
}
