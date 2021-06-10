package com.accenture.aiq.dto;

import java.io.Serializable;
import java.util.List;

public class SurveyDTO implements Serializable {

	private static final long serialVersionUID = 6149696439612332251L;

	private int surveyId;
	private int userId;
	private String surveyTitle;

	private HomePageDTO homePage;

	private List<InnovationParamDTO> innovationParams;

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public HomePageDTO getHomePage() {
		return homePage;
	}

	public void setHomePage(HomePageDTO homePage) {
		this.homePage = homePage;
	}

	public List<InnovationParamDTO> getInnovationParams() {
		return innovationParams;
	}

	public void setInnovationParams(List<InnovationParamDTO> innovationParams) {
		this.innovationParams = innovationParams;
	}
	
	

	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	@Override
	public String toString() {
		return "SurveyDTO [surveyId=" + surveyId + ", userId=" + userId + ", surveyTitle=" + surveyTitle + ", homePage="
				+ homePage + ", innovationParams=" + innovationParams + "]";
	}

}
