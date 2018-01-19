package com.mep.sitemap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mep.sitemap.dao.SiteMapDao;
import com.mep.sitemap.dto.SiteMapDto;

@Service
public class SiteMapServiceImpl implements SiteMapService {
	
	@Autowired
	private SiteMapDao siteMapDao;

	@Override
	public List<SiteMapDto> getAllArticles() {
		return siteMapDao.getAllArticles();
	}
}
