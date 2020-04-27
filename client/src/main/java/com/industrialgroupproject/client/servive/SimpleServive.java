package com.industrialgroupproject.client.servive;

import java.util.List;

import com.industrialgroupproject.client.model.CompanyCertificationSelfDocuments;
import com.industrialgroupproject.client.model.CompanyRequest;

public interface SimpleServive {

	public String save(CompanyCertificationSelfDocuments sm);

	public List<CompanyRequest> get(int id);
}
