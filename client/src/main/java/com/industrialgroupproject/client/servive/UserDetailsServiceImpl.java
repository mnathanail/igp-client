package com.industrialgroupproject.client.servive;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.industrialgroupproject.client.model.CompanyAuthenticationModel;
import com.industrialgroupproject.client.model.CompanyModel;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private CompanyAuthenticationService companyAuthenticationService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		final CompanyAuthenticationModel company = this.companyAuthenticationService.findByUserName(userName);
		if(company == null) {
			 throw new UsernameNotFoundException(userName);
		}
		return new User(company.getName(), company.getPassword() , new ArrayList<>());
	}

	public UserDetails loadRegisteredUser(CompanyModel company) throws UsernameNotFoundException {
		if((company.getName() == null) && (company.getPassword() == null)) {
			 throw new UsernameNotFoundException(company.getName());
		}
		return new User(company.getName(), company.getPassword() , new ArrayList<>());
	}

}