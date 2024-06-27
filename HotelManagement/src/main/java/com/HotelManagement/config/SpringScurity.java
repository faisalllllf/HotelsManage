package com.HotelManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.HotelManagement.service.RoleService;


public class SpringScurity extends WebSecurityConfigurerAdapter {
	/*
	 * @Autowired private RoleService roleService;
	 * 
	 * @Autowired private UserDetailsService userDetailsService;
	 * 
	 * @Bean public static PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * 
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .antMatchers("/register/**").permitAll()
	 * .antMatchers("/index").permitAll().antMatchers("/images/**").permitAll()
	 * .antMatchers("/css/**").permitAll().antMatchers("/js/**").permitAll()
	 * .antMatchers("/fragments/**").permitAll()
	 * .antMatchers("/admin/**").hasRole("ADMIN")
	 * 
	 * .antMatchers("/user/**").hasRole("USER")
	 * .antMatchers("/admin/departments/**").hasRole(roleService.canAccess(
	 * SecurityContextHolder.getContext().getAuthentication()))
	 * //access("@roleService.canAccess(authentication)") // More antMatchers as
	 * needed, using SpEL for dynamic roles
	 * .anyRequest().authenticated().and().formLogin().loginPage("/login").
	 * loginProcessingUrl("/login")
	 * .successHandler(customSuccessHandler()).permitAll().and().logout().permitAll(
	 * ); }
	 * 
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception {
	 * auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()
	 * ); }
	 * 
	 * @Bean public AuthenticationSuccessHandler customSuccessHandler() { return new
	 * Customhandler(); }
	 * 
	 * 
	 */	
}