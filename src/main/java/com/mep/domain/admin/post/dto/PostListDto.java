package com.mep.domain.admin.post.dto;

import java.io.Serializable;

public class PostListDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer postId;	
	
	private String postTitleEng;
	
	private String postTitleMmr;

	public Integer getPostId() {
		return postId;
	}
	
	public void setPostId(Integer postId) {
		this.postId = postId;
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
}
