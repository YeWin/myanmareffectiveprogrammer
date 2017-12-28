package com.mep.domain.user.article.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.user.article.entity.ArticleDashboard;
import com.mep.util.TestAbstract;

public class ArticleDashboardDaoTest extends TestAbstract {

	@Autowired
	private ArticleDashboardDao articleDashboardDao;

	@Test
	public void shouldReturnArticleDashboardList() {
		List<ArticleDashboard> articleDashboardList = articleDashboardDao
				.getArticleDashboardList("Java Best Practice");
		
		assertThat(articleDashboardList, notNullValue());
		assertThat(articleDashboardList.size(),
				anyOf(greaterThan(-1), is(not(0))));
	}
	
	@Test
	public void shouldReturnSearchArticle() {
		List<ArticleDashboard> articleSearchList = articleDashboardDao
				.searchArticleList("what");
		
		assertThat(articleSearchList, notNullValue());
		assertThat(articleSearchList.size(),
				anyOf(greaterThan(-1), is(not(0))));
	}

}
