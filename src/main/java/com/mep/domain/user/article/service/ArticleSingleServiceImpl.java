package com.mep.domain.user.article.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.domain.user.article.dao.ArticleSingleDao;
import com.mep.domain.user.article.dto.ArticleDashboardDto;
import com.mep.domain.user.article.dto.ArticleSingleDto;
import com.mep.domain.user.article.entity.ArticleDashboard;
import com.mep.domain.user.article.entity.ArticleSingle;
import com.mep.util.StringUtil;

@Service
public class ArticleSingleServiceImpl implements ArticleSingleService {

	@Autowired
	private ArticleSingleDao articleSingleDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ArticleSingleDto> getArticle(String postTitleEng) {
		List<ArticleSingle> articleSingleList = articleSingleDao
				.getArticle(postTitleEng);

		return getDtoList(articleSingleList);
	}

	private List<ArticleSingleDto> getDtoList(List<ArticleSingle> singleList) {
		List<ArticleSingleDto> singleDtoList = new ArrayList<>();

		for (ArticleSingle single : singleList) {
			ArticleSingleDto dto = new ArticleSingleDto();

			dto.setAboutAdmin(single.getAboutAdmin());
			dto.setAdminImageUrl(single.getAdminImageUrl());
			dto.setAdminName(single.getAdminName());
			dto.setContentType(single.getContentType());
			dto.setCreatedDate(single.getCreatedDate());
			dto.setPostContent(single.getPostContent());
			dto.setPostTitle(single.getPostTitle());
			dto.setPostTitleImgUrl(single.getPostTitleImgUrl());

			singleDtoList.add(dto);
		}

		return singleDtoList;
	}

	@Override
	public List<ArticleDashboardDto> getLastSevenArticle(String postTitleEng) {
		List<ArticleDashboard> lastSevenList = articleSingleDao
				.getLastSevenArticle(postTitleEng);

		return getDashboardDtoList(lastSevenList);
	}

	private List<ArticleDashboardDto> getDashboardDtoList(
			List<ArticleDashboard> lastSevenList) {
		List<ArticleDashboardDto> dashboardDtoList = new ArrayList<>();

		for (ArticleDashboard dashboard : lastSevenList) {
			ArticleDashboardDto dto = new ArticleDashboardDto();

			dto.setAdminName(dashboard.getAdminName());
			dto.setCreatedDate(dashboard.getCreatedDate());
			dto.setPostId(dashboard.getPostId());
			dto.setPostTitle(dashboard.getPostTitle());
			dto.setPostTitleEng(StringUtil.replaceWhiteSpaceWithHyphen(
					dashboard.getPostTitleEng()).toLowerCase());
			dto.setPostTitleImgUrl(dashboard.getPostTitleImgUrl());

			dashboardDtoList.add(dto);
		}

		return dashboardDtoList;
	}

}
