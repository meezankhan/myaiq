package com.accenture.aiq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="surveyresultinnoscore")
public class SurveyResultInnoScore {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="surveyresultid",nullable=false)
	private int surveyresultid;
	
	@Column(name="innoparamid",nullable=false)
	private int innoparamid;
	
	@Column(name="score")
	private int score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSurveyresultid() {
		return surveyresultid;
	}

	public void setSurveyresultid(int surveyresultid) {
		this.surveyresultid = surveyresultid;
	}

	public int getInnoparamid() {
		return innoparamid;
	}

	public void setInnoparamid(int innoparamid) {
		this.innoparamid = innoparamid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public SurveyResultInnoScore() {}
	
	public SurveyResultInnoScore(int surveyresultid, int innoparamid, int score) {
		this.surveyresultid = surveyresultid;
		this.innoparamid = innoparamid;
		this.score = score;
	}
}
