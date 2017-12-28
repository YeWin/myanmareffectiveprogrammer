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
import com.mep.domain.user.article.entity.ArticleSingle;
import com.mep.util.TestAbstract;

public class ArticleSingleDaoTest extends TestAbstract {

	@Autowired
	private ArticleSingleDao articleSingleDao;

	@Test
	public void shouldReturnArticle() {
		List<ArticleSingle> articleSingle = articleSingleDao
				.getArticle("What kind of developer are you?");

		assertThat(articleSingle, notNullValue());
		assertThat(articleSingle.size(), anyOf(greaterThan(-1), is(not(0))));
	}

	@Test
	public void shouldReturnLastSevenArticle() {
		List<ArticleDashboard> articleDashboardList = articleSingleDao
				.getLastSevenArticle("Programmer Guide");

		assertThat(articleDashboardList, notNullValue());
		assertThat(articleDashboardList.size(),
				anyOf(greaterThan(-1), is(not(0))));
	}

}
