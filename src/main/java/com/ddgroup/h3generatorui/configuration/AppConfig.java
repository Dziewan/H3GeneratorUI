package com.ddgroup.h3generatorui.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import factory.HeroesServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;
import service.HeroesService;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    private final HeroesApiConfig heroesApiConfig;

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new RootUriTemplateHandler(heroesApiConfig.getBaseUrl()));
        return restTemplate;
    }

    @Bean
    public HeroesService heroesService() {
        return HeroesServiceFactory.newInstance();
    }
}
