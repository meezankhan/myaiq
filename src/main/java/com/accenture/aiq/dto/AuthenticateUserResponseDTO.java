package com.accenture.aiq.dto;

import java.io.Serializable;

public class AuthenticateUserResponseDTO implements Serializable{

	private static final long serialVersionUID = 6918948620641041646L;

	
	private int userId;
	private String role;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "CreateResponseDTO [userId=" + userId + ", role=" + role + "]";
	}
	
	
	
}
