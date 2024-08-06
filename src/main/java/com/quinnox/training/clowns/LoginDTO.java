package com.quinnox.training.clowns;

import com.quinnox.training.clowns.userspef.Role;
import com.quinnox.training.clowns.userspef.Users;

public class LoginDTO {
	
	
	public String username;
	public String password;
	public Role role;
	
	
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.role = Role.USER;
	}
	
	public LoginDTO(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public LoginDTO(String username) {
		super();
		this.username = username;
	}
	
	public LoginDTO() {
		
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
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Users conversion() {
		Users user = new Users(this.username, this.password, this.role);
		return user;
	}
	
	
}
