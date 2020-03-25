package com.industrialgroupproject.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.industrialgroupproject.client.model.CompanyCertificationSelfDocuments;
import com.industrialgroupproject.client.model.SimpleResponseModel;
import com.industrialgroupproject.client.servive.SimpleServive;

@RestController
public class SimpleRestController {

	@Autowired
	private SimpleServive sm;

	@PostMapping(path = "/save")
	public  @ResponseBody SimpleResponseModel save(@RequestBody CompanyCertificationSelfDocuments json) {
		final String response = this.sm.save(json);
		return new SimpleResponseModel(response);
	}

	@GetMapping(path = "/save")
	public  CompanyCertificationSelfDocuments show() {
		return new CompanyCertificationSelfDocuments();
	}

	@GetMapping(path = "/")
	public String index() {
		return "Welcome :)";
	}
}
