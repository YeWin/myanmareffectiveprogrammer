package com.mep.domain.admin.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import com.mep.domain.admin.category.dto.CategoryListDto;
import com.mep.domain.admin.category.service.CategoryListService;

@Controller
@RequestScope
@RequestMapping("/admin/*")
public class CategoryListController {

	private static final String INIT_PATH = "admin/category/categoryList";

	@Autowired
	private CategoryListService categoryListService;

	@GetMapping(value = "/category")
	public @ResponseBody ModelAndView categoryList() {

		ModelAndView mav = new ModelAndView(INIT_PATH);

		List<CategoryListDto> categoryList = categoryListService
				.getCategoryList();

		mav.addObject("categoryList", categoryList);

		return mav;
	}
}
