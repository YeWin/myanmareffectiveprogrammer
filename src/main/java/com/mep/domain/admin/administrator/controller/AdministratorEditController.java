package com.mep.domain.admin.administrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.domain.admin.administrator.service.AdministratorDeleteService;
import com.mep.domain.admin.administrator.service.AdministratorInsertService;
import com.mep.domain.admin.administrator.service.AdministratorUpdateConfirmService;
import com.mep.domain.admin.administrator.service.AdministratorUpdateService;
import com.mep.handler.ApplicationException;
import com.mep.message.MessageHelper;

@Controller
@RequestMapping("/admin/*")
public class AdministratorEditController extends
		AdministratorUpdateControllerHelper {

	private static final String INPUT_PATH = "admin/administrator/administratorInput";

	private static final String INPUT_COMPLETE_PATH = "admin/administrator/administratorInputComplete";

	private static final String UPDATE_PATH = "admin/administrator/administratorUpdate";

	private static final String UPDATE_COMPLETE_PATH = "admin/administrator/administratorUpdateComplete";

	private static final String ADMIN_DTO = "adminDto";

	@Autowired
	private AdministratorInsertService administratorInsertService;

	@Autowired
	private AdministratorDeleteService administratorDeleteService;

	@Autowired
	private AdministratorUpdateService administratorUpdateService;

	@Autowired
	private AdministratorUpdateConfirmService administratorUpdateConfirmService;

	@Autowired
	private MessageHelper messageHelper;

	/* Converts empty strings into null when a form is submitted */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@GetMapping(value = "/administrator/insert")
	public ModelAndView init() {

		ModelAndView mav = new ModelAndView(INPUT_PATH);
		mav.addObject(ADMIN_DTO, new AdministratorDto());
		return mav;
	}

	@PostMapping(value = "/administrator/insertConfirm")
	public @ResponseBody ModelAndView administratorInsert(
			@Validated @ModelAttribute("adminDto") AdministratorDto adminDto,
			BindingResult bindingResult) throws ApplicationException {

		ModelAndView mav = new ModelAndView(INPUT_COMPLETE_PATH);
		mav.addObject(adminDto);

		if (checkInputValueIsInvalid(bindingResult, adminDto, mav)) {
			return mav;
		}

		administratorInsertService.insertAdministrator(adminDto);
		messageHelper.setCompleteMessage(mav, "MSP00001");

		return mav;
	}

	public boolean checkInputValueIsInvalid(BindingResult bindingResult,
			AdministratorDto adminDto, ModelAndView mav) {
		boolean flag = false;
		if (checkBeanValidator(bindingResult, INPUT_PATH, mav)) {
			return true;
		}

		if (checkCustomValidator(administratorInsertService, adminDto,
				INPUT_PATH, mav)) {
			flag = true;
		}

		if (checkCustomEmailDuplicateValidatorForInsert(
				administratorInsertService, adminDto, INPUT_PATH, mav)) {
			flag = true;
		}

		return flag;
	}

	@GetMapping(value = "/administrator/update/{adminId}")
	public ModelAndView administratorUpdate(
			@ModelAttribute("adminId") Integer adminId) {

		ModelAndView mav = new ModelAndView(UPDATE_PATH);

		AdministratorDto adminDto = administratorUpdateService
				.getAdministratorById(adminId);

		mav.addObject(ADMIN_DTO, adminDto);

		return mav;
	}

	@PostMapping(value = "/administrator/updateConfirm")
	public ModelAndView administratorUpdateConfirm(
			@Validated @ModelAttribute("adminDto") AdministratorDto adminDto,
			BindingResult bindingResult) {

		ModelAndView mav = new ModelAndView(UPDATE_COMPLETE_PATH);
		mav.addObject(adminDto);

		if (checkInputUpdateValueIsInvalid(bindingResult, adminDto, mav)) {
			return mav;
		}

		administratorUpdateConfirmService.updateAdministrator(adminDto);

		messageHelper.setCompleteMessage(mav, "MSP00001");

		return mav;
	}

	public boolean checkInputUpdateValueIsInvalid(BindingResult bindingResult,
			AdministratorDto adminDto, ModelAndView mav) {

		if (checkBeanValidator(bindingResult, UPDATE_PATH, mav)) {
			return true;
		}

		if (checkCustomEmailDuplicateValidatorForUpdate(
				administratorUpdateConfirmService, adminDto, UPDATE_PATH, mav)) {
			return true;
		}

		return false;
	}

	@GetMapping(value = "/administrator/delete/{adminId}")
	public String administratorDelete(@PathVariable("adminId") Integer adminId) {

		administratorDeleteService.admnistratorDelete(adminId);

		return "redirect:/admin/";
	}
}
