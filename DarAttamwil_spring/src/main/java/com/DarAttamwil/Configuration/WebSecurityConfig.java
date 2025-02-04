package com.DarAttamwil.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private UserDetailsService jwtUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	

	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.cors().and()
		.csrf().disable()
        
				.authorizeRequests().antMatchers("/api/authenticate").permitAll().and()
				.authorizeRequests().antMatchers("/api/login/**").permitAll().and()
				.authorizeRequests().antMatchers("/api/all/roles").permitAll().and()
				.authorizeRequests().antMatchers("/api/contact/contacts").permitAll().and()
				.authorizeRequests().antMatchers("/api/actualite/actualites").permitAll().and()
			    .authorizeRequests().antMatchers("/v2/api-docs","/configuration/ui","/swagger-resources/**","/configuration/security","/swagger-ui.html","/webjars/**").permitAll()
//			    .authorizeRequests().antMatchers("/api/admins").permitAll()
			    .antMatchers("/api/volunteers").hasAuthority("admin")
//			    .antMatchers("/produits/**").hasRole("ADMIN")
//			    .antMatchers("/save/**").hasAnyRole("ADMIN", "USER")
				.anyRequest().authenticated().and().
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}