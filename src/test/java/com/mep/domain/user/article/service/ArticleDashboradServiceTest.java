package com.mep.domain.user.article.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.user.article.dto.ArticleDashboardDto;
import com.mep.util.TestAbstract;

public class ArticleDashboradServiceTest extends TestAbstract {

	@Autowired
	private ArticleDashboradService articleDashboradService;

	@Test
	public void shouldReturnArticleDashboardList() {

		List<ArticleDashboardDto> articleDashboardDto = articleDashboradService
				.getArticleDashboardList("Java Best Practice");
		assertThat(articleDashboardDto, notNullValue());
		assertThat(articleDashboardDto.size(),
				anyOf(greaterThan(-1), is(not(0))));
	}
	
	@Test
	public void shouldReturnSearchArticle() {

		List<ArticleDashboardDto> articleDashboardDto = articleDashboradService
				.searchArticleList("What");
		assertThat(articleDashboardDto, notNullValue());
		assertThat(articleDashboardDto.size(),
				anyOf(greaterThan(-1), is(not(0))));
	}
	
	@Test
	public void shouldReturnSevenArticle1() {

		List<ArticleDashboardDto> articleDashboardDto = articleDashboradService
				.searchArticleList("12");
		assertThat(articleDashboardDto, notNullValue());
		assertThat(articleDashboardDto.size(),
				anyOf(greaterThan(-1), is((7))));
	}
	
	@Test
	public void shouldReturnSevenArticle2() {

		List<ArticleDashboardDto> articleDashboardDto = articleDashboradService
				.searchArticleList("");
		assertThat(articleDashboardDto, notNullValue());
		assertThat(articleDashboardDto.size(),
				anyOf(greaterThan(-1), is((7))));
	}
	
	@Test
	public void shouldReturnSevenArticle3() {

		List<ArticleDashboardDto> articleDashboardDto = articleDashboradService
				.searchArticleList("လမ္းညြန္");
		assertThat(articleDashboardDto, notNullValue());
		assertThat(articleDashboardDto.size(),
				anyOf(greaterThan(-1), is((7))));
	}

}
