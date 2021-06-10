package com.accenture.aiq.dto;

public class InnovationParamResult {

	int id;
	String name;
	float score;
	String level;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "InnovationParamResult [id=" + id + ", name=" + name + ", score=" + score + ", level=" + level + "]";
	}
	
	
}
