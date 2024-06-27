package com.HotelManagement.dto;

public class UsersAd {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private String category;

	private String newRoleByAdmin;

	public UsersAd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersAd(Long id, String firstName, String lastName, String email, String password, String category,
			String newRoleByAdmin) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.category = category;
		this.newRoleByAdmin = newRoleByAdmin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "UsersAd [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", category=" + category + ", newRoleByAdmin=" + newRoleByAdmin + "]";
	}

	public String getNewRoleByAdmin() {
		return newRoleByAdmin;
	}

	public void setNewRoleByAdmin(String newRoleByAdmin) {
		this.newRoleByAdmin = newRoleByAdmin;
	}

}
