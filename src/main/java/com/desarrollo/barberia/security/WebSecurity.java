package com.desarrollo.barberia.security;

import java.util.Arrays;
import java.util.List;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.core.env.Environment;


@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	private Environment env;
	private UserDetailsService userDetailsService;

	public WebSecurity(Environment env, UserDetailsService userDetailsService) {
		this.env = env;
		this.userDetailsService = userDetailsService;
	}

 protected void configure (HttpSecurity httpSecurity)throws Exception{
	 httpSecurity.headers().frameOptions().disable().and()
	 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	 .cors().and()
	 .csrf().disable()
	 .authorizeRequests().antMatchers(HttpMethod.POST).permitAll().antMatchers(HttpMethod.PUT).permitAll();
	 
 }
 
 
 private List<String> getListProperty(String key){
		return Arrays.asList(env.getProperty(key).split(","));
	}
	
	private Boolean getBooleanProperty(String key){
		return Boolean.valueOf(env.getProperty(key));
	}
	
	private Long getLongProperty(String key){
		return Long.valueOf(env.getProperty(key));
	}

}
