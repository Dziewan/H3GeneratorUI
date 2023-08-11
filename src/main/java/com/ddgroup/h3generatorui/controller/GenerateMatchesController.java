package com.ddgroup.h3generatorui.controller;

import lombok.RequiredArgsConstructor;
import model.Match;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.HeroesService;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class GenerateMatchesController extends MainController {
    private static final String MATCHES_KEY = "matches";
    private static final String HIDDEN_KEY = "hidden";

    private final HeroesService heroesService;

    @GetMapping("/generate-matches")
    public String generateMatches(@RequestParam(required = false) Boolean generateContent, Model model) {
        if (generateContent == null) {
            addAttribute(model, HIDDEN_KEY, true);
        } else {
            List<Match> matches = heroesService.generateMatches();
            addAttributes(model, Map.of(
                MATCHES_KEY, matches,
                HIDDEN_KEY, false));
        }

        setContent(model);
        return LAYOUT;
    }

    @Override
    protected String contentName() {
        return "generateMatchesContent";
    }
}
