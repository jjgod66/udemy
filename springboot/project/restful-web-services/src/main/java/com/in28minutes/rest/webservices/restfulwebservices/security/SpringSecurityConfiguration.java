package com.in28minutes.rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// 1. 모든 요청은 인증되어야한다
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		// 2. 인증이 안되면 웹페이지가 뜬다
		http.httpBasic(withDefaults());
		
		// 3. CSRF -> POST, PUT
		http.csrf().disable();
		
		return http.build();
	}
}
