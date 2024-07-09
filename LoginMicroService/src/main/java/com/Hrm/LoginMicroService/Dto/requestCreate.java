package com.Hrm.LoginMicroService.Dto;

public class requestCreate {

	private String username;
	private String password;
	private String role;

	@Override
	public String toString() {
		return "requestCreate [username=" + username + ", password=" + password + ", role=" + role + "]";
	}

	public String getUsername() {
		return username;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
