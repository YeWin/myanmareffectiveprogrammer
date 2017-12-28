package com.mep.domain.login.dto;

import java.io.Serializable;

public class SessionLoginAdminDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer adminId;
	
	private String adminName;
	
	private String adminEmail;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
}
