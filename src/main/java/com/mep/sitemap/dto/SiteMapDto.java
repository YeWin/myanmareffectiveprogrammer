package com.mep.sitemap.dto;

import java.io.Serializable;
import java.util.Date;

public class SiteMapDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String postTitleEng;
	
	private Date createdDate;

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
