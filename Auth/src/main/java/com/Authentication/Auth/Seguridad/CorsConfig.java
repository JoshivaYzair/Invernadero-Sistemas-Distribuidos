package com.Authentication.Auth.Seguridad;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/notificaciones/**")
//		.allowedOrigins("http://localhost:5500")
//		.allowedMethods("GET", "POST", "PUT", "DELETE")
//		.allowedHeaders("*")
//		.allowCredentials(true);
		registry.addMapping("/**").allowedMethods("*");
	}
}
