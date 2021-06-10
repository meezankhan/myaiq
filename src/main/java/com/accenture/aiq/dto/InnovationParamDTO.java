package com.accenture.aiq.dto;

import java.io.Serializable;
import java.util.List;

public class InnovationParamDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1479091316110401683L;

	private int id;
	private String innovationParam;
	private int orderId;

	private List<QuestionaireDTO> questions;

	public String getInnovationParam() {
		return innovationParam;
	}

	public void setInnovationParam(String innovationParam) {
		this.innovationParam = innovationParam;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<QuestionaireDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionaireDTO> questions) {
		this.questions = questions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "InnovationParamDTO [id=" + id + ", innovationParam=" + innovationParam + ", orderId=" + orderId
				+ ", questions=" + questions + "]";
	}

}
