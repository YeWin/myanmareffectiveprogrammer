package com.mep.domain.admin.administrator.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import com.mep.database.entity.Administrator;
import com.mep.domain.admin.administrator.dao.AdministratorUpdateConfirmDao;
import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.message.DisplayMessage;
import com.mep.message.ResultMessages;
import com.mep.util.DateUtil;

@Service
public class AdministratorUpdateConfirmServiceImpl implements
		AdministratorUpdateConfirmService {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	AdministratorUpdateConfirmDao administratorUpdateConfirmDao;

	@Override
	public ResultMessages validateEmailDuplicate(AdministratorDto adminDto) {
		ResultMessages resultMessages = new ResultMessages();
		Locale locale = LocaleContextHolder.getLocale();

		if (checkNewAdminEmailIsShouldUpdate(adminDto)) {

			checkEmailIsDuplicateOrNot(resultMessages, adminDto, locale);
		}

		return resultMessages;
	}

	private boolean checkNewAdminEmailIsShouldUpdate(AdministratorDto adminDto) {

		if (!checkNewEmailIsEmpty(adminDto.getAdminNewEmail())) {
			if (!adminDto.getAdminEmail().equalsIgnoreCase(
					adminDto.getAdminNewEmail())) {

				return true;
			}
		}

		return false;
	}

	private boolean checkNewEmailIsEmpty(String newEmail) {

		if (StringUtils.isEmpty(newEmail)) {
			return true;
		}
		return false;
	}

	private void checkEmailIsDuplicateOrNot(ResultMessages resultMessages,
			AdministratorDto adminDto, Locale locale) {

		long count = administratorUpdateConfirmDao
				.selectAdministratorByEmail(adminDto.getAdminNewEmail());

		if (count > 0) {
			resultMessages.addError(new DisplayMessage(messageSource
					.getMessage("MEP00004", new Object[] { "Email Address" },
							locale)));
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateAdministrator(AdministratorDto adminDto) {

		administratorUpdateConfirmDao
				.updateAdministrator(setDtoModelToEntityModel(adminDto));

		return true;
	}

	private Administrator setDtoModelToEntityModel(AdministratorDto adminDto) {
		Administrator admin = new Administrator();

		if (checkNewEmailIsEmpty(adminDto.getAdminNewEmail())) {
			admin.setAdminEmail(adminDto.getAdminEmail());
		} else {
			admin.setAdminEmail(adminDto.getAdminNewEmail());
		}

		admin.setAdminId(adminDto.getAdminId());
		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminImageUrl(adminDto.getAdminImageUrl());
		admin.setAboutAdmin(adminDto.getAboutAdmin());
		admin.setUpdatedDate(DateUtil.getCurrentTime());

		return admin;
	}

}
