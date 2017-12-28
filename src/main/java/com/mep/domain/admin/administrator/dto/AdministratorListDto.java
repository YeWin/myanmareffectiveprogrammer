package com.mep.domain.admin.administrator.dto;


public class AdministratorListDto {

	private Integer adminId;	
	
	private String adminName;	
	
	private String adminEmail;	
	
	private String adminPassword;
	
	private String adminConfirmPassword;	
	
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

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminConfirmPassword() {
		return adminConfirmPassword;
	}

	public void setAdminConfirmPassword(String adminConfirmPassword) {
		this.adminConfirmPassword = adminConfirmPassword;
	}
}
