package com.accenture.aiq.dto;

import java.io.Serializable;

public class SubmitSurveyResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5606766837631354239L;

	private SurveyResultResponse surveyResultResponse;

	public SurveyResultResponse getSurveyResultResponse() {
		return surveyResultResponse;
	}

	public void setSurveyResultResponse(SurveyResultResponse surveyResultResponse) {
		this.surveyResultResponse = surveyResultResponse;
	}

	@Override
	public String toString() {
		return "SubmitSurveyResponseDTO [surveyResultResponse=" + surveyResultResponse + "]";
	}

}
