package com.ddgroup.h3generatorui.controller;

import model.enumeration.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.HeroesService;

import java.util.List;

@Controller
public class ViewController {

    private HeroesService heroesService;

    @Autowired
    public ViewController(HeroesService heroesService) {
        this.heroesService = heroesService;
    }

    @GetMapping("/game")
    public String getGamePage(Model model) {
        List<Hero> heroes = heroesService.getHeroes();
        model.addAttribute("heroes", heroes);
        return "game";
    }
}

