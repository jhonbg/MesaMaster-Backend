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
                        .allowedOrigins("https://mesa-master.vercel.app","http://localhost:3000","https://mesa-master-git-main-jhonbgs-projects.vercel.app","https://mesa-master-hkmm0ufya-jhonbgs-projects.vercel.app")
//                https://mesa-master-hkmm0ufya-jhonbgs-projects.vercel.app/
                        .allowedMethods("*") // Permitir todos los métodos
                        .allowCredentials(true)
                        .exposedHeaders("Authorization") // Exponer el encabezado de autorización
                        .maxAge(3600); // Tiempo máximo de caché para preflight
            }
        };
    }
}
