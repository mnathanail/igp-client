package com.industrialgroupproject.client.servive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.industrialgroupproject.client.endpoints.Endpoints;
import com.industrialgroupproject.client.model.CompanyAuthenticationModel;

@Service
public class CompanyAuthenticationServiceImpl implements CompanyAuthenticationService {


	private final RestTemplate restTemplate;
	private final String applicationServerUrl;
	//private final String fakeServer = "https://api.myjson.com/bins";

	@Autowired
	public CompanyAuthenticationServiceImpl
	(RestTemplateBuilder restTemplateBuilder, @Value("${applicationserver.rest.url}") String applicationServerUrl) {
		this.restTemplate = restTemplateBuilder.build();
		this.applicationServerUrl = applicationServerUrl;
	}

	@Override
	public CompanyAuthenticationModel findByUserName(String userName) {
		//final String url = this.applicationServerUrl +Endpoints.;
		final String url = this.applicationServerUrl +Endpoints.LOGIN;

		 final CompanyAuthenticationModel responseEntity =
				 this.restTemplate.getForObject(url, CompanyAuthenticationModel.class);

		return responseEntity;
	}

}
