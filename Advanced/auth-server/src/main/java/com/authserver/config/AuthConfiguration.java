package com.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.authserver.repository.UserRepository;


@Configuration
@EnableWebSecurity
public class AuthConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserRepository repo;
	@Autowired 
	UserDetailsService userDetailsService;

	// Authentication 
		// Creating in-memory users with roles

//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//
//        auth.inMemoryAuthentication()
//        .withUser("sidhu")
//        .password("password123")
//        .roles("ADMIN")
//        .and()
//        .withUser("alphons")
//        .password("alphons123")
//        .roles("USER");
//
//        
	
	
//
//    }
	
	// Authentication 
		// Creating users from database
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService);
		
	}

	// Authorization
		// Role based API Level

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().
			authorizeHttpRequests()
			.antMatchers("/admin/**")
			.hasRole("ADMIN")
			.antMatchers("/user/**")
			.hasAnyRole("USER","ADMIN")
//			.antMatchers("/**")
//			.permitAll()
			.antMatchers(HttpMethod.POST,"/**")
			.permitAll()
//			.and()
//			.formLogin() // to add a default login form
			.and()
			.httpBasic();
			
	}

	
	
	@Bean

    PasswordEncoder passwordEncoder() {

        return  NoOpPasswordEncoder.getInstance();

    }
	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception {
		return super.authenticationManager();
	}

	
	

}
