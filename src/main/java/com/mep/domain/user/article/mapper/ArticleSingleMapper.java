package com.mep.domain.user.article.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mep.domain.user.article.entity.ArticleDashboard;
import com.mep.domain.user.article.entity.ArticleSingle;

@Mapper
public interface ArticleSingleMapper {

	List<ArticleSingle> getArticle(@Param("postTitleEng") String postTitleEng);

	List<ArticleDashboard> getLastSevenArticle(
			@Param("postTitleEng") String postTitleEng);
}
