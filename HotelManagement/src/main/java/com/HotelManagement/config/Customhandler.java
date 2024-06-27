<<<<<<< HEAD
<<<<<<< HEAD
package com.HotelManagement.config;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class Customhandler implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String redirectURL = request.getContextPath();

		if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
			redirectURL = "/admin/home";

		} else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
			redirectURL = "/user/home";
			System.out.println("authetication princiapl user" + authentication.getPrincipal());
		} else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_STAFF"))) {
			redirectURL = "/departments/home";
			System.out.println("authetication princiapl user" + authentication.getPrincipal());
		} 
		response.sendRedirect(redirectURL);
	}

=======
package com.HotelManagement.config;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class Customhandler implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String redirectURL = request.getContextPath();

		if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
			redirectURL = "/admin/home";

		} else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
			redirectURL = "/user/home";
			System.out.println("authetication princiapl user" + authentication.getPrincipal());
		} else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_STAFF"))) {
			redirectURL = "/departments/home";
			System.out.println("authetication princiapl user" + authentication.getPrincipal());
		} 
		response.sendRedirect(redirectURL);
	}

>>>>>>> 26f4154 (lll)
=======
package com.HotelManagement.config;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class Customhandler implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String redirectURL = request.getContextPath();

		if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
			redirectURL = "/admin/home";

		} else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
			redirectURL = "/user/home";
			System.out.println("authetication princiapl user" + authentication.getPrincipal());
		} else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_STAFF"))) {
			redirectURL = "/departments/home";
			System.out.println("authetication princiapl user" + authentication.getPrincipal());
		} 
		response.sendRedirect(redirectURL);
	}

<<<<<<< HEAD
>>>>>>> 8e11644 (First Commit)
=======
>>>>>>> eadf201 (first)
>>>>>>> 26f4154 (lll)
}