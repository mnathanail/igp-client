package com.industrialgroupproject.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.industrialgroupproject.client.model.SimpleModel;
import com.industrialgroupproject.client.servive.SimpleServive;

@RestController
public class SimpleRestController {

	private SimpleModel json;

	@Autowired
	private SimpleServive sm;

	@PostMapping(path = "/save")
	public  @ResponseBody SimpleModel save(@RequestBody SimpleModel json) {
		//for prod
		this.sm.save(json);
		//return "SUCCESS";

		//testing stuff
		this.json = json;
		System.out.println("Message: " + this.json.getMsg());
		return this.json;
	}

	@GetMapping(path = "/save")
	public  SimpleModel show() {
		return this.json != null ? this.json : null;
	}

	@GetMapping(path = "/")
	public String index() {

		return "Welcome :)";
	}
}
