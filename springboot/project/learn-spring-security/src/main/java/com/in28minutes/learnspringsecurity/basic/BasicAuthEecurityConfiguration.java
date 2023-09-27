package com.in28minutes.learnspringsecurity.basic;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthEecurityConfiguration {
	
	@Bean
	@Order(SecurityProperties.BASIC_AUTH_ORDER)
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
					auth -> {auth.anyRequest().authenticated();
					});
		http.sessionManagement(
					session -> session.sessionCreationPolicy(
								SessionCreationPolicy.STATELESS)
					);
//		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		
		http.csrf(CsrfConfigurer::disable);
		http.headers(h -> h.frameOptions(FrameOptionsConfig::sameOrigin));
		return http.build();
	}
	
//	@Bean
//	public UserDetailsService userDetailService() {
//		
//		var user = User.withUsername("in28minutes")
//			.password("{noop}dummy")
//			.roles(UserRoles.USER.name())
//			.build();
//		
//		var admin = User.withUsername("admin")
//				.password("{noop}dummy")
//				.roles(UserRoles.ADMIN.name())
//				.build();
//		return new InMemoryUserDetailsManager(user, admin);
//	}
	
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
				.build();
	}
	
	@Bean
	public UserDetailsService userDetailService(DataSource dataSource) {
		
		var user = User.withUsername("in28minutes")
//			.password("{noop}dummy")
			.password("dummy")
			.passwordEncoder(str -> passwordEncoder().encode(str))
			.roles(UserRoles.USER.name())
			.build();
		
		var admin = User.withUsername("admin")
//				.password("{noop}dummy")
				.password("dummy")
				.passwordEncoder(str -> passwordEncoder().encode(str))
				.roles(UserRoles.ADMIN.name(), UserRoles.USER.name())
				.build();
		
		var jdbcUserDetailsManger = new JdbcUserDetailsManager(dataSource);
		jdbcUserDetailsManger.createUser(user);
		jdbcUserDetailsManger.createUser(admin);
		return jdbcUserDetailsManger;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

