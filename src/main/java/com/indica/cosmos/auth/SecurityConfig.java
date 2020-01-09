package com.indica.cosmos.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired AuthProvider authProvider;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/").access("hasRole('ADMIN')")
				.antMatchers("/**").permitAll()
			.and()
			.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error=true")
				.usernameParameter("ID")
	            .passwordParameter("PW")
	        .and()
	            .authenticationProvider(authProvider);
	}
}
