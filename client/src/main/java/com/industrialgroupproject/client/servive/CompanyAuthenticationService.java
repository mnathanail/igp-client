package com.industrialgroupproject.client.servive;

import com.industrialgroupproject.client.model.CompanyAuthenticationModel;
import com.industrialgroupproject.client.model.CompanyModel;

public interface CompanyAuthenticationService {
	CompanyModel findByUserName(String userName);
	CompanyModel findByUserAndPassword(CompanyAuthenticationModel cm);
}
