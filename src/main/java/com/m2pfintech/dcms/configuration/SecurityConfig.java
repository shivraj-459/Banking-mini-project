package com.m2pfintech.dcms.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain dcmsSecurityConfig(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(auth ->{
			auth.requestMatchers(HttpMethod.POST,"/registerCustomer","/addBank").permitAll()
			.requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
			.requestMatchers(HttpMethod.GET, "/banks").hasRole("ADMIN")
			.requestMatchers(HttpMethod.DELETE,"/customers").hasRole("ADMIN")
			.requestMatchers(HttpMethod.GET,"/customers").hasRole("ADMIN")
			.requestMatchers(HttpMethod.GET,"/customers/**").hasAnyRole("USER","ADMIN")
			.requestMatchers(HttpMethod.PATCH,"/customers/**").hasAnyRole("USER","ADMIN")
			.anyRequest().authenticated();	
		}).csrf(csrf -> csrf.disable())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {		
		return new BCryptPasswordEncoder();
	}
	
}
