package com.industrialgroupproject.client.model;

public class UserResponse {

	private CompanyModel response;
	private String str;

	public UserResponse(String str) {
		this.str = str;
	}

	public UserResponse(CompanyModel response, String str) {
		this.response = response;
		this.str = str;
	}

	public CompanyModel getResponse() {
		return this.response;
	}

	public void setResponse(CompanyModel response) {
		this.response = response;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getStr() {
		return this.str;
	}

}
