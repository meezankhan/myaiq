package com.accenture.aiq.dto;

import java.io.Serializable;

public class HomePageDropDownDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4557377345294570545L;

	private String value;

	private boolean isDefault;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	@Override
	public String toString() {
		return "HomePageDropDownDTO [value=" + value + ", isDefault=" + isDefault + "]";
	}

}
