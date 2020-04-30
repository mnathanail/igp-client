package com.industrialgroupproject.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyRequest {

	private int id;
	private String regulatedActivity;
	private Status status;
	private String submition_date;
	private String foreasTitle;

	public CompanyRequest() {

	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegulatedActivity() {
		return this.regulatedActivity;
	}

	public void setRegulatedActivity(String regulatedActivity) {
		this.regulatedActivity = regulatedActivity;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getSubmition_date() {
		return this.submition_date;
	}

	public void setSubmition_date(String submition_date) {
		this.submition_date = submition_date;
	}

	public String getForeasTitle() {
		return this.foreasTitle;
	}

	public void setForeasTitle(String foreasTitle) {
		this.foreasTitle = foreasTitle;
	}

}
