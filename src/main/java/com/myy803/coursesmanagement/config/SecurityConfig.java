package com.myy803.coursesmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// password "marjol123" is externally encrypted to the following
		UserDetails user1 = User.withUsername("mariol")
			     .password("$2a$12$.1RcD14KeIMKz3kZfJlQ2uRlYpXxFofi6bazdKSjjJfRMRltmURxC")
			     .roles("TEACHER")
			     .build();
		
		// password "miltiadis123" is externally encrypted to the following
		UserDetails user2 = User.withUsername("miltiadis")
			     .password("$2a$12$YaXZ9VSHsG9nnFFFK4A3ZuipinTLlV7owgyHT5q/mmAlx3T4OOdNu")
			     .roles("TEACHER")
			     .build();
		
		// password "argyris123" is externally encrypted to the following
		UserDetails user3 = User.withUsername("argyris")
			     .password("$2a$12$rQT0vQY4twrgBzQ88AyjNOmbxwWwmgLCAP5AkwvCEamPW2j1VL4e2")
			     .roles("TEACHER")
			     .build();
		
		// password "admin" is externally encrypted to the following
		UserDetails user4 = User.withUsername("admin")
			     .password("$2a$12$kBACpLy8I/hvgXaJ7UXWVOd5gcaGc/b0mTyBwZQpjlu15imeYiBxm")
			     .roles("TEACHER", "ADMIN")
			     .build();
		
		auth.inMemoryAuthentication().withUser(user1).withUser(user2).withUser(user3).withUser(user4);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
