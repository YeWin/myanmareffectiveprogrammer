package com.mep.domain.user.article.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mep.domain.user.article.dto.ArticleDashboardDto;
import com.mep.domain.user.article.service.ArticleDashboradService;
import com.mep.util.Constant;

@Controller
public class ArticleDashboardController {

	private static final String ARTICLE_PATH = "user/article/articleDashboard";

	private String searchValue;
	
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

		return mav;
	}

	@GetMapping(value = { "/", "/articles" })
	public @ResponseBody ModelAndView getArticles() {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);
		
		mav.addObject("articleDashboardList", getDashboardData(Constant.MENU[0]));

		return mav;
	}

	@GetMapping(value = { "/professional-programmer" })
	public @ResponseBody ModelAndView getProfessionalProgrammer()
			throws Exception {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);
		
		mav.addObject("articleDashboardList", getDashboardData(Constant.MENU[1]));

		return mav;
	}
	
	@GetMapping(value = { "/test-driven-development" })
	public @ResponseBody ModelAndView getTestDrivenDevelopment()
			throws Exception {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);
		
		mav.addObject("articleDashboardList", getDashboardData(Constant.MENU[2]));

		return mav;
	}
	
	@GetMapping(value = { "/effective-java" })
	public @ResponseBody ModelAndView getEffectiveJava()
			throws Exception {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);
		
		mav.addObject("articleDashboardList", getDashboardData(Constant.MENU[3]));

		return mav;
	}
	
	@GetMapping(value = { "/java7" })
	public @ResponseBody ModelAndView getJava7()
			throws Exception {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);
		
		mav.addObject("articleDashboardList", getDashboardData(Constant.MENU[4]));

		return mav;
	}
	
	@GetMapping(value = { "/about-us" })
	public @ResponseBody ModelAndView getAboutUs()
			throws Exception {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);
		
		mav.addObject("articleDashboardList", getDashboardData(Constant.MENU[5]));

		return mav;
	}
	
	@GetMapping(value = { "/contact-us" })
	public @ResponseBody ModelAndView getContactUs()
			throws Exception {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);
		
		mav.addObject("articleDashboardList", getDashboardData(Constant.MENU[6]));

		return mav;
	}
	
	@GetMapping(value = { "/write-for-us" })
	public @ResponseBody ModelAndView getWriteForUs()
			throws Exception {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);
		
		mav.addObject("articleDashboardList", getDashboardData(Constant.MENU[7]));

		return mav;
	}
	
	private List<List<ArticleDashboardDto>> getDashboardData(String category) {
		
		/*List<ArticleDashboardDto> articleDashboardList = dashboradService
				.getArticleDashboardList(category);*/
		
		
		// Trick for iterate 3 time per one row.
		List<ArticleDashboardDto> excursions = dashboradService
				.getArticleDashboardList(category);
	    List<List<ArticleDashboardDto>> articleDashboardList = new LinkedList<List<ArticleDashboardDto>>();
	    List<ArticleDashboardDto> tempList = new LinkedList<ArticleDashboardDto>();

	    int listSize = excursions.size();
	    for ( int i = 0; i < listSize; i++ )
	    {
	        tempList.add( excursions.get( i ) );
	        if ( listSize == ( i+1 ) || tempList.size() == 3 )
	        {
	        	articleDashboardList.add( tempList );
	            tempList = new LinkedList<ArticleDashboardDto>();
	        }
	    }	   

		return articleDashboardList;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
}
