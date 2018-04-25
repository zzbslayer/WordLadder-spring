package com.example.demo.controller;

import com.example.demo.service.WordLadderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WordLadderController {
    @Autowired
    WordLadderService wordLadderService;

    @RequestMapping(value="/WordLadder/{str}")
    @ResponseBody
    public String makeLadder(@PathVariable String str) {

        return wordLadderService.wordLadder(str);
    }
}
