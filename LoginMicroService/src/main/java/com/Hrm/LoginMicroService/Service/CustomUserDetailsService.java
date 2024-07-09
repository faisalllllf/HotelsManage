package com.Hrm.LoginMicroService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hrm.LoginMicroService.Entity.Employee;
import com.Hrm.LoginMicroService.Entity.Role;
import com.Hrm.LoginMicroService.repo.UserRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = userRepository.findByUsername(username);
		// .orElseThrow(() -> new UsernameNotFoundException("User not found with
		// username: " + username));

		if (employee != null) {
			return new org.springframework.security.core.userdetails.User(employee.getUsername(),
					employee.getPassword(), mapRolesToAuthorities(employee.getRoles()));
		}
		return null;
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		Collection<? extends GrantedAuthority> mapRoles = roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return mapRoles;
	}
}
