package com.mep.domain.login.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mep.domain.login.dto.LoginAdminDto;
import com.mep.message.DisplayMessage;
import com.mep.message.ResultMessages;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private MessageSource messageSource;

	@Override
	public ResultMessages validate(LoginAdminDto loginAdminDto,
			BindingResult bindingResult) {

		ResultMessages resultMessages = new ResultMessages();
		Locale locale = LocaleContextHolder.getLocale();

		if (!bindingResult.hasErrors()) {
			resultMessages.addError(new DisplayMessage(messageSource
					.getMessage("MEP00003", new Object[] { "Administrator information" }, locale)));
		}

		return resultMessages;
	}

}
