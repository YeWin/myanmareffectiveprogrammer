package com.mep.domain.user.article.dao;

import java.util.List;

import com.mep.domain.user.article.entity.ArticleDashboard;

public interface ArticleDashboardDao {

	List<ArticleDashboard> getArticleDashboardList(String categoryName);
	
	List<ArticleDashboard> searchArticleList(String postTitleEng);
}
