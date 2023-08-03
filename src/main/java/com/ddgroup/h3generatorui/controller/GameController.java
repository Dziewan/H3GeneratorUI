package com.ddgroup.h3generatorui.controller;

import com.ddgroup.h3generatorui.service.GameService;
import model.HeroDetails;
import model.HeroPair;
import model.Match;
import model.enumeration.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/matches")
    public List<Match> generateMatches() {
        return gameService.generateMatches();
    }

    @PostMapping("/reroll-champion")
    public Hero reRollChampion(@RequestBody Hero bannedChampion) {
        return gameService.reRollChampion(bannedChampion);
    }

    @PostMapping("/reroll-champions")
    public HeroPair reRollChampions(@RequestBody HeroPair heroes) {
        return gameService.reRollChampions(heroes.michalHero(), heroes.michalHero());
    }

    @GetMapping("/hero-details/{hero}")
    public HeroDetails getHeroDetails(@PathVariable Hero hero) {
        return gameService.getHeroDetails(hero);
    }
}
