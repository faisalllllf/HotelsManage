package com.Hrm.LoginMicroService.Entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column
	private String restToken;

	@Column
	private LocalDateTime tokenCreationTime;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") })
	private List<Role> roles = new ArrayList<>();

	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}
	public LocalDateTime getTokenCreationTime() {
		return tokenCreationTime;
	}

	public void setTokenCreationTime(LocalDateTime tokenCreationTime) {
		this.tokenCreationTime = tokenCreationTime;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
	public String getRestToken() {
		return restToken;
	}

	public void setRestToken(String restToken) {
		this.restToken = restToken;
	}

	public Employee(Long id, String username, String password, String restToken, LocalDateTime tokenCreationTime,
			List<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.restToken = restToken;
		this.tokenCreationTime = tokenCreationTime;
		this.roles = roles;

	}

	
}
