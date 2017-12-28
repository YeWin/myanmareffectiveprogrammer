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
import com.mep.domain.admin.administrator.dao.AdministratorInsertDao;
import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.handler.ApplicationException;
import com.mep.message.DisplayMessage;
import com.mep.message.ResultMessages;
import com.mep.util.DateUtil;
import com.mep.util.StringUtil;

@Service
public class AdministratorInsertServiceImpl implements
		AdministratorInsertService {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	AdministratorInsertDao administratorInsertDao;

	@Override	
	public ResultMessages validate(AdministratorDto adminDto) {

		ResultMessages resultMessages = new ResultMessages();
		Locale locale = LocaleContextHolder.getLocale();

		if (checkPasswordIsEmpty(resultMessages, adminDto.getAdminPassword(),
				locale)) {
			return resultMessages;
		}

		checkPasswordComplexity(resultMessages, adminDto.getAdminPassword(),
				locale);

		checkPasswordAndConfirmPasswordIsNotEqual(resultMessages,
				adminDto.getAdminPassword(),
				adminDto.getAdminConfirmPassword(), locale);

		return resultMessages;
	}

	private boolean checkPasswordIsEmpty(ResultMessages resultMessages,
			String password, Locale locale) {

		if (StringUtils.isEmpty(password)) {
			resultMessages.addError(new DisplayMessage(
					messageSource.getMessage("NotBlank",
							new Object[] { "Password" }, locale)));

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
	public ResultMessages validateEmailDuplicate(AdministratorDto adminDto) {
		ResultMessages resultMessages = new ResultMessages();
		Locale locale = LocaleContextHolder.getLocale();

		checkEmailIsDuplicateOrNot(resultMessages, adminDto, locale);

		return resultMessages;
	}

	private void checkEmailIsDuplicateOrNot(ResultMessages resultMessages,
			AdministratorDto adminDto, Locale locale) {

		long count = administratorInsertDao.selectAdministratorByEmail(adminDto
				.getAdminEmail());

		if (count > 0) {
			resultMessages.addError(new DisplayMessage(messageSource
					.getMessage("MEP00004", new Object[] { "Email Address" },
							locale)));
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean insertAdministrator(AdministratorDto adminDto)
			throws ApplicationException {

		administratorInsertDao
				.insertAdministrator(setDtoModelToEntityModel(adminDto));

		return true;
	}

	private Administrator setDtoModelToEntityModel(AdministratorDto adminDto)
			throws ApplicationException {
		Administrator admin = new Administrator();

		String encryptPassword = encryptPassword(adminDto.getAdminPassword());

		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminEmail(adminDto.getAdminEmail());
		admin.setAdminPassword(encryptPassword);
		admin.setAdminImageUrl(adminDto.getAdminImageUrl());
		admin.setAboutAdmin(adminDto.getAboutAdmin());
		admin.setCreatedDate(DateUtil.getCurrentTime());

		return admin;
	}

	private String encryptPassword(String password) throws ApplicationException {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		return passwordEncoder.encode(password);
	}

}
