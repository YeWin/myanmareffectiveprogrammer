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
import com.mep.domain.user.article.dto.ArticleSingleDto;
import com.mep.util.TestAbstract;

public class ArticleSingleServiceTest extends TestAbstract {

	@Autowired
	private ArticleSingleService articleSingleService;

	@Test
	public void shouldReturnArticle() {

		List<ArticleSingleDto> articleSingleDto = articleSingleService
				.getArticle("What kind of developer are you?");
		assertThat(articleSingleDto, notNullValue());
		assertThat(articleSingleDto.size(), anyOf(greaterThan(-1), is(not(0))));
	}

	@Test
	public void shouldReturnLastSevenArticle() {

		List<ArticleDashboardDto> articleDashboardDto = articleSingleService
				.getLastSevenArticle("Programmer Guide");

		assertThat(articleDashboardDto, notNullValue());
		assertThat(articleDashboardDto.size(),
				anyOf(greaterThan(-1), is(not(0))));
	}

}
