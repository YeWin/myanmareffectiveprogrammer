package com.mep.domain.login.service;

import org.springframework.validation.BindingResult;

import com.mep.domain.login.dto.LoginAdminDto;
import com.mep.message.ResultMessages;

public interface LoginService {

	public ResultMessages validate(LoginAdminDto loginAdminDto,
			BindingResult bindingResult);
}
