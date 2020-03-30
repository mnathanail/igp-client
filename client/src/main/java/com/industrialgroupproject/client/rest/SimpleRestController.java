package com.industrialgroupproject.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.industrialgroupproject.client.Utils.JwtUtil;
import com.industrialgroupproject.client.model.CompanyAuthenticationModel;
import com.industrialgroupproject.client.model.CompanyCertificationSelfDocuments;
import com.industrialgroupproject.client.model.CompanyModel;
import com.industrialgroupproject.client.model.SimpleResponseModel;
import com.industrialgroupproject.client.servive.RegisterService;
import com.industrialgroupproject.client.servive.SimpleServive;
import com.industrialgroupproject.client.servive.UserDetailsServiceImpl;

@RestController
public class SimpleRestController {

	@Autowired
	private SimpleServive sm;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private RegisterService registerService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@PostMapping(path = "/save")
	public @ResponseBody SimpleResponseModel save(@RequestBody CompanyCertificationSelfDocuments json) {
		final String response = this.sm.save(json);
		return new SimpleResponseModel(response);
	}

	@PostMapping(path = "/authentication")
	public @ResponseBody SimpleResponseModel createAuthenticationToken(
			@RequestBody CompanyAuthenticationModel companyAuthentication) {

		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(companyAuthentication.getName(),
				companyAuthentication.getPassword()));

		final UserDetails userDetails = this.userDetailsService.loadUserByUsername(companyAuthentication.getName());
		final String jwt = this.jwtTokenUtil.generateToken(userDetails);
		return new SimpleResponseModel(jwt);

	}

	@GetMapping(path = "/save")
	public CompanyCertificationSelfDocuments show() {
		return new CompanyCertificationSelfDocuments();
	}

	@PostMapping(path = "/register")
	public @ResponseBody SimpleResponseModel registerCompany(@RequestBody CompanyModel cm) {
		final String response = this.registerService.register(cm);

		if (response.equals("Suceess :) ")) { //needs to be changed asap.
			final UserDetails userDetails = this.userDetailsService.loadRegisteredUser(cm);
			final String jwt = this.jwtTokenUtil.generateToken(userDetails);
			System.out.println(jwt);
			return new SimpleResponseModel(response, jwt);
		}

		return new SimpleResponseModel(response);
	}

	@GetMapping(path = "/")
	public String index() {
		return "Welcome :)";
	}
}
