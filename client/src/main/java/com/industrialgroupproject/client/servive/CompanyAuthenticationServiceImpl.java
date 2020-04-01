package com.industrialgroupproject.client.servive;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.industrialgroupproject.client.Utils.HttpStatusCodeCheck;
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
	public String findByUserName(String userName) {
		//final String url = this.applicationServerUrl +Endpoints.;
		final String url = this.applicationServerUrl +Endpoints.LOGIN_USERNAME;
		final Map<String, String> map = new HashMap<>();
		map.put("username", userName);
		final ResponseEntity<String> response =
				 this.restTemplate.postForEntity(url,map, String.class);
		return HttpStatusCodeCheck.httpStatusCodeAndResponse(response.getStatusCode());
	}

	@Override
	public String findByUserAndPassword(CompanyAuthenticationModel cm) {
		final String url = this.applicationServerUrl +Endpoints.LOGIN;
		final Map<String, String> map = new HashMap<>();
		map.put("username", cm.getUsername());
		map.put("password", cm.getPassword());
		final ResponseEntity<String> response = this.restTemplate.postForEntity(url, map, String.class);
		return HttpStatusCodeCheck.httpStatusCodeAndResponse(response.getStatusCode());
	}

}
