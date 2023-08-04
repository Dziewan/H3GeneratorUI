package com.ddgroup.h3generatorui.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import factory.HeroesServiceFactory;
import service.HeroesService;

@Configuration
public class HeroesServiceConfig {

    @Bean
    public HeroesService heroesService() {
        return HeroesServiceFactory.newInstance();
    }
}
