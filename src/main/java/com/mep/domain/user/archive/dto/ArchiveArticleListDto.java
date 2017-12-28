package com.mep.domain.user.archive.dto;

import java.io.Serializable;
import java.util.Date;

public class ArchiveArticleListDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String postTitle;
	
	private String postTitleEng;
	
	private Date createdDate;

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
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
}
