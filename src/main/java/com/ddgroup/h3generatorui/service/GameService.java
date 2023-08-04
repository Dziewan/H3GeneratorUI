package com.ddgroup.h3generatorui.service;

import model.HeroDetails;
import model.HeroPair;
import model.Match;
import model.enumeration.Hero;
import model.enumeration.Skill;
import org.springframework.stereotype.Service;
import service.HeroesService;

import java.util.List;

@Service
public class GameService {
    private final HeroesService heroesService;

    public GameService(HeroesService heroesService) {
        this.heroesService = heroesService;
    }


    public List<Match> generateMatches() {
        return heroesService.generateMatches();
    }

    public Hero reRollChampion(Hero bannedChampion) {
        return heroesService.reRollChampion(bannedChampion);
    }

    public HeroPair reRollChampions(Hero michalBannedChampion, Hero danielBannedChampion) {
        return heroesService.reRollChampions(michalBannedChampion, danielBannedChampion);
    }

    public HeroDetails getHeroDetails(Hero hero) {
        return heroesService.getHeroDetails(hero);
    }

    public List<Hero> getHeroes() {
        return heroesService.getHeroes();
    }

    public List<Skill> getSkills() {
        return heroesService.getSkills();
    }
}
