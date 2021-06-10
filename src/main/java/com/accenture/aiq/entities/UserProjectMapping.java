package com.accenture.aiq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userprojectmapping")
public class UserProjectMapping {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="userid",nullable=false)
	private int userid;
	
	@Column(name="projectid",nullable=false)
	private int projectid;

	public UserProjectMapping() {
		super();
	}

	public UserProjectMapping(int id, int userid, int projectid) {
		super();
		this.id = id;
		this.userid = userid;
		this.projectid = projectid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	
	
	

}
