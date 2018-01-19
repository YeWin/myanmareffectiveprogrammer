package com.mep.domain.user.article.dto;

import java.io.Serializable;

public class GoogleAnalyticsDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String pageUniquePath;
	
	private String postTitle;
	
	private String createdDate;

	public String getPageUniquePath() {
		return pageUniquePath;
	}

	public void setPageUniquePath(String pageUniquePath) {
		this.pageUniquePath = pageUniquePath;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}
