package com.example.demo.controller;

import com.example.demo.service.internal.WordLadderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WordLadderController {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value="/WordLadder/{str}")
    @ResponseBody
    public String makeLadder(@PathVariable String str) {
        WordLadderImpl wordLadder = new WordLadderImpl();
        String[] temp =  str.split("&");
        String w1 = temp[0];
        String w2 = temp[1];
        log.debug("Generating ladder between "+w1+" and "+w2+"\n");
        String output = wordLadder.CallStringLadderGenerate(w1,w2);
        log.debug(("Result:"+output+"\n"));
        return output;
    }
}
