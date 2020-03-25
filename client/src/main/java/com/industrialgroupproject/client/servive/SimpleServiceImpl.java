package com.industrialgroupproject.client.servive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.industrialgroupproject.client.Utils.HttpStatusCodeCheck;
import com.industrialgroupproject.client.endpoints.Endpoints;
import com.industrialgroupproject.client.model.CompanyCertificationSelfDocuments;

@Service
public class SimpleServiceImpl implements SimpleServive {

	private final RestTemplate restTemplate;
	private final String applicationServerUrl;

	@Autowired
	public SimpleServiceImpl(RestTemplateBuilder restTemplateBuilder, @Value("${applicationserver.rest.url}") String applicationServerUrl) {
		this.restTemplate = restTemplateBuilder.build();
		this.applicationServerUrl = applicationServerUrl;
	}

	@Override
	public String save(CompanyCertificationSelfDocuments sm) {
		final String url = this.applicationServerUrl +Endpoints.CERT_CREATION;
		ResponseEntity<String> response = null;
		response = this.restTemplate.postForEntity(url, sm, String.class);
		return HttpStatusCodeCheck.httpStatusCodeAndResponse(response.getStatusCode());
		/*
		 * try { response = this.restTemplate.postForEntity(url, sm, String.class);
		 * return
		 * HttpStatusCodeCheck.httpStatusCodeAndResponse(response.getStatusCode()); }
		 * catch (final HttpClientErrorException e) { return
		 * HttpStatusCodeCheck.httpStatusCodeAndResponse(e.getStatusCode()); }
		 */

	}

}
