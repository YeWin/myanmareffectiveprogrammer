package com.mep.domain.user.article.entity;

import java.io.Serializable;
import java.util.Date;

public class ArticleSingle implements Serializable {

	private static final long serialVersionUID = 1L;

	private String adminName;

	private String adminImageUrl;

	private String aboutAdmin;

	private Date createdDate;

	private String postTitleImgUrl;	

	private String postTitle;

	private Integer contentType;

	private String postContent;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminImageUrl() {
		return adminImageUrl;
	}

	public void setAdminImageUrl(String adminImageUrl) {
		this.adminImageUrl = adminImageUrl;
	}

	public String getAboutAdmin() {
		return aboutAdmin;
	}

	public void setAboutAdmin(String aboutAdmin) {
		this.aboutAdmin = aboutAdmin;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getPostTitleImgUrl() {
		return postTitleImgUrl;
	}

	public void setPostTitleImgUrl(String postTitleImgUrl) {
		this.postTitleImgUrl = postTitleImgUrl;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public Integer getContentType() {
		return contentType;
	}

	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

}
