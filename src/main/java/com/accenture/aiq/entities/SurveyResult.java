package com.accenture.aiq.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "surveyresult")
public class SurveyResult {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "userid", nullable = false)
	private int userid;

	@Column(name = "projectid", nullable = false)
	private int projectid;

	@Column(name = "surveyid", nullable = false)
	private int surveyid;

	@Column(name = "marketunit")
	private String marketunit;

	@Column(name = "clientgroup")
	private String clientgroup;

	@Column(name = "deliveryunit")
	private String deliveryunit;

	@Column(name = "clientname")
	private String clientname;

	@Column(name = "cal")
	private String cal;

	@Column(name = "deliverymd")
	private String deliverymd;

	@Column(name = "innovationlead")
	private String innovationlead;

	@Column(name = "status")
	private String status;

	@Column(name = "score")
	private int score;

	@Column(name = "createdon")
	private Timestamp createdOn;

	@Column(name = "submittedon")
	private Timestamp submittedOn;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getSubmittedOn() {
		return submittedOn;
	}

	public void setSubmittedOn(Timestamp submittedOn) {
		this.submittedOn = submittedOn;
	}

	public SurveyResult() {
	}

	public SurveyResult(int userid, int projectid, int surveyid, String marketunit, String clientgroup,
			String deliveryunit, String clientname, String cal, String deliverymd, String innovationlead, String status,
			int score, Timestamp createdOn, Timestamp submittedOn) {
		this.userid = userid;
		this.projectid = projectid;
		this.surveyid = surveyid;
		this.marketunit = marketunit;
		this.clientgroup = clientgroup;
		this.deliveryunit = deliveryunit;
		this.clientname = clientname;
		this.cal = cal;
		this.deliverymd = deliverymd;
		this.innovationlead = innovationlead;
		this.status = status;
		this.score = score;
		this.createdOn = createdOn;
		this.submittedOn = submittedOn;
	}

}
