package com.incometax.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 
 *
 */
@Configuration
@EnableWebMvc
public class CorsConfiguration {

	private static final String ALLOWED_ORIGINS = "*";

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {				
				registry.addMapping("/auth/**").allowedOrigins(ALLOWED_ORIGINS).allowedMethods("GET", "POST")
						.allowCredentials(false).maxAge(3600);
			}
		};
	}

}
