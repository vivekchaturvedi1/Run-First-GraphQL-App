package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@Profile("local")
public class LocalCorsConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(LocalCorsConfiguration.class);

    @Bean
    public CorsFilter corsFilter() {
        logger.info("{}#corsFilter() is called!", this.getClass().getSimpleName());
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:9000");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        // Apply the configuration to all paths
        source.registerCorsConfiguration("/**", config);
//        source.registerCorsConfiguration("/graphql", config);
//        source.registerCorsConfiguration("/graphql/**", config);
        return new CorsFilter(source);
    }
}