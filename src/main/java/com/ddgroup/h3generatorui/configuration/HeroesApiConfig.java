package com.ddgroup.h3generatorui.configuration;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class HeroesApiConfig {
    private String baseUrl = "http://34.116.140.204:8080";
    private String statistics = "/history/statistics";
    private String history = "/history";
}
