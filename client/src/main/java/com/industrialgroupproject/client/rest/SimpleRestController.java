package com.industrialgroupproject.client.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.industrialgroupproject.client.model.SimpleModel;

@RestController
public class SimpleRestController {

	@PostMapping(path = "/save")
	public  @ResponseBody SimpleModel save(@RequestBody SimpleModel json) {
		System.out.println("Message: " + json.getMsg());
		return json;
	}

}
