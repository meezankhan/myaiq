package com.accenture.aiq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usermaster")
public class UserMaster {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="useremail",nullable=false)
	private String useremail;
	
	@Column(name="role",nullable=false)
	private String role;
	
	@Column(name="marketunit")
	private String marketunit;
	
	@Column(name="active",nullable=false)
	private int active=1;

	public UserMaster() {
		super();
	}

     public UserMaster(String useremail, String role, String marketunit) {
		
		this.useremail = useremail;
		this.role = role;
		this.marketunit = marketunit;
		
	}

	public UserMaster(String useremail, String role, String marketunit, int active) {
		
		this.useremail = useremail;
		this.role = role;
		this.marketunit = marketunit;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
