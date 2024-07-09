package com.Hrm.LoginMicroService.Entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "tokens")
public class TokenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String token;
	private Date expiryDate;

	public TokenEntity() {
		// Default constructor required by JPA
	}

	public TokenEntity(String username, String token, Date expiryDate) {
		this.username = username;
		this.token = token;
		this.expiryDate = expiryDate;
	}

	// Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
}
