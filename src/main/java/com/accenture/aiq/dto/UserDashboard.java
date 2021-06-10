package com.accenture.aiq.dto;

import java.io.Serializable;
import java.util.List;

public class UserDashboard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3397416203499244255L;

	List<SurveyResultDTO> surveyList;
	
	public List<SurveyResultDTO> getSurveyList() {
		return surveyList;
	}
	public void setSurveyList(List<SurveyResultDTO> surveyList) {
		this.surveyList = surveyList;
	}
}
