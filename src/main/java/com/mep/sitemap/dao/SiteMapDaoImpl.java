package com.mep.sitemap.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.sitemap.dto.SiteMapDto;
import com.mep.sitemap.mapper.SiteMapMapper;

@Repository
public class SiteMapDaoImpl implements SiteMapDao {

	@Autowired
	SiteMapMapper siteMapMapper;

	@Override
	public List<SiteMapDto> getAllArticles() {
		return siteMapMapper.getAllArticles();
	}

}
