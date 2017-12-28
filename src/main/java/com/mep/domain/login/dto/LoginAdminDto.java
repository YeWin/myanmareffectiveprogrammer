package com.mep.domain.login.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class LoginAdminDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Email
	@NotBlank
	private String adminEmail;	
	
	@NotBlank
	private String adminPassword;

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
