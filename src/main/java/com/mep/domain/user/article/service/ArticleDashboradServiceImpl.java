package com.mep.domain.user.article.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.domain.user.article.dao.ArticleDashboardDao;
import com.mep.domain.user.article.dto.ArticleDashboardDto;
import com.mep.domain.user.article.entity.ArticleDashboard;
import com.mep.util.StringUtil;

@Service
public class ArticleDashboradServiceImpl implements ArticleDashboradService {

	@Autowired
	private ArticleDashboardDao articleDashboardDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ArticleDashboardDto> getArticleDashboardList(String categoryName)
			{

		List<ArticleDashboard> dashboardList = articleDashboardDao
				.getArticleDashboardList(categoryName);

		return getDtoList(dashboardList);
	}

	private List<ArticleDashboardDto> getDtoList(
			List<ArticleDashboard> dashboardList) {
		List<ArticleDashboardDto> dashboardDtoList = new ArrayList<>();

		for (ArticleDashboard dashboard : dashboardList) {
			ArticleDashboardDto dto = new ArticleDashboardDto();
					
			dto.setAdminName(dashboard.getAdminName());
			dto.setCreatedDate(dashboard.getCreatedDate());
			dto.setPostId(dashboard.getPostId());
			dto.setPostTitle(dashboard.getPostTitle());
			dto.setPostTitleEng(StringUtil.replaceWhiteSpaceWithHyphen(dashboard
					.getPostTitleEng()).toLowerCase());
			dto.setPostTitleImgUrl(dashboard.getPostTitleImgUrl());
			dto.setContentType(dashboard.getContentType());
			
			dashboardDtoList.add(dto);
		}

		return dashboardDtoList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ArticleDashboardDto> searchArticleList(String searchValue)
			{
		List<ArticleDashboard> searchList = articleDashboardDao
				.searchArticleList(checkSearchInputLangauge(searchValue));
		
		if(!(searchList.size() > 0)) {
			searchList = getLastSevenArticles(searchList);
		}
		
		return getDtoList(searchList);
	}
	
	private String checkSearchInputLangauge(String searchValue) {
		
		if (!StringUtil.validateInputLanguage(searchValue)) {
			searchValue = "";
		}
		
		return searchValue;
	}
	
	private List<ArticleDashboard> getLastSevenArticles(List<ArticleDashboard> searchList) {
		
		return articleDashboardDao
				.searchArticleList(checkSearchInputLangauge(""));
	}

}
