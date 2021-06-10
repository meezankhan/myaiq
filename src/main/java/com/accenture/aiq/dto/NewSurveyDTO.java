package com.accenture.aiq.dto;

import java.io.Serializable;

public class NewSurveyDTO implements Serializable {

	private static final long serialVersionUID = 2597375979495237662L;
	
	private SurveyDTO survey;

	public SurveyDTO getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyDTO survey) {
		this.survey = survey;
	}
	
	

	
}
