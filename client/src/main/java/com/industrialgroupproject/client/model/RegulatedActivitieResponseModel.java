package com.industrialgroupproject.client.model;

import java.util.List;

public class RegulatedActivitieResponseModel {

	private final List<RegulatedActivity> regulatedActivity;

	public RegulatedActivitieResponseModel(List<RegulatedActivity> regulatedActivity) {
		this.regulatedActivity = regulatedActivity;
	}

	public List<RegulatedActivity> getRegulatedActivity() {
		return regulatedActivity;
	}

}
