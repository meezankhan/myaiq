package com.accenture.aiq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="innovationparamscoremaster")
public class InnovationParamScoreMaster {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="innovationparamid",nullable=false)
	private int innovationparamid;
	
	@Column(name="minscore",nullable=false)
	private double minscore;
	
	@Column(name="maxscore",nullable=false)
	private double maxscore;
	
	@Column(name="level",nullable=false)
	private String level;

	public InnovationParamScoreMaster() {
		super();
	}

	public InnovationParamScoreMaster(int id, int innovationparamid, double minscore, double maxscore, String level) {
		super();
		this.id = id;
		this.innovationparamid = innovationparamid;
		this.minscore = minscore;
		this.maxscore = maxscore;
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInnovationparamid() {
		return innovationparamid;
	}

	public void setInnovationparamid(int innovationparamid) {
		this.innovationparamid = innovationparamid;
	}

	public double getMinscore() {
		return minscore;
	}

	public void setMinscore(double minscore) {
		this.minscore = minscore;
	}

	public double getMaxscore() {
		return maxscore;
	}

	public void setMaxscore(double maxscore) {
		this.maxscore = maxscore;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	

}
