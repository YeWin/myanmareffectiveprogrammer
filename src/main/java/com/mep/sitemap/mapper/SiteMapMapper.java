package com.mep.sitemap.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mep.sitemap.dto.SiteMapDto;

@Mapper
public interface SiteMapMapper {

	List<SiteMapDto> getAllArticles();
}
