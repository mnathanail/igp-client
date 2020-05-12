package com.industrialgroupproject.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegulatedActivity {

	private int activityId;
	private String name;

	public RegulatedActivity() {
	}

	public RegulatedActivity(int activityId, String name) {
		this.activityId = activityId;
		this.name = name;
	}
	public int getActivityId() {
		return this.activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
