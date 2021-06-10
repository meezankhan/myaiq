package com.accenture.aiq.dto;

import java.io.Serializable;

public class OptionsDTO implements Serializable {

	private static final long serialVersionUID = -838168500391947332L;

	private String name;
	private String value;
	private String comments;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "OptionsDTO [name=" + name + ", value=" + value + ", comments=" + comments + "]";
	}

}
