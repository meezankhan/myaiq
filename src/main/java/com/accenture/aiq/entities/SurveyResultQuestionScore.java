package com.accenture.aiq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="surveyresultquestionscore")
public class SurveyResultQuestionScore {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="surveyresultid",nullable=false)
	private int surveyresultid;
	
	@Column(name="answerid",nullable=false)
	private int answerid;
	
	@Column(name="questionid",nullable=false)
	private int questionid;
	
	@Column(name="score")
	private int score;
	
	@Column(name="comments")
	private String comments;

	public SurveyResultQuestionScore() {
		super();
	}

	public SurveyResultQuestionScore(int surveyresultid, int answerid, int questionid, int score,
			String comments) {
		this.surveyresultid = surveyresultid;
		this.answerid = answerid;
		this.questionid = questionid;
		this.score = score;
		this.comments = comments;
	}

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

	public int getAnswerid() {
		return answerid;
	}

	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public double getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	
	
	
	

}
