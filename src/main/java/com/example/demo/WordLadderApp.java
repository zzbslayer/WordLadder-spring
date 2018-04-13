package com.example.demo;

import com.example.demo.service.WordLadderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class WordLadderApp {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(WordLadderApp.class, args);
    }
}
