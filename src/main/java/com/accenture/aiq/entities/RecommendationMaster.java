package com.accenture.aiq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recommendationmaster")
public class RecommendationMaster {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "level")
	private String level;

	@Column(name = "recommendation")
	private String recommendation;

	@Column(name = "type")
	private String type;

	@Column(name = "innovationparamid")
	private int innovationparamid;

	public RecommendationMaster() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getInnovationparamid() {
		return innovationparamid;
	}

	public void setInnovationparamid(int innovationparamid) {
		this.innovationparamid = innovationparamid;
	}

}
