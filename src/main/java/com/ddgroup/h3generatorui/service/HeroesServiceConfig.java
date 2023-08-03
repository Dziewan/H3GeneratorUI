package com.ddgroup.h3generatorui.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.HeroesService;
import service.HeroesServiceImpl;

@Configuration
public class HeroesServiceConfig {

    @Bean
    public HeroesService heroesService() {
        return new HeroesServiceImpl();
    }
}
