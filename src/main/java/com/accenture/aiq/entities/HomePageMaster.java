package com.accenture.aiq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="homepagemaster")
public class HomePageMaster {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="surveyid",nullable=false)
	private int surveyid;
	
	@Column(name="marketunit")
	private String marketunit;
	
	@Column(name="clientgroup")
	private String clientgroup;
	
	@Column(name="deliveryunit")
	private String deliveryunit;
	
	@Column(name="clientname")
	private String clientname;
	
	@Column(name="cal")
	private String cal;
	
	@Column(name="deliverymd")
	private String deliverymd;
	
	@Column(name="innovationlead")
	private String innovationlead;
	
	@Column(name="projectid",nullable=false)
	private int projectid;

	public HomePageMaster() {
		super();
	}

	public HomePageMaster(int id, int surveyid, String marketunit, String clientgroup, String deliveryunit, String clientname,
			String cal, String deliverymd, String innovationlead, int projectid) {
		super();
		this.id = id;
		this.surveyid = surveyid;
		this.marketunit = marketunit;
		this.clientgroup = clientgroup;
		this.deliveryunit = deliveryunit;
		this.clientname = clientname;
		this.cal = cal;
		this.deliverymd = deliverymd;
		this.innovationlead = innovationlead;
		this.projectid = projectid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSurveyid() {
		return surveyid;
	}

	public void setSurveyid(int surveyid) {
		this.surveyid = surveyid;
	}

	public String getMarketunit() {
		return marketunit;
	}

	public void setMarketunit(String marketunit) {
		this.marketunit = marketunit;
	}

	public String getClientgroup() {
		return clientgroup;
	}

	public void setClientgroup(String clientgroup) {
		this.clientgroup = clientgroup;
	}

	public String getDeliveryunit() {
		return deliveryunit;
	}

	public void setDeliveryunit(String deliveryunit) {
		this.deliveryunit = deliveryunit;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getCal() {
		return cal;
	}

	public void setCal(String cal) {
		this.cal = cal;
	}

	public String getDeliverymd() {
		return deliverymd;
	}

	public void setDeliverymd(String deliverymd) {
		this.deliverymd = deliverymd;
	}

	public String getInnovationlead() {
		return innovationlead;
	}

	public void setInnovationlead(String innovationlead) {
		this.innovationlead = innovationlead;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	
	
	
	
	

}
