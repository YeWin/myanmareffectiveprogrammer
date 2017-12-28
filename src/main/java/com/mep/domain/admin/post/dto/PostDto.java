package com.mep.domain.admin.post.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class PostDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer postId;

	private Integer adminId;

	private List<CategoryDropdownDto> categoryDropdown;

	@NotBlank
	private String postTitleEng;

	private String postTitleMmr;

	private String postTitleImgUrl;

	private Integer categoryId;

	@NotBlank
	private String postContent;

	private Integer contentType;

	private List<ArticleDropdownDto> articleDropdownDto;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public List<CategoryDropdownDto> getCategoryDropdown() {
		return categoryDropdown;
	}

	public void setCategoryDropdown(List<CategoryDropdownDto> categoryDropdown) {
		this.categoryDropdown = categoryDropdown;
	}

	public String getPostTitleEng() {
		return postTitleEng;
	}

	public void setPostTitleEng(String postTitleEng) {
		this.postTitleEng = postTitleEng;
	}

	public String getPostTitleMmr() {
		return postTitleMmr;
	}

	public void setPostTitleMmr(String postTitleMmr) {
		this.postTitleMmr = postTitleMmr;
	}

	public String getPostTitleImgUrl() {
		return postTitleImgUrl;
	}

	public void setPostTitleImgUrl(String postTitleImgUrl) {
		this.postTitleImgUrl = postTitleImgUrl;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getContentType() {
		return contentType;
	}

	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	public List<ArticleDropdownDto> getArticleDropdownDto() {

		return this.articleDropdownDto;
	}

	public void setArticleDropdownDto(
			List<ArticleDropdownDto> articleDropdownDto) {
		this.articleDropdownDto = articleDropdownDto;
	}
}
