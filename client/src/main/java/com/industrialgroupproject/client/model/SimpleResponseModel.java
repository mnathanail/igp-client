package com.industrialgroupproject.client.model;

import java.util.List;

public class SimpleResponseModel {

	private String text;
	private String jwt;
	private CompanyRequest companyRequest;
	public SimpleResponseModel(String text) {
		this.text = text;
	}

	public SimpleResponseModel(String text, String jwt) {
		this.text = text;
		this.jwt = jwt;
	}

	public SimpleResponseModel(CompanyRequest companyRequest) {
		this.companyRequest = companyRequest;
	}

	public SimpleResponseModel(List<CompanyRequest> response) {
		// TODO Auto-generated constructor stub
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

	public CompanyRequest getCompanyRequest() {
		return this.companyRequest;
	}

	public void setCompanyRequest(CompanyRequest companyRequest) {
		this.companyRequest = companyRequest;
	}

}
