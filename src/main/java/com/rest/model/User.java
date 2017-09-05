package com.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_tbl")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public User(long id) {
		super();
		this.id = id;
	}

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "mobile")
	private String phoneNo;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	private transient String confirmPassword;

	public User(String email, String phoneNo, String name, String password) {
		super();
		this.email = email;
		this.phoneNo = phoneNo;
		this.name = name;
		this.password = password;
	}

	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", phoneNo=" + phoneNo + ", name=" + name + ", password="
				+ password + "]";
	}

}
