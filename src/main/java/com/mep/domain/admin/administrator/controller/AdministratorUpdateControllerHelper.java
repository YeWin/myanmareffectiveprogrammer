package com.mep.domain.admin.administrator.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.domain.admin.administrator.service.AdministratorInsertService;
import com.mep.domain.admin.administrator.service.AdministratorUpdateConfirmService;
import com.mep.message.ResultMessages;

public abstract class AdministratorUpdateControllerHelper {

	protected boolean checkBeanValidator(BindingResult bindingResult,
			String path, ModelAndView mav) {

		if (bindingResult.hasErrors()) {
			mav.setViewName(path);
			return true;
		}

		return false;
	}

	protected boolean checkCustomValidator(
			AdministratorInsertService administratorInsertService,
			AdministratorDto adminDto, String path, ModelAndView mav) {

		ResultMessages resultMessages = administratorInsertService
				.validate(adminDto);

		if (!resultMessages.getErrorList().isEmpty()) {
			mav.addObject("resultMessages", resultMessages);
			mav.setViewName(path);
			return true;
		}

		return false;
	}

	protected boolean checkCustomEmailDuplicateValidatorForInsert(
			AdministratorInsertService administratorInsertService,
			AdministratorDto adminDto, String path, ModelAndView mav) {

		ResultMessages resultMessages = administratorInsertService.validateEmailDuplicate(adminDto);
		
		if (!resultMessages.getErrorList().isEmpty()) {
			mav.addObject("resultMessages", resultMessages);
			mav.setViewName(path);
			return true;
		}
		
		return false;
	}
	
	protected boolean checkCustomEmailDuplicateValidatorForUpdate(
			AdministratorUpdateConfirmService administratorUpdateConfirmService,
			AdministratorDto adminDto, String path, ModelAndView mav) {

		ResultMessages resultMessages = administratorUpdateConfirmService.validateEmailDuplicate(adminDto);
		
		if (!resultMessages.getErrorList().isEmpty()) {
			mav.addObject("resultMessages", resultMessages);
			mav.setViewName(path);
			return true;
		}
		
		return false;
	}
}
