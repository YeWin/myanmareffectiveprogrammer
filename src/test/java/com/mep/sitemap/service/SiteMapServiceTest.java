package com.mep.sitemap.service;

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

public class SiteMapServiceTest extends TestAbstract {

	@Autowired
	private SiteMapService siteMapService;

	@Test
	public void shouldReturnSiteMapList() {

		List<SiteMapDto> siteMapDtoList = siteMapService.getAllArticles();
		
		assertThat(siteMapDtoList, notNullValue());
		assertThat(siteMapDtoList.size(),
				anyOf(greaterThan(-1), is(not(0))));
	}

}
