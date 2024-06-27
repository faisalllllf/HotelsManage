package com.HotelManagement.config;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.HotelManagement.service.RoleService;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

	
	@Autowired
	private RoleService roleService;

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeHttpRequests((authorize) -> authorize.antMatchers("/register/**").permitAll()
						.antMatchers("/index").permitAll().antMatchers("/images/**").permitAll()
						.antMatchers("/css/**").permitAll().antMatchers("/js/**").permitAll()
						.antMatchers("/fragments/**").permitAll()
						.antMatchers("/admin/**").hasRole("ADMIN")
						
						.antMatchers("/user/**").hasRole("USER")
						.antMatchers("/departments/**").hasRole("STAFF")

)
				            
				.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
						.successHandler(customSuccessHandler()).permitAll())
				.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.invalidateHttpSession(true).permitAll()
					);

		return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public AuthenticationSuccessHandler customSuccessHandler() {
		return new Customhandler();
	}
	
	public String canAccess() {
		System.out.println("inside canacess");
		String result = "";
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		Set<String> roles = authentication.getAuthorities().stream().map(r -> r.getAuthority())
				.collect(Collectors.toSet());
		if (!roles.isEmpty()) {
			for (String s : roles) {
				System.out.println("inside canacessroles" + s);
				result = s;
			}

		}
		return result;

}
	
	
	
}
