package com.mep.domain.admin.administrator.dto;

import java.io.Serializable;

public class PasswordChangeDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer adminId;
	
	private String newAdminPassword;
	
	private String newAdminConfirmPassword;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getNewAdminPassword() {
		return newAdminPassword;
	}

	public void setNewAdminPassword(String newAdminPassword) {
		this.newAdminPassword = newAdminPassword;
	}

	public String getNewAdminConfirmPassword() {
		return newAdminConfirmPassword;
	}

	public void setNewAdminConfirmPassword(String newAdminConfirmPassword) {
		this.newAdminConfirmPassword = newAdminConfirmPassword;
	}

}
