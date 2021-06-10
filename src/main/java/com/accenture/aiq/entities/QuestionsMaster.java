package com.accenture.aiq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="questionairemaster")
public class QuestionsMaster {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="innovationparamid",nullable=false)
	private int innovationparamid;
	
	@Column(name="question",nullable=false)
	private String question;
	
	@Column(name="orderid",nullable=false)
	private int orderId;

	public QuestionsMaster() {
		super();
	}

	public QuestionsMaster(int id, int innovationparamid, String question, int orderId) {
		super();
		this.id = id;
		this.innovationparamid = innovationparamid;
		this.question = question;
		this.orderId = orderId;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	
	

}
