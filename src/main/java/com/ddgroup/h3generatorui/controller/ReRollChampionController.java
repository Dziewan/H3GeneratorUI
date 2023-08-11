package com.ddgroup.h3generatorui.controller;

import lombok.RequiredArgsConstructor;
import model.enumeration.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.HeroesService;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class ReRollChampionController extends MainController {
    private static final String HERO_KEY = "hero";
    private static final String HEROES_KEY = "heroes";

    private final HeroesService heroesService;

    @GetMapping("/re-roll-champion")
    public String reRollChampion(@RequestParam(required = false) String bannedHero, Model model) {
        if (bannedHero != null) {
            Hero hero = heroesService.reRollChampion(Hero.valueOf(bannedHero));
            addAttribute(model, HERO_KEY, hero.name());
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
        return "reRollChampionContent";
    }
}
