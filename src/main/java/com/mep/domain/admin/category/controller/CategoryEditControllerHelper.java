package com.mep.domain.admin.category.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public abstract class CategoryEditControllerHelper {

	protected boolean checkBeanValidator(BindingResult bindingResult,
			String path, ModelAndView mav) {

		if (bindingResult.hasErrors()) {
			mav.setViewName(path);
			return true;
		}

		return false;
	}
}
