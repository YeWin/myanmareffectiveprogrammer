package com.mep.security.dto;

import java.io.Serializable;

public class AuthLoginAdminDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String adminId;
	
	private String adminEmail;	
	
	private String adminPassword;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}
