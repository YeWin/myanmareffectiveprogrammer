package com.mep.domain.user.article.dto;

import java.io.Serializable;

public class GoogleAnalyticsDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String postTitle;
	
	private Integer postView;

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public Integer getPostView() {
		return postView;
	}

	public void setPostView(Integer postView) {
		this.postView = postView;
	}
}
