package com.industrialgroupproject.client.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

public class Authority implements GrantedAuthority{

	private  String authority;

	public Authority() {

	}

//	public String getRole() {
//		return this.authority;
//	}
	public Authority(String authority) {
		Assert.hasText(authority, "A granted authority textual representation is required");
		this.authority = authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}

}
