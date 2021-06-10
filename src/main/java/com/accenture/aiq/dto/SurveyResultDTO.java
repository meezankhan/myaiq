package com.accenture.aiq.dto;

import java.io.Serializable;

public class SurveyResultDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6753679923056103555L;

	int userId;
	String userEmail;
	String marketUnit;
	String project;
	int surveyId;
	String surveyTitle;
	int version;
	String status;
	String score;
	String rating;
	String level;
	String submittedOn;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getMarketUnit() {
		return marketUnit;
	}

	public void setMarketUnit(String marketUnit) {
		this.marketUnit = marketUnit;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSubmittedOn() {
		return submittedOn;
	}

	public void setSubmittedOn(String submittedOn) {
		this.submittedOn = submittedOn;
	}

	@Override
	public String toString() {
		return "SurveyResult [userId=" + userId + ", userEmail=" + userEmail + ", marketUnit=" + marketUnit
				+ ", project=" + project + ", surveyId=" + surveyId + ", surveyTitle=" + surveyTitle + ", version="
				+ version + ", status=" + status + ", score=" + score + ", rating=" + rating + ", level=" + level
				+ ", submittedOn=" + submittedOn + "]";
	}

}
