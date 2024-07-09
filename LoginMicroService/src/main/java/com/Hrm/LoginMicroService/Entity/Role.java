package com.Hrm.LoginMicroService.Entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	@ManyToMany(mappedBy = "roles")
	private List<Employee> roles;

	public Role(Long id, String name, List<Employee> roles) {
		super();
		this.id = id;
		this.name = name;
		this.roles = roles;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getRoles() {
		return roles;
	}

	public void setUsers(List<Employee> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", roles=" + roles + "]";
	}

}
