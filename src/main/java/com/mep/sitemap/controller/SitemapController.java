package com.mep.sitemap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mep.sitemap.dto.SiteMapDto;
import com.mep.sitemap.service.SiteMapService;
import com.mep.util.Constant;
import com.mep.util.DateUtil;
import com.mep.util.StringUtil;

@Controller
public class SitemapController {

	@Value("${blog.url}")
	private String blogUrl;

	@Autowired
	private SiteMapService siteMapService;

	@RequestMapping(value = "/sitemap.xml", method = RequestMethod.GET)
	@ResponseBody
	public XmlUrlSet main() {
		XmlUrlSet xmlUrlSet = new XmlUrlSet();
		create(xmlUrlSet, "", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/professional-programmer", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/articles", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/test-driven-development", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/effective-java", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/java7", XmlUrl.Priority.HIGH);
		create(xmlUrlSet, "/about-us", XmlUrl.Priority.HIGH);

		List<SiteMapDto> siteMapDtoList = getDashboardData(Constant.MENU[0]);

		for (int i = 0; i < siteMapDtoList.size(); i++) {

			create(xmlUrlSet, prepareCompleteLink(siteMapDtoList, i),
					XmlUrl.Priority.MEDIUM);
		}

		return xmlUrlSet;
	}

	private List<SiteMapDto> getDashboardData(String category) {

		List<SiteMapDto> siteMapDtoList = siteMapService.getAllArticles();

		return siteMapDtoList;
	}

	private String prepareCompleteLink(List<SiteMapDto> siteMapDtoList,
			int index) {
		String createdDate = DateUtil.changeDateFormat(siteMapDtoList
				.get(index).getCreatedDate(), "yyyy-MM-dd");
		String postTitle = StringUtil.replaceWhiteSpaceWithHyphen(
				siteMapDtoList.get(index).getPostTitleEng()).toLowerCase();
		String completeLink = "/" + createdDate + "/" + postTitle;

		return completeLink;
	}

	private void create(XmlUrlSet xmlUrlSet, String link,
			XmlUrl.Priority priority) {
		xmlUrlSet.addUrl(new XmlUrl(blogUrl + link, priority));
	}

	@ModelAttribute("blogUrl")
	public String getBlogUrl() {
		return blogUrl;
	}

}
