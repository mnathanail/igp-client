package com.industrialgroupproject.client.servive;

import com.industrialgroupproject.client.model.CompanyAuthenticationModel;

public interface CompanyAuthenticationService {
	CompanyAuthenticationModel findByUserName(String userName);
	
	/*==== MINOR ====*/
	String login(CompanyAuthenticationModel model);
	/*==== MINOR ====*/
}
