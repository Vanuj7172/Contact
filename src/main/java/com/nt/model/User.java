package com.nt.model;

public class User {
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", loginname=" + loginname + ", password=" + password + ", role=" + role + ", looginStatus="
				+ looginStatus + "]";
	}

	private Integer userId;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String loginname;
	private String password;
	private Integer role;
	private Integer looginStatus;
	
	public User() {}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getLooginStatus() {
		return looginStatus;
	}

	public void setLooginStatus(Integer looginStatus) {
		this.looginStatus = looginStatus;
	}
	
	

}
