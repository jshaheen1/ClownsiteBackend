package com.quinnox.training.clowns.userspef;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RegisterDTO {
	
	public String username;
	
	@JsonIgnore
	public String password;
	public Role role;
	
	
	public RegisterDTO(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RegisterDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.role = Role.USER;
	}
	
	public RegisterDTO() {
		
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
	
	public Users conversion() {
		Users user = new Users(this.username, this.password, this.role);
		return user;
	}
	
	
}
