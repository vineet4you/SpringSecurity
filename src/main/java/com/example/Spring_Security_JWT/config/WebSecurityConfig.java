package com.example.Spring_Security_JWT.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.Spring_Security_JWT.service.MyUserDetailsService;

@SpringBootConfiguration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	MyUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService);	
	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
	  
		http.authorizeRequests().antMatchers("/h2-console/**", "/test").permitAll().and()
			.authorizeRequests().antMatchers("/home**").hasAnyRole("ADMIN", "USER")
			.anyRequest().authenticated().and().formLogin();
		
		http.csrf().disable();
		
		http.headers().frameOptions().disable();
	}
	 
	@Bean
	public PasswordEncoder getPassowordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
