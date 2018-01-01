package com.mep.domain.admin.administrator.service;

import java.util.Locale;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import com.mep.database.entity.Administrator;
import com.mep.domain.admin.administrator.dao.AdministratorUpdateConfirmDao;
import com.mep.domain.admin.administrator.dto.PasswordChangeDto;
import com.mep.handler.ApplicationException;
import com.mep.message.DisplayMessage;
import com.mep.message.ResultMessages;
import com.mep.util.BeanConverter;
import com.mep.util.StringUtil;

@Service
public class AdministratorPasswordUpdateConfirmServiceImpl implements
		AdministratorPasswordUpdateConfirmService {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	AdministratorUpdateConfirmDao administratorUpdateConfirmDao;
	
	@Autowired
	private BeanConverter beanConverter;

	@Override
	public ResultMessages validatePassword(PasswordChangeDto passwordChangeDto) throws ApplicationException {

		ResultMessages resultMessages = new ResultMessages();
		Locale locale = LocaleContextHolder.getLocale();

		if (checkPasswordIsEmpty(resultMessages,
				passwordChangeDto, locale)) {
			return resultMessages;
		}

		checkPasswordComplexity(resultMessages,
				passwordChangeDto.getNewAdminPassword(), locale);		

		checkPasswordAndConfirmPasswordIsNotEqual(resultMessages,
				passwordChangeDto.getNewAdminPassword(),
				passwordChangeDto.getNewAdminConfirmPassword(), locale);

		return resultMessages;
	}

	private boolean checkPasswordIsEmpty(ResultMessages resultMessages,
			PasswordChangeDto passwordChangeDto, Locale locale) {
		
		if (StringUtils.isEmpty(passwordChangeDto.getNewAdminPassword())) {
			resultMessages.addError(new DisplayMessage(messageSource
					.getMessage("NotBlank",
							new Object[] { "New Password" }, locale)));

			return true;
		}
		
		return false;
	}

	private boolean checkPasswordComplexity(ResultMessages resultMessages,
			String password, Locale locale) {

		if (!StringUtil.validatePassword(password)) {
			resultMessages.addError(new DisplayMessage(
					messageSource.getMessage("MEP00002",
							new Object[] { "Password" }, locale)));

			return true;
		}
		return false;
	}

	private boolean checkPasswordAndConfirmPasswordIsNotEqual(
			ResultMessages resultMessages, String password,
			String confirmPassword, Locale locale) {

		if (!Objects.equals(password, confirmPassword)) {
			resultMessages.addError(new DisplayMessage(messageSource
					.getMessage("MEP00001", new Object[] { "Password",
							"Confirm Password" }, locale)));
		}
		return false;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateAdministratorPassword(
			PasswordChangeDto passwordChangeDto) throws ApplicationException {

		administratorUpdateConfirmDao
				.updateAdministrator(beanConvert(passwordChangeDto));

		return true;
	}

	private Administrator beanConvert(
			PasswordChangeDto passwordChangeDto) throws ApplicationException {
		Administrator admin = beanConverter.convert(passwordChangeDto,
				Administrator.class);
		
		String encryptPassword = encryptPassword(passwordChangeDto.getNewAdminPassword());
		admin.setAdminPassword(encryptPassword);

		return admin;
	}
	
	private String encryptPassword(String password) throws ApplicationException {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		return passwordEncoder.encode(password);
	}

}
