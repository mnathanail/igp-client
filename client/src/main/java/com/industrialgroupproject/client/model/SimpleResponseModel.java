package com.industrialgroupproject.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpleResponseModel {

	private String text;
	private String jwt;

	public SimpleResponseModel(String text) {
		this.text = text;
	}

	public SimpleResponseModel(String text, String jwt) {
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
