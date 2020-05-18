package com.industrialgroupproject.client.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class CompanyAuthenticationModel {


	private String username;
	private String password;
	private Collection<GrantedAuthority> role;

	public CompanyAuthenticationModel() {
	}

	public CompanyAuthenticationModel(String username, String password, Collection<GrantedAuthority> role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<GrantedAuthority> getRole() {
		return this.role;
	}

	public void setRole(Collection<GrantedAuthority> role) {
		this.role = role;
	}


}
