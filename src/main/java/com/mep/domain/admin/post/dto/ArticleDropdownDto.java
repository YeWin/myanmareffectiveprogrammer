package com.mep.domain.admin.post.dto;

import java.io.Serializable;

public class ArticleDropdownDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer contentType;
	
	private String contentTypeName;

	public Integer getContentType() {
		return contentType;
	}

	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	public String getContentTypeName() {
		return contentTypeName;
	}

	public void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}

}
