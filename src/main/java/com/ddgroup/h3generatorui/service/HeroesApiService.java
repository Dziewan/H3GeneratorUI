package com.ddgroup.h3generatorui.service;

import lombok.RequiredArgsConstructor;
import model.api.Statistics;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class HeroesApiService {
    private final RestTemplate restTemplate;

    public Statistics getStatistics() {
        return restTemplate.getForObject("/history/statistics", Statistics.class);
    }
}
