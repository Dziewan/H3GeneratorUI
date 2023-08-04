package com.ddgroup.h3generatorui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ViewController {

    @GetMapping("/game")
    public String getGamePage() {
        return "game";
    }

    @GetMapping("/matches")
    public String getMatchesPage() {
        return "matches";
    }
}

