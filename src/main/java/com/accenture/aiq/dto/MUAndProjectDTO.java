package com.accenture.aiq.dto;

import java.io.Serializable;
import java.util.List;

public class MUAndProjectDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2869445762082885327L;

	private List<String> marketUnitList;
	private List<String> projectList;

	public List<String> getMarketUnitList() {
		return marketUnitList;
	}

	public void setMarketUnitList(List<String> marketUnitList) {
		this.marketUnitList = marketUnitList;
	}

	public List<String> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<String> projectList) {
		this.projectList = projectList;
	}

	@Override
	public String toString() {
		return "ProjectDTO [marketUnitList=" + marketUnitList + ", projectList=" + projectList + "]";
	}

}
