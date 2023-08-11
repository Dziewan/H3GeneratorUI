package com.ddgroup.h3generatorui.controller;

import lombok.RequiredArgsConstructor;
import model.HeroDetails;
import model.enumeration.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.HeroesService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChampionDetailsController extends MainController {
    private static final String SELECTED_HERO_KEY = "selectedHero";
    private static final String HEROES_KEY = "heroes";

    private final HeroesService heroesService;

    @GetMapping("/champion-details")
    public String championDetails(@RequestParam(required = false) String selectedHero, Model model) {
        if (selectedHero != null) {
            HeroDetails details = heroesService.getHeroDetails(Hero.valueOf(selectedHero));
            addAttribute(model, SELECTED_HERO_KEY, details.hero().name());
        }

        List<String> heroesNames = getHeroesNames();
        addAttribute(model, HEROES_KEY, heroesNames);

        setContent(model);
        return LAYOUT;
    }

    private List<String> getHeroesNames() {
        return heroesService.getHeroes()
            .stream()
            .map(Hero::name)
            .toList();
    }

    @Override
    protected String contentName() {
        return "championDetailsContent";
    }
}
