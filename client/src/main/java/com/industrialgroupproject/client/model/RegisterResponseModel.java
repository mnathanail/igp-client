package com.industrialgroupproject.client.model;

public class RegisterResponseModel {

	private String text;
	private String jwt;

	public RegisterResponseModel(String text, String jwt) {
		this.text = text;
		this.jwt = jwt;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getJwt() {
		return this.jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}


}
