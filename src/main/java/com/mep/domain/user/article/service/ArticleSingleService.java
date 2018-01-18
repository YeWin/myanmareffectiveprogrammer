package com.mep.domain.user.article.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.mep.domain.user.article.dto.ArticleDashboardDto;
import com.mep.domain.user.article.dto.ArticleSingleDto;
import com.mep.domain.user.article.dto.GoogleAnalyticsDto;

public interface ArticleSingleService {

	List<ArticleSingleDto> getArticle(String postTitleEng);

	List<ArticleDashboardDto> getLastSevenArticle(String postTitleEng);
	
	List<GoogleAnalyticsDto> getGoogleAnalyticsData() throws GeneralSecurityException, IOException;
}
