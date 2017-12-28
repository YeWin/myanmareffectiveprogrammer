package com.mep.util;

import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.domain.admin.category.dto.CategoryDto;
import com.mep.domain.admin.post.dto.PostDto;

public class TestServiceUtil {

	public static CategoryDto newCategoryDto() {

		CategoryDto categoryDto = new CategoryDto();

		categoryDto.setCategoryName("Article");

		return categoryDto;
	}

	public static AdministratorDto newAdministratorDto() {

		AdministratorDto adminDto = new AdministratorDto();

		adminDto.setAdminName("Ye Win");
		adminDto.setAdminEmail("yewin29081990@gmail.com");
		adminDto.setAdminImageUrl("URL");
		adminDto.setAboutAdmin("About author");

		return adminDto;
	}

	public static PostDto getSearchCriteriaPostDto() {
		PostDto postDto = new PostDto();

		postDto.setCategoryId(1);
		postDto.setPostTitleEng("");

		return postDto;
	}
	
	public static PostDto newPostDto() {
		PostDto postDto = new PostDto();

		postDto.setAdminId(2);
		postDto.setCategoryId(2);
		postDto.setPostTitleEng("Programmer Guide");
		postDto.setPostTitleMmr("What kind of software developer are you?");
		postDto.setPostTitleImgUrl("https://github.com/YeWin/msp-research/blob/master/ext%20(1).jpg?raw=true");
		postDto.setPostContent("Post content1");
		postDto.setContentType(1);

		return postDto;
		
	}
}
