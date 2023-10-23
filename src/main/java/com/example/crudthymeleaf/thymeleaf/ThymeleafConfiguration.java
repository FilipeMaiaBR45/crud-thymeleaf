package com.example.crudthymeleaf.thymeleaf;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Configuration
public class ThymeleafConfiguration {
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
