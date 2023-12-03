package com.Authentication.Auth.Seguridad;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
////		.csrf(crsf -> crsf.disable())
//		.sessionManagement(sessionManager->sessionManager 
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//		.authorizeHttpRequests(authRequests -> {
//				authRequests.requestMatchers(HttpMethod.POST,"/auth/**").permitAll();
//		} );
//		
//		return http.build();

		return http
		.csrf(crsf -> crsf.disable())
		.cors(withDefaults())
		.authorizeHttpRequests(auth -> auth
		.requestMatchers(HttpMethod.POST,"/auth/**").permitAll())
		.build();

	}

//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
////		configuration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:5500"));
//		configuration.setAllowedMethods(Arrays.asList("POST"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**",configuration);
//		return source;
//	}
}
