package com.mep.domain.admin.post.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mep.domain.admin.post.dto.ArticleDropdownDto;
import com.mep.domain.admin.post.dto.CategoryDropdownDto;
import com.mep.domain.admin.post.dto.PostDto;
import com.mep.domain.admin.post.service.PostInitService;
import com.mep.domain.login.dto.SessionLoginAdminDto;
import com.mep.util.Constant;

public abstract class PostControllerHelper {

	protected PostDto setCategoryDropdownToPostDtoObject(
			PostInitService postInitService, PostDto postDto) {

		List<CategoryDropdownDto> categoryDropdownDto = postInitService
				.getCategoryDropdown();

		postDto.setCategoryDropdown(categoryDropdownDto);

		return postDto;

	}

	protected PostDto setArticleDropdownToPostDtoObject(
			PostInitService postInitService, PostDto postDto) {

		postDto.setArticleDropdownDto(getArticleTypeList());

		return postDto;

	}

	private List<ArticleDropdownDto> getArticleTypeList() {
		List<ArticleDropdownDto> articleTypeList = new ArrayList<>();

		for (int i = 0; i < 2; i++) {
			ArticleDropdownDto dto = new ArticleDropdownDto();

			dto.setContentType(i);

			if (i == 0) {
				dto.setContentTypeName("Article");
			} else {
				dto.setContentTypeName("Tutorial");
			}

			articleTypeList.add(dto);
		}

		return articleTypeList;
	}

	protected Integer getAdminIdFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		SessionLoginAdminDto sessionDto = (SessionLoginAdminDto) session
				.getAttribute(Constant.SESSION_KEY);

		return sessionDto.getAdminId();
	}
}
