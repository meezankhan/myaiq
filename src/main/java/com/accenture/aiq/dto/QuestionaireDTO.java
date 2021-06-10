package com.accenture.aiq.dto;

import java.io.Serializable;
import java.util.List;

public class QuestionaireDTO implements Serializable {

	private static final long serialVersionUID = 7745430247927151975L;

	private int id;
	private String question;
	private int orderId;

	private List<AnswersDTO> options;
	
	private String comment;

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

	public List<AnswersDTO> getOptions() {
		return options;
	}

	public void setOptions(List<AnswersDTO> options) {
		this.options = options;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "QuestionaireDTO [id=" + id + ", question=" + question + ", orderId=" + orderId + ", options=" + options
				+ ", comment=" + comment + "]";
	}

}
