package com.ddgroup.h3generatorui.controller;

import com.ddgroup.h3generatorui.http.HeroesApiClient;
import lombok.RequiredArgsConstructor;
import model.api.Match;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class MatchHistoryController extends MainController {
    private static final String MATCH_HISTORY_KEY = "matchHistory";

    private final HeroesApiClient heroesApiClient;

    @GetMapping("/match-history")
    public String matchHistory(Model model) {
        List<Match> matchHistory = new ArrayList<>(heroesApiClient.getMatchHistory());
        Collections.reverse(matchHistory);
        addAttribute(model, MATCH_HISTORY_KEY, matchHistory);

        setContent(model);
        return LAYOUT;
    }

    @Override
    protected String contentName() {
        return "matchHistoryContent";
    }
}
