package com.accenture.aiq.dto;

import java.io.Serializable;
import java.util.List;

public class InnoParamResultResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8316248940337624279L;

	private String innoParamTitle;
	private String score;
	private String level;
	private List<String> recommendations;

	public String getInnoParamTitle() {
		return innoParamTitle;
	}

	public void setInnoParamTitle(String innoParamTitle) {
		this.innoParamTitle = innoParamTitle;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	

	public List<String> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(List<String> recommendations) {
		this.recommendations = recommendations;
	}

	@Override
	public String toString() {
		return "InnoParamResultResponse [innoParamTitle=" + innoParamTitle + ", score=" + score + ", level=" + level
				+ ", recommendations=" + recommendations + "]";
	}

}
