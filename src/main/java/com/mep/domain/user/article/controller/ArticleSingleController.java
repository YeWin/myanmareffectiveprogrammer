package com.mep.domain.user.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mep.domain.user.archive.dto.ArchiveYearListDto;
import com.mep.domain.user.archive.service.ArchiveListService;
import com.mep.domain.user.article.dto.ArticleDashboardDto;
import com.mep.domain.user.article.dto.ArticleSingleDto;
import com.mep.domain.user.article.service.ArticleSingleService;
import com.mep.util.StringUtil;

@Controller
public class ArticleSingleController {

	private static final String ARTICLE_PATH = "user/article/articleDetails";

	@Autowired
	private ArticleSingleService singleService;

	@Autowired
	private ArchiveListService archiveListService;

	@GetMapping(value = { "/{createdDate}/{postTitleEng}" })
	public @ResponseBody ModelAndView getSinglePost(
			@ModelAttribute("postTitleEng") String postTitleEng) {

		ModelAndView mav = new ModelAndView(ARTICLE_PATH);

		List<ArticleSingleDto> articleSingleDto = singleService
				.getArticle(StringUtil
						.replaceHyphenWithWhiteSpace(postTitleEng));

		List<ArticleDashboardDto> lastSevenList = singleService
				.getLastSevenArticle(StringUtil
						.replaceHyphenWithWhiteSpace(postTitleEng));		

		mav.addObject("articleDashboardList", lastSevenList);

		mav.addObject("articleSingleDto", articleSingleDto);
		
		List<ArchiveYearListDto> archiveList = archiveListService.getArchiveList();
		
		mav.addObject("archiveList", archiveList);

		return mav;
	}
}
