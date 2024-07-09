package com.Hrm.LoginMicroService.EService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Hrm.LoginMicroService.Dto.AuthenticationRequest;
import com.Hrm.LoginMicroService.Dto.requestCreate;
import com.Hrm.LoginMicroService.Entity.Employee;

import com.Hrm.LoginMicroService.Entity.Role;
import com.Hrm.LoginMicroService.Exception.InvalidTokenException;
import com.Hrm.LoginMicroService.Exception.UserNotFoundException;

import com.Hrm.LoginMicroService.repo.RoleRepository;
import com.Hrm.LoginMicroService.repo.UserRepository;

@Service
public class EmpService {

	@Autowired
	private EmailService emailService;
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	public EmpService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public void saveEmployee(requestCreate requestcreate) {

		Employee employee = new Employee();
		employee.setUsername(requestcreate.getUsername());
		employee.setPassword(passwordEncoder.encode(requestcreate.getPassword()));
		employee.setRestToken(null);
		Role role = roleRepository.findByName(requestcreate.getRole());
		if (role == null) {
			System.out.println("As role is null ");
			role = checkRoleExist(requestcreate.getRole());
		}
		System.out.println("As role is not null ");
		employee.setRoles(Arrays.asList(role));
		userRepository.save(employee);
	}

	private Role checkRoleExist(String rolefromreq) {
		Role role = new Role();
		role.setName(rolefromreq);
		return roleRepository.save(role);
	}

	public void generatePasswordResetToken(String username) throws UserNotFoundException {
		Employee employee = userRepository.findByUsername(username);
		if (employee != null) {
			String token = UUID.randomUUID().toString();
			employee.setRestToken(token);
			employee.setTokenCreationTime(LocalDateTime.now()); // Store token creation time
			userRepository.save(employee);
			// Send email with reset token
			System.out.println("mail intialize for sending");
			emailService.sendPasswordResetEmail(employee.getUsername(), token);

		} else {
			throw new UserNotFoundException("User with email " + username + " not found");
		}
	}

	public void resetPassword(String token, String newPassword) throws InvalidTokenException {
		Employee employee = userRepository.findByRestToken(token);
		if (employee != null) {
			LocalDateTime tokenCreationTime = employee.getTokenCreationTime();
			long tokenValidityDurationInMinutes = 60; //minutes
			// Calculate token expiration time
			LocalDateTime tokenExpirationTime = tokenCreationTime.plus(tokenValidityDurationInMinutes,
					ChronoUnit.MINUTES);

			// Check if token is expired
			if (LocalDateTime.now().isBefore(tokenExpirationTime)) {
				employee.setPassword(passwordEncoder.encode(newPassword)); // Update password
				employee.setRestToken(null); // Clear token
				employee.setTokenCreationTime(null);
				userRepository.save(employee);
			} else {
				throw new InvalidTokenException("Invalid or expired token");
			}
		} else {
			throw new InvalidTokenException("Invalid or expired token");
		}
	}

}
