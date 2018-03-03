package com.mep.domain.user.article.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mep.domain.user.article.dto.ArticleDashboardDto;
import com.mep.domain.user.article.service.ArticleDashboradService;
import com.mep.util.Constant;

@Controller
public class ArticleDashboardController {

	private static final String ARTICLE_PATH = "user/article/articleDashboard";
	
	private static final String TUTORIAL_PATH = "user/article/tutorialDashboard";

	private String searchValue;
	
	@Value("${analytics.enable}")
	private String analyticsStatus;
	
	@Autowired
	private ArticleDashboradService dashboradService;

	@GetMapping(value = { "/searchArticle" })
	public @ResponseBody ModelAndView searchArticle(
			@RequestParam(name = "searchValue") String searchValue)
			{

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);

		List<ArticleDashboardDto> articleDashboardList = dashboradService
				.searchArticleList(searchValue);

		mav.addObject("articleDashboardList", articleDashboardList);
		mav.addObject("pageTitle", "You searched for " + searchValue);

		return mav;
	}

	@GetMapping(value = { "/", "/articles" })
	public @ResponseBody ModelAndView getArticles() {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);
		
		mav.addObject("articleDashboardList", getDashboardData(Constant.MENU[0]));
		
		mav.addObject("pageTitle", Constant.MENU[0]);

		return mav;
	}

	@GetMapping(value = { "/professional-programmer" })
	public @ResponseBody ModelAndView getProfessionalProgrammer()
			throws Exception {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);
		
		mav.addObject("articleDashboardList", getDashboardData(Constant.MENU[1]));
		
		mav.addObject("pageTitle", Constant.MENU[1]);

		return mav;
	}
	
	@GetMapping(value = { "/test-driven-development" })
	public @ResponseBody ModelAndView getTestDrivenDevelopment()
			throws Exception {

		ModelAndView mav = new ModelAndView(TUTORIAL_PATH);
		
		mav.addObject("articleDashboardList", reverseListValue(Constant.MENU[2]));
		
		mav.addObject("tutorialTitle", Constant.MENU[2]);
		mav.addObject("pageTitle", Constant.MENU[2]);

		return mav;
	}
	
	@GetMapping(value = { "/effective-java" })
	public @ResponseBody ModelAndView getEffectiveJava()
			throws Exception {

		ModelAndView mav = new ModelAndView(TUTORIAL_PATH);
		
		mav.addObject("articleDashboardList", reverseListValue(Constant.MENU[3]));
		
		mav.addObject("tutorialTitle", Constant.MENU[3]);
		mav.addObject("pageTitle", Constant.MENU[3]);

		return mav;
	}
	
	@GetMapping(value = { "/java7" })
	public @ResponseBody ModelAndView getJava7()
			throws Exception {

		ModelAndView mav = new ModelAndView(TUTORIAL_PATH);
		
		mav.addObject("articleDashboardList", reverseListValue(Constant.MENU[4]));
		
		mav.addObject("tutorialTitle", Constant.MENU[4]);
		mav.addObject("pageTitle", Constant.MENU[4]);

		return mav;
	}
	
	@GetMapping(value = { "/about-us" })
	public @ResponseBody ModelAndView getAboutUs()
			throws Exception {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);
		
		mav.addObject("articleDashboardList", getDashboardData(Constant.MENU[5]));
		
		mav.addObject("pageTitle", Constant.MENU[5]);

		return mav;
	}
	
	private List<ArticleDashboardDto> reverseListValue(String path) {
		
		List<ArticleDashboardDto> articleDashboardList = getDashboardData(path);		
		Collections.reverse(articleDashboardList);
		
		return articleDashboardList;		
	}
	
	private List<ArticleDashboardDto> getDashboardData(String category) {
		
		List<ArticleDashboardDto> articleDashboardList = dashboradService
				.getArticleDashboardList(category);
		
		return articleDashboardList;
	}	

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	@ModelAttribute("analyticsStatus")
	public String getAnalyticsStatus() {
		return analyticsStatus;
	}

	public void setAnalyticsStatus(String analyticsStatus) {
		this.analyticsStatus = analyticsStatus;
	}	
}
