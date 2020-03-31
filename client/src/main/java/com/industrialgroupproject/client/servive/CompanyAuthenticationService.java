package com.industrialgroupproject.client.servive;

import com.industrialgroupproject.client.model.CompanyAuthenticationModel;

public interface CompanyAuthenticationService {
	String findByUserName(String userName);
	String findByUserAndPassword(CompanyAuthenticationModel cm);
}
