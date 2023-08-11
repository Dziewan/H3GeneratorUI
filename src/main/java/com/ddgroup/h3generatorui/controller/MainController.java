package com.ddgroup.h3generatorui.controller;

import org.springframework.ui.Model;

import java.util.Map;

public abstract class MainController {
    private static final String CONTENT_KEY = "content";

    protected static final String LAYOUT = "layout";

    abstract protected String contentName();

    protected void setContent(Model model) {
        model.addAttribute(CONTENT_KEY, contentName());
    }

    protected void addAttribute(Model model, String key, Object value) {
        model.addAttribute(key, value);
    }

    protected void addAttributes(Model model, Map<String, Object> attributes) {
        model.addAllAttributes(attributes);
    }
}
