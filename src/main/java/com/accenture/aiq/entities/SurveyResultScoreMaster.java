package com.accenture.aiq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="surveyresultscoremaster")
public class SurveyResultScoreMaster {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="surveyid",nullable=false)
	private int surveyid;
	
	@Column(name="minscore",nullable=false)
	private double minscore;
	
	@Column(name="maxscore",nullable=false)
	private double maxscore;
	
	@Column(name="level",nullable=false)
	private String level;

	public SurveyResultScoreMaster() {
		super();
	}

	public SurveyResultScoreMaster(int id, int surveyid, double minscore, double maxscore, String level) {
		super();
		this.id = id;
		this.surveyid = surveyid;
		this.minscore = minscore;
		this.maxscore = maxscore;
		this.level = level;
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

	public double getMinscore() {
		return minscore;
	}

	public void setMinscore(double minscore) {
		this.minscore = minscore;
	}

	public double getMaxscore() {
		return maxscore;
	}

	public void setMaxscore(double maxscore) {
		this.maxscore = maxscore;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	
}
