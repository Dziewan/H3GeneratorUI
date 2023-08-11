package com.ddgroup.h3generatorui.controller;

import com.ddgroup.h3generatorui.service.HeroesApiService;
import lombok.RequiredArgsConstructor;
import model.api.Statistics;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class StatisticsController extends MainController {
    private static final String STATISTICS_KEY = "statistics";
    private final HeroesApiService heroesApiService;

    @GetMapping("/statistics")
    public String statistics(Model model) {
        Statistics statistics = heroesApiService.getStatistics();
        addAttribute(model, STATISTICS_KEY, statistics);

        setContent(model);
        return LAYOUT;
    }

    @Override
    protected String contentName() {
        return "statisticsContent";
    }
}

