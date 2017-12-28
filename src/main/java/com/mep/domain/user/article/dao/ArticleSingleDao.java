package com.mep.domain.user.article.dao;

import java.util.List;

import com.mep.domain.user.article.entity.ArticleDashboard;
import com.mep.domain.user.article.entity.ArticleSingle;

public interface ArticleSingleDao {

	List<ArticleSingle> getArticle(String postTitleEng);
	
	List<ArticleDashboard> getLastSevenArticle(String postTitleEng);
}
