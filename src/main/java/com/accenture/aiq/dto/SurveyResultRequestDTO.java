package com.accenture.aiq.dto;

import java.io.Serializable;
import java.util.List;

public class SurveyResultRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 708611943696587136L;
	private int userId;
	private int surveyId;
	private int projectId;

	private String marketUnit;
	private String clientGroup;
	private String deliveryUnit;
	private String clientName;
	private String cal;
	private String deliveryMD;
	private String innovationLead;

	private List<OptionsDTO> optionsData;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getMarketUnit() {
		return marketUnit;
	}

	public void setMarketUnit(String marketUnit) {
		this.marketUnit = marketUnit;
	}

	public String getClientGroup() {
		return clientGroup;
	}

	public void setClientGroup(String clientGroup) {
		this.clientGroup = clientGroup;
	}

	public String getDeliveryUnit() {
		return deliveryUnit;
	}

	public void setDeliveryUnit(String deliveryUnit) {
		this.deliveryUnit = deliveryUnit;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCal() {
		return cal;
	}

	public void setCal(String cal) {
		this.cal = cal;
	}

	public String getDeliveryMD() {
		return deliveryMD;
	}

	public void setDeliveryMD(String deliveryMD) {
		this.deliveryMD = deliveryMD;
	}

	public String getInnovationLead() {
		return innovationLead;
	}

	public void setInnovationLead(String innovationLead) {
		this.innovationLead = innovationLead;
	}

	public List<OptionsDTO> getOptionsData() {
		return optionsData;
	}

	public void setOptionsData(List<OptionsDTO> optionsData) {
		this.optionsData = optionsData;
	}

	

	@Override
	public String toString() {
		return "SurveyResultRequestDTO [userId=" + userId + ", surveyId=" + surveyId + ", projectId=" + projectId
				+ ", marketUnit=" + marketUnit + ", clientGroup=" + clientGroup + ", deliveryUnit=" + deliveryUnit
				+ ", clientName=" + clientName + ", cal=" + cal + ", deliveryMD=" + deliveryMD + ", innovationLead="
				+ innovationLead + ", optionsData=" + optionsData + "]";
	}

}
