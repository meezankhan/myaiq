package com.accenture.aiq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "innovationparammaster")
public class InnovationParameterMaster {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "surveyid", nullable = false)
	private int surveyid;

	@Column(name = "innovationparameter", nullable = false)
	private String innovationParameter;

	@Column(name = "orderid", nullable = false)
	private int orderid;

	@Column(name = "maxscore")
	private int maxscore;

	public InnovationParameterMaster() {
		super();
	}

	public InnovationParameterMaster(int id, int surveyid, String innovationParameter, int orderid) {
		super();
		this.id = id;
		this.surveyid = surveyid;
		this.innovationParameter = innovationParameter;
		this.orderid = orderid;
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

	public String getInnovationParameter() {
		return innovationParameter;
	}

	public void setInnovationParameter(String innovationParameter) {
		this.innovationParameter = innovationParameter;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getMaxscore() {
		return maxscore;
	}

	public void setMaxscore(int maxscore) {
		this.maxscore = maxscore;
	}

}
