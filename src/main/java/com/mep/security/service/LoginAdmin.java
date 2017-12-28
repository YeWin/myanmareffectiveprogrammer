package com.mep.security.service;

import org.springframework.security.core.authority.AuthorityUtils;

import com.mep.security.dto.AuthLoginAdminDto;

public class LoginAdmin extends
		org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;

	private final AuthLoginAdminDto authLoginUserDto;

	public LoginAdmin(AuthLoginAdminDto admin) {

		super(admin.getAdminId(), admin.getAdminPassword(), AuthorityUtils
				.createAuthorityList("ROLE_ADMIN"));
		this.authLoginUserDto = admin;
	}

	public AuthLoginAdminDto getAuthLoginUserDto() {
		return authLoginUserDto;
	}
}
