package com.mep.sitemap.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.sitemap.dto.SiteMapDto;
import com.mep.util.TestAbstract;

public class SiteMapDaoTest extends TestAbstract {

	@Autowired
	private SiteMapDao siteMapDao;

	@Test
	public void shouldReturnSiteMapList() {
		List<SiteMapDto> siteMapDtoList = siteMapDao.getAllArticles();
		
		assertThat(siteMapDtoList, notNullValue());
		assertThat(siteMapDtoList.size(),
				anyOf(greaterThan(-1), is(not(0))));
	}

}
