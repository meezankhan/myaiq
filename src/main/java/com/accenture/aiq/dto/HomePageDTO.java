package com.accenture.aiq.dto;

import java.io.Serializable;
import java.util.List;

public class HomePageDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2142809139409055737L;

	private List<HomePageDropDownDTO> marketUnit;
	private List<HomePageDropDownDTO> clientGroup;
	private List<HomePageDropDownDTO> deliveryUnit;
	private List<HomePageDropDownDTO> clientName;
	private List<HomePageDropDownDTO> cal;
	private List<HomePageDropDownDTO> deliveryMD;
	private String innovationLead;

	public List<HomePageDropDownDTO> getMarketUnit() {
		return marketUnit;
	}

	public void setMarketUnit(List<HomePageDropDownDTO> marketUnit) {
		this.marketUnit = marketUnit;
	}

	public List<HomePageDropDownDTO> getClientGroup() {
		return clientGroup;
	}

	public void setClientGroup(List<HomePageDropDownDTO> clientGroup) {
		this.clientGroup = clientGroup;
	}

	public List<HomePageDropDownDTO> getDeliveryUnit() {
		return deliveryUnit;
	}

	public void setDeliveryUnit(List<HomePageDropDownDTO> deliveryUnit) {
		this.deliveryUnit = deliveryUnit;
	}

	public List<HomePageDropDownDTO> getClientName() {
		return clientName;
	}

	public void setClientName(List<HomePageDropDownDTO> clientName) {
		this.clientName = clientName;
	}

	public List<HomePageDropDownDTO> getCal() {
		return cal;
	}

	public void setCal(List<HomePageDropDownDTO> cal) {
		this.cal = cal;
	}

	public List<HomePageDropDownDTO> getDeliveryMD() {
		return deliveryMD;
	}

	public void setDeliveryMD(List<HomePageDropDownDTO> deliveryMD) {
		this.deliveryMD = deliveryMD;
	}

	public String getInnovationLead() {
		return innovationLead;
	}

	public void setInnovationLead(String innovationLead) {
		this.innovationLead = innovationLead;
	}

	@Override
	public String toString() {
		return "HomePageDTO [marketUnit=" + marketUnit + ", clientGroup=" + clientGroup + ", deliveryUnit="
				+ deliveryUnit + ", clientName=" + clientName + ", cal=" + cal + ", deliveryMD=" + deliveryMD
				+ ", innovationLead=" + innovationLead + "]";
	}

}
