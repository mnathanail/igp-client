package com.industrialgroupproject.client.servive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.industrialgroupproject.client.Utils.HttpStatusCodeCheck;
import com.industrialgroupproject.client.endpoints.Endpoints;
import com.industrialgroupproject.client.model.CompanyModel;

@Service
public class RegisterImpl implements RegisterService {

	private final RestTemplate restTemplate;
	private final String applicationServerUrl;
	//private final String fakeServer = "https://api.myjson.com/bins";

	@Autowired
	public RegisterImpl(RestTemplateBuilder restTemplateBuilder, @Value("${applicationserver.rest.url}") String applicationServerUrl) {
		this.restTemplate = restTemplateBuilder.build();
		this.applicationServerUrl = applicationServerUrl;
	}


	@Override
	public String register(CompanyModel model) {
		final String url = this.applicationServerUrl + Endpoints.REGISTER;
		final ResponseEntity<String> response= this.restTemplate.postForEntity(url, model, String.class);
		return HttpStatusCodeCheck.httpStatusCodeAndResponse(response.getStatusCode());
	}

}
