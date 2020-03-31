package com.industrialgroupproject.client.servive;

import com.industrialgroupproject.client.model.CompanyAuthenticationModel;
import com.industrialgroupproject.client.model.CompanyModel;

public interface CompanyAuthenticationService {
	CompanyAuthenticationModel findByUserName(String userName);
	
	/*==== MINOR ====*/
	String login(CompanyModel model);
	/*==== MINOR ====*/
	
}
