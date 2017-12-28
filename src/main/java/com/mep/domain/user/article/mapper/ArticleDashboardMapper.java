package com.mep.domain.user.article.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mep.domain.user.article.entity.ArticleDashboard;

@Mapper
public interface ArticleDashboardMapper {

	List<ArticleDashboard> getArticleDashboardList(
			@Param("categoryName") String categoryName);	
	
	List<ArticleDashboard> searchArticleList(
			@Param("postTitleEng") String postTitleEng);
}
