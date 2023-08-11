package com.ddgroup.h3generatorui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LayoutController {

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("content", "placeholder");
        return "layout";
    }
}
