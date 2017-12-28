package com.mep.domain.user.article.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.domain.user.article.entity.ArticleDashboard;
import com.mep.domain.user.article.mapper.ArticleDashboardMapper;

@Repository
public class ArticleDashboardDaoImpl implements ArticleDashboardDao {

	@Autowired
	private ArticleDashboardMapper articleDashboardMapper;
	
	@Override
	public List<ArticleDashboard> getArticleDashboardList(String categoryName) {
		return articleDashboardMapper.getArticleDashboardList(categoryName);
	}

	@Override
	public List<ArticleDashboard> searchArticleList(String postTitleEng) {
		return articleDashboardMapper.searchArticleList(postTitleEng);
	}

}
