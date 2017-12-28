package com.mep.domain.admin.administrator.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class AdministratorDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer adminId;
	
	@NotBlank
	private String adminName;
	
	@Email
	@NotBlank
	private String adminEmail;	
	
	private String adminPassword;
	
	private String adminConfirmPassword;
	
	private String adminImageUrl;
	
	private String aboutAdmin;
	
	private Date createdDate;
	
	private Date updatedDate;
	
	@Email
	private String adminNewEmail;

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getAdminImageUrl() {
		return adminImageUrl;
	}

	public void setAdminImageUrl(String adminImageUrl) {
		this.adminImageUrl = adminImageUrl;
	}

	public String getAboutAdmin() {
		return aboutAdmin;
	}

	public void setAboutAdmin(String aboutAdmin) {
		this.aboutAdmin = aboutAdmin;
	}

	public String getAdminNewEmail() {
		return adminNewEmail;
	}

	public void setAdminNewEmail(String adminNewEmail) {
		this.adminNewEmail = adminNewEmail;
	}
}
