package com.mep.domain.admin.administrator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import com.mep.domain.admin.administrator.dto.AdministratorListDto;
import com.mep.domain.admin.administrator.service.AdministratorListService;

@Controller
@RequestScope
@RequestMapping("/admin/*")
public class AdministratorListController {

	private static final String INIT_PATH = "admin/administrator/administratorList";

	@Autowired
	private AdministratorListService administratorListService;

	@GetMapping(value = "/")
	public @ResponseBody ModelAndView categoryList() {

		ModelAndView mav = new ModelAndView(INIT_PATH);

		List<AdministratorListDto> adminList = administratorListService
				.getAdministratorList();

		mav.addObject("adminList", adminList);

		return mav;
	}
}
