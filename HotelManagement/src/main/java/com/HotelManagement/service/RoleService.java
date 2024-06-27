package com.HotelManagement.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	public String canAccess(Authentication authentication) {
		System.out.println("inside canacess");
		String result = "";
		Set<String> roles = authentication.getAuthorities().stream().map(r -> r.getAuthority())
				.collect(Collectors.toSet());
		if (!roles.isEmpty()) {
			for (String s : roles) {
				System.out.println("inside canacessroles" + s);
				result = s;
			}

		}

		// .stream()
		// .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(role));

		return result;
	}

}