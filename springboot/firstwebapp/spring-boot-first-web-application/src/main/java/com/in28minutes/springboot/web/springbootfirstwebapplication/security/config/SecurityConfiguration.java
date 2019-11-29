package com.in28minutes.springboot.web.springbootfirstwebapplication.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("USER","ADMIN");
		auth.inMemoryAuthentication().withUser("dv").password("{noop}dv").roles("USER","ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http ) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/","/*todo*/**").access("hasRole('USER')").and().formLogin();
	}
}
