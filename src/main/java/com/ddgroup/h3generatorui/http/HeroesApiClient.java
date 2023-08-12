package com.ddgroup.h3generatorui.http;

import com.ddgroup.h3generatorui.configuration.HeroesApiConfig;
import lombok.RequiredArgsConstructor;
import model.api.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
@RequiredArgsConstructor
public class HeroesApiClient {
    private final RestTemplate restTemplate;
    private final HeroesApiConfig config;

    public Statistics getStatistics() {
        return restTemplate.getForObject(config.getStatistics(), Statistics.class);
    }

    public List<Match> getMatchHistory() {
        return Optional.ofNullable(restTemplate.getForObject(config.getHistory(), Match[].class))
            .map(matches -> Arrays.stream(matches).toList())
            .orElse(Collections.emptyList());
    }
}
