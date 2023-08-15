package com.ipl.betUsa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BetUsaSecurityConfiguration {
	
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
		
		System.out.println("Requested recevied");
		http.csrf((csrf) -> csrf.disable()); 
		
		http.authorizeHttpRequests(authz -> authz
				.requestMatchers("/ipl/**")
				.hasRole("USER")
				.anyRequest()
				.permitAll()
				
				).httpBasic(Customizer.withDefaults());
		
		
		http.headers(h -> h.frameOptions(f->f.disable()));
		
		
		return http.build();
        }

}
