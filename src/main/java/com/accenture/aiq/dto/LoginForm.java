package com.accenture.aiq.dto;

import java.io.Serializable;

public class LoginForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7984356812107491800L;
	
	private String userName;
	private String pwd;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
