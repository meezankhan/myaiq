package com.accenture.aiq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "optionsmaster")
public class OptionsMaster {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "questionid", nullable = false)
	private int questionid;

	@Column(name = "answer", nullable = false)
	private String answer;

	@Column(name = "score", nullable = false)
	private int score;

	@Column(name = "orderid", nullable = false)
	private int orderid;

	@Column(name = "isdefault")
	private boolean isDefault;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	@Override
	public String toString() {
		return "OptionsMaster [id=" + id + ", questionid=" + questionid + ", answer=" + answer + ", score=" + score
				+ ", orderid=" + orderid + ", isDefault=" + isDefault + "]";
	}

}
