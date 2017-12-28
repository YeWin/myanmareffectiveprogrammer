package com.mep.domain.user.archive.entity;

import java.io.Serializable;
import java.util.Date;

public class ArchiveList implements Serializable {

	private static final long serialVersionUID = 1L;

	private String year;
	
	private String month;
	
	private String postTitle;
	
	private String postTitleEng;
	
	private Date createdDate;	

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

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
