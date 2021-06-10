package com.accenture.aiq.dto;

import java.io.Serializable;



public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7139935933525277939L;

    private String useremail;
	
	
	private String role;
	
	
	private String marketunit;
	
	
	private int active=1;


	
	
	public UserDTO() {
		super();
	}




	public UserDTO(String useremail, String role, String marketunit) {
		super();
		this.useremail = useremail;
		this.role = role;
		this.marketunit = marketunit;
	}
	
	


	public UserDTO(String useremail, String role, String marketunit, int active) {
		super();
		this.useremail = useremail;
		this.role = role;
		this.marketunit = marketunit;
		this.active = active;
	}




	public String getUseremail() {
		return useremail;
	}


	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getMarketunit() {
		return marketunit;
	}


	public void setMarketunit(String marketunit) {
		this.marketunit = marketunit;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}
	
	
	
}
