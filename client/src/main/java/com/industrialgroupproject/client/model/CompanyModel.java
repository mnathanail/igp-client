package com.industrialgroupproject.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyModel {
	 private String fid;
	 private String name;
	 private String surname;
	 private String distinctiveTitle;
	 private String afm;
	 private String doy;
	 private String gemh;
	 private String address;
	 private String phoneNumber;
	 private String fax;
	 private String email;
	 private String contactMember;
	 private String username;
	 private String password;
	 private String Roles;


	 // Getter Methods

	 public String getName() {
	  return this.name;
	 }

	 public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getSurname() {
	  return this.surname;
	 }

	 public String getDistinctiveTitle() {
	  return this.distinctiveTitle;
	 }

	 public String getAfm() {
	  return this.afm;
	 }

	 public String getDoy() {
	  return this.doy;
	 }

	 public String getGemh() {
	  return this.gemh;
	 }

	 public String getAddress() {
	  return this.address;
	 }

	 public String getPhoneNumber() {
	  return this.phoneNumber;
	 }

	 public String getFax() {
	  return this.fax;
	 }

	 public String getEmail() {
	  return this.email;
	 }

	 public String getContactMember() {
	  return this.contactMember;
	 }

	 public String getUsername() {
	  return this.username;
	 }

	 public String getPassword() {
	  return this.password;
	 }

	 // Setter Methods

	 public void setName(String name) {
	  this.name = name;
	 }

	 public void setSurname(String surname) {
	  this.surname = surname;
	 }

	 public void setDistinctiveTitle(String distinctiveTitle) {
	  this.distinctiveTitle = distinctiveTitle;
	 }

	 public void setAfm(String afm) {
	  this.afm = afm;
	 }

	 public void setDoy(String doy) {
	  this.doy = doy;
	 }

	 public void setGemh(String gemh) {
	  this.gemh = gemh;
	 }

	 public void setAddress(String address) {
	  this.address = address;
	 }

	 public void setPhoneNumber(String phoneNumber) {
	  this.phoneNumber = phoneNumber;
	 }

	 public void setFax(String fax) {
	  this.fax = fax;
	 }

	 public void setEmail(String email) {
	  this.email = email;
	 }

	 public void setContactMember(String contactMember) {
	  this.contactMember = contactMember;
	 }

	 public void setUsername(String username) {
	  this.username = username;
	 }

	 public void setPassword(String password) {
	  this.password = password;
	 }

	public String getRoles() {
		return this.Roles;
	}

	public void setRoles(String roles) {
		this.Roles = roles;
	}
}
