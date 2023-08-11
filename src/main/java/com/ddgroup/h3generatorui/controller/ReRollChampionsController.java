package com.ddgroup.h3generatorui.controller;

import lombok.RequiredArgsConstructor;
import model.HeroPair;
import model.enumeration.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.HeroesService;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class ReRollChampionsController extends MainController {
    private static final String PLAYER_ONE_HERO_KEY = "playerOneHero";
    private static final String PLAYER_TWO_HERO_KEY = "playerTwoHero";
    private static final String HEROES_KEY = "heroes";

    private final HeroesService heroesService;

    @GetMapping("/re-roll-champions")
    public String reRollChampions(@RequestParam(required = false) String playerOneBannedHero,
                                 @RequestParam(required = false) String playerTwoBannedHero,
                                 Model model) {
        if (playerOneBannedHero != null && playerTwoBannedHero != null) {
            HeroPair heroPair = heroesService.reRollChampions(Hero.valueOf(playerOneBannedHero), Hero.valueOf(playerTwoBannedHero));
            addAttributes(model, Map.of(
                PLAYER_ONE_HERO_KEY, heroPair.michalHero().name(),
                PLAYER_TWO_HERO_KEY, heroPair.danielHero().name()));
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
        return "reRollChampionsContent";
    }
}
