package com.mep.domain.user.article.dto;

import java.io.Serializable;
import java.util.Date;

public class ArticleDashboardDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer postId;

	private String postTitle;
	
	private String postTitleImgUrl;
	
	private String postTitleEng;
	
	private Date createdDate;
	
	private String adminName;
	
	private Integer contentType;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostTitleImgUrl() {
		return postTitleImgUrl;
	}

	public void setPostTitleImgUrl(String postTitleImgUrl) {
		this.postTitleImgUrl = postTitleImgUrl;
	}

	public String getPostTitleEng() {
		return postTitleEng;
	}

	public void setPostTitleEng(String postTitleEng) {
		this.postTitleEng = postTitleEng;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Integer getContentType() {
		return contentType;
	}

	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}
}
