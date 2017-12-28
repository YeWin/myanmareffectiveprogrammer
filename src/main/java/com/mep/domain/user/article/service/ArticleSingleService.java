package com.mep.domain.user.article.service;

import java.util.List;

import com.mep.domain.user.article.dto.ArticleDashboardDto;
import com.mep.domain.user.article.dto.ArticleSingleDto;

public interface ArticleSingleService {

	List<ArticleSingleDto> getArticle(String postTitleEng);

	List<ArticleDashboardDto> getLastSevenArticle(String postTitleEng);
}
