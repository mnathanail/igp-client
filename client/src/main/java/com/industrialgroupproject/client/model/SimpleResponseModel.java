package com.industrialgroupproject.client.model;

import java.util.List;

public class SimpleResponseModel {

	private String text;
	private String jwt;
	private CompanyRequest companyRequest;
	private List<CompanyRequest> list;
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
		this.setList(response);
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

	public List<CompanyRequest> getList() {
		return this.list;
	}

	public void setList(List<CompanyRequest> list) {
		this.list = list;
	}

}
