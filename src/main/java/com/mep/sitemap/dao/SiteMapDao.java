package com.mep.sitemap.dao;

import java.util.List;

import com.mep.sitemap.dto.SiteMapDto;

public interface SiteMapDao {

	List<SiteMapDto> getAllArticles();
}
