package com.accenture.aiq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="surveymaster")
public class SurveyMaster {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="surveytitle",nullable=false)
	private String surveyTitle;
	
	@Column(name="version")
	private float version;

	@Column(name="maxscore")
	private int maxScore;
	
	
	@Column(name="maxrating")
	private float maxRating;
	
	
	public SurveyMaster() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	public float getVersion() {
		return version;
	}

	public void setVersion(float version) {
		this.version = version;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public float getMaxRating() {
		return maxRating;
	}

	public void setMaxRating(float maxRating) {
		this.maxRating = maxRating;
	}

	
}
