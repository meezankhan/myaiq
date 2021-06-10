package com.accenture.aiq.dto;

import java.io.Serializable;
import java.util.List;

public class SurveyResultResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3143476978562619484L;

	private String surveyScore;
	private String surveyRating;
	private String level;

	private List<InnoParamResultResponse> innoParamResults;

	public String getSurveyScore() {
		return surveyScore;
	}

	public void setSurveyScore(String surveyScore) {
		this.surveyScore = surveyScore;
	}

	public String getSurveyRating() {
		return surveyRating;
	}

	public void setSurveyRating(String surveyRating) {
		this.surveyRating = surveyRating;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<InnoParamResultResponse> getInnoParamResults() {
		return innoParamResults;
	}

	public void setInnoParamResults(List<InnoParamResultResponse> innoParamResults) {
		this.innoParamResults = innoParamResults;
	}

	@Override
	public String toString() {
		return "SurveyResultResponse [surveyScore=" + surveyScore + ", surveyRating=" + surveyRating + ", level="
				+ level + ", innoParamResults=" + innoParamResults + "]";
	}

}
