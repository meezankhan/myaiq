package com.accenture.aiq.dto;

import java.io.Serializable;

public class DashboardResult implements Serializable {

	private static final long serialVersionUID = 1134614808484352336L;

	UserDashboard surveys;

	public UserDashboard getSurveys() {
		return surveys;
	}

	public void setSurveys(UserDashboard surveys) {
		this.surveys = surveys;
	}

	@Override
	public String toString() {
		return "DashboardResult [surveys=" + surveys + "]";
	}	
}
