package com.mep.domain.user.article.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mep.domain.user.archive.dto.ArchiveYearListDto;
import com.mep.domain.user.archive.service.ArchiveListService;
import com.mep.domain.user.article.dto.ArticleDashboardDto;
import com.mep.domain.user.article.dto.ArticleSingleDto;
import com.mep.domain.user.article.dto.GoogleAnalyticsDto;
import com.mep.domain.user.article.service.ArticleSingleService;
import com.mep.util.StringUtil;

@Controller
public class ArticleSingleController {

	private static final String ARTICLE_PATH = "user/article/articleDetails";

	@Autowired
	private ArticleSingleService singleService;

	@Autowired
	private ArchiveListService archiveListService;

	@Value("${analytics.enable}")
	private String analyticsStatus;

	@Value("${blog.url}")
	private String blogUrl;

	@GetMapping(value = { "/{createdDate}/{postTitleEng}" })
	public @ResponseBody ModelAndView getSinglePost(
			@ModelAttribute("createdDate") String createdDate,
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

		List<ArchiveYearListDto> archiveList = archiveListService
				.getArchiveList();

		mav.addObject("archiveList", archiveList);
		if (!articleSingleDto.isEmpty()) {
			mav.addObject("pageTitle", articleSingleDto.get(0).getPostTitle());
		} else {
			mav.addObject("pageTitle", "No Data!");
		}
		mav.addObject("googleAnalyticsDto", getTopPageViews());

		return mav;
	}

	public List<GoogleAnalyticsDto> getTopPageViews() {
		try {
			System.out.print("List Size 0= ");
			List<GoogleAnalyticsDto> analyticsList =  singleService.getGoogleAnalyticsData();
			System.out.print("List Size = " + analyticsList.size());
			return analyticsList;
		} catch (GeneralSecurityException | IOException e) {
			return Collections.emptyList();
		}		
	}

	@ModelAttribute("blogUrl")
	public String getBlogUrl() {
		return blogUrl;
	}

	public void setBlogUrl(String blogUrl) {
		this.blogUrl = blogUrl;
	}

	@ModelAttribute("analyticsStatus")
	public String getAnalyticsStatus() {
		return analyticsStatus;
	}

	public void setAnalyticsStatus(String analyticsStatus) {
		this.analyticsStatus = analyticsStatus;
	}
}
