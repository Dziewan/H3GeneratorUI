package com.ddgroup.h3generatorui.controller;

import com.ddgroup.h3generatorui.service.HeroesApiService;
import lombok.RequiredArgsConstructor;
import model.api.Statistics;
import model.enumeration.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.HeroesService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ViewController {
    private final HeroesService heroesService;
    private final HeroesApiService heroesApiService;

    @GetMapping("/game")
    public String getGamePage(Model model) {
        List<Hero> heroes = heroesService.getHeroes();
        Statistics statistics = heroesApiService.getStatistics();
        model.addAttribute("statistics", statistics);
        model.addAttribute("heroes", heroes);
        return "game";
    }
}

