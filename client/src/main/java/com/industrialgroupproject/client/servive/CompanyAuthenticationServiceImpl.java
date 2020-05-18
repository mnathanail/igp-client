package com.industrialgroupproject.client.servive;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.industrialgroupproject.client.endpoints.Endpoints;
import com.industrialgroupproject.client.model.CompanyAuthenticationModel;
import com.industrialgroupproject.client.model.CompanyModel;

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
	public CompanyModel findByUserName(String userName) {
		final String url = this.applicationServerUrl +Endpoints.LOGIN_USERNAME;
		final Map<String, String> map = new HashMap<>();
		map.put("username", userName);
		final ResponseEntity<CompanyModel> a = this.restTemplate.postForEntity(url, map, CompanyModel.class);
		//final String com = this.restTemplate.postForObject(url, map, String.class);

		return a.getBody();
	}

	@Override
	public CompanyModel findByUserAndPassword(CompanyAuthenticationModel cm) {
		final String url = this.applicationServerUrl +Endpoints.LOGIN;
		final Map<String, String> map = new HashMap<>();
		map.put("username", cm.getUsername());
		map.put("password", cm.getPassword());

		final ResponseEntity<CompanyModel> response = this.restTemplate.postForEntity(url, map, CompanyModel.class);
		final CompanyModel company =response.getBody();
		return company;
		//return HttpStatusCodeCheck.httpStatusCodeAndResponse(response.getStatusCode());
	}

}
