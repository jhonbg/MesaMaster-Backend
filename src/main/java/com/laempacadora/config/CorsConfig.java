package com.laempacadora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("*") // Permitir todos los métodos
                        .allowCredentials(true)
                        .exposedHeaders("Authorization") // Exponer el encabezado de autorización
                        .maxAge(3600); // Tiempo máximo de caché para preflight
            }
        };
    }
}
