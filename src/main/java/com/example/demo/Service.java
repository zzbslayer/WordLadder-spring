package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@RestController
public class Service {
    protected final Logger log =LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value="/WordLadder")
    public String makeLadder(String w1, String w2) throws Exception{
        log.debug("Generating ladder between "+w1+" and "+w2+"\n");
        WordLadderApplication generator = new WordLadderApplication();
        String output = generator.CallStringLadderGenerate(w1,w2);
        log.debug(("Result:"+output+"\n"));
        return output;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Service.class, args);
    }
}
