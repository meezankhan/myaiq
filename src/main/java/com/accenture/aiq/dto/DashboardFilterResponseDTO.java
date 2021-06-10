package com.accenture.aiq.dto;

import java.io.Serializable;

public class DashboardFilterResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6954066951314550461L;

	private MUAndProjectDTO response;

	public MUAndProjectDTO getResponse() {
		return response;
	}

	public void setResponse(MUAndProjectDTO response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "UserProjectResponseDTO [response=" + response + "]";
	}

}
