package com.industrialgroupproject.client.servive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.industrialgroupproject.client.endpoints.Endpoints;
import com.industrialgroupproject.client.model.RegulatedActivity;

@Service
public class RegulatedActivitiesImpl implements RegulatedActivities {

	private final RestTemplate restTemplate;
	private final String applicationServerUrl;
	//private final String fakeServer = "https://api.myjson.com/bins";

	@Autowired
	public RegulatedActivitiesImpl(RestTemplateBuilder restTemplateBuilder, @Value("${applicationserver.rest.url}") String applicationServerUrl) {
		this.restTemplate = restTemplateBuilder.build();
		this.applicationServerUrl = applicationServerUrl;
	}



	@Override
	public List<RegulatedActivity> getRegulatedActivities() {
		final String url = this.applicationServerUrl + Endpoints.REGULATED_ACTIVITIES;

		final List<RegulatedActivity> response= this.restTemplate.getForObject(url, List.class);

		return response;
	}

}
