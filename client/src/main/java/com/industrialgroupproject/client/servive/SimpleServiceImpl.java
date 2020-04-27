package com.industrialgroupproject.client.servive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.industrialgroupproject.client.Utils.HttpStatusCodeCheck;
import com.industrialgroupproject.client.endpoints.Endpoints;
import com.industrialgroupproject.client.model.CompanyCertificationSelfDocuments;
import com.industrialgroupproject.client.model.CompanyRequest;

@Service
public class SimpleServiceImpl implements SimpleServive {

	private final RestTemplate restTemplate;
	private final String applicationServerUrl;
	//private final String fakeServer = "https://api.myjson.com/bins";

	@Autowired
	public SimpleServiceImpl(RestTemplateBuilder restTemplateBuilder, @Value("${applicationserver.rest.url}") String applicationServerUrl) {
		this.restTemplate = restTemplateBuilder.build();
		this.applicationServerUrl = applicationServerUrl;
	}

	@Override
	public String save(CompanyCertificationSelfDocuments sm) {
		final String url = this.applicationServerUrl + sm.getCompanyId() + "/" +Endpoints.CERT_CREATION;
		//final String url = this.applicationServerUrl;
		ResponseEntity<String> response = null;
		response = this.restTemplate.postForEntity(url, sm, String.class);
		return HttpStatusCodeCheck.httpStatusCodeAndResponse(response.getStatusCode());
	}

	@Override
	public List<CompanyRequest> get(int id) {
		final String url = this.applicationServerUrl +Endpoints.AITISEIS + "/" + id;
		final Map<String, Integer> parameter = new HashMap<String, Integer>();
		parameter.put("aitisid", id);
		final String comResponseEntity =
				this.restTemplate.getForObject(url, String.class, parameter);
		//final CompanyRequest companyRequest = comResponseEntity.getBody();
		final ObjectMapper mapper = new ObjectMapper();
		List<CompanyRequest> companyRequest = null;
		try {
			companyRequest = mapper.reader()
				      .forType(new TypeReference<List<CompanyRequest>>() {})
				      .readValue(comResponseEntity);
		} catch (final JsonMappingException e) {
			e.printStackTrace();
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		}
		return companyRequest;
	}


}
