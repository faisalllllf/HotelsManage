package com.Hrm.LoginMicroService.Config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.Hrm.LoginMicroService.Exception.CustomAuthenticationException;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// Implement your custom authentication logic here
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		// Example logic (replace with your actual authentication mechanism)
		if ("user".equals(username) && "password".equals(password)) {
			// Return authenticated token or details
			return authentication; // You may return a fully authenticated Authentication object
		} else {
			// Throw AuthenticationException if authentication fails
			throw new CustomAuthenticationException("Authentication failed");
		}
	}
}
