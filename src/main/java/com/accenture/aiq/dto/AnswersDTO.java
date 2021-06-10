package com.accenture.aiq.dto;

import java.io.Serializable;

public class AnswersDTO implements Serializable {

	private static final long serialVersionUID = -8069417731109200906L;

	private int orderId;
	private String answer;
	private String value;
	private boolean isDefault;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "AnswersDTO [orderId=" + orderId + ", answer=" + answer + ", value=" + value + ", isDefault=" + isDefault
				+ "]";
	}

}
