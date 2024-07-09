package com.Hrm.LoginMicroService.contoller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hrm.LoginMicroService.Dto.AuthenticationRequest;
import com.Hrm.LoginMicroService.Dto.AuthenticationResponse;
import com.Hrm.LoginMicroService.Dto.requestCreate;
import com.Hrm.LoginMicroService.EService.EmpService;
import com.Hrm.LoginMicroService.Entity.Employee;
import com.Hrm.LoginMicroService.Exception.InvalidTokenException;
import com.Hrm.LoginMicroService.Exception.UserNotFoundException;
import com.Hrm.LoginMicroService.Service.CustomUserDetailsService;
import com.Hrm.LoginMicroService.Service.JwtUtil;
import com.Hrm.LoginMicroService.repo.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private EmpService empservice;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@GetMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		System.out.println("IN login validate ");
		System.out.println("authenticationRequest" + authenticationRequest);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		System.out.println("testing");
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		System.out.println("fetch username completed");
		final String token = jwtUtil.generateToken(userDetails);
		System.out.println("token" + token);
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}

	@PostMapping("/register")
	public ResponseEntity<String> createEMployee(@RequestBody requestCreate requestcreate) throws Exception {
		System.out.println("IN login validate ");
		System.out.println("requestcreate" + requestcreate);
		try {
			System.out.println("stroing in dbs");
			empservice.saveEmployee(requestcreate);

			// userRepository.save(employee);
		} catch (Exception e) {
			throw new Exception("Incorrect username or password", e);
		}
		System.out.println("testing");

		return ResponseEntity.ok("sucesfull");
	}

	@PostMapping("/forgot-password")
	public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> payload) {
		String email = payload.get("email");
		try {
			System.out.println("genrating resettoken");
			empservice.generatePasswordResetToken(email);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" resettoken  sucessfull and sent to email ");
		return ResponseEntity.ok("Password reset instructions sent to " + email);
	}

	@PostMapping("/reset-password")
	public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> payload) {
		/*
		 * 
		 * 
		 * {
    "token": "87f69d96-658e-4e1e-a4b7-799944cd2b33",
    "newPassword":12345
}
		 */
		String token = payload.get("token");
		String newPassword = payload.get("newPassword");
		try {
			empservice.resetPassword(token, newPassword);
		} catch (InvalidTokenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok("Password reset successfully");
	}
}
