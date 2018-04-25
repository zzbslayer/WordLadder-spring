package com.example.demo.service;

import com.example.demo.service.internal.WordLadderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WordLadderService {
    private WordLadderImpl wordLadder = new WordLadderImpl();
    protected final Logger log = LoggerFactory.getLogger(this.getClass());


    public String wordLadder(String str){
        String[] temp =  str.split("&");
        String w1 = temp[0];
        String w2 = temp[1];
        log.debug("Generating ladder between "+w1+" and "+w2+"\n");
        String output = wordLadder.CallStringLadderGenerate(w1,w2);
        log.debug(("Result:"+output+"\n"));
        return output;
    }
}
