package com.mep.domain.user.archive.dto;

import java.io.Serializable;
import java.util.List;

public class ArchiveMonthListDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String month;
	
	private List<ArchiveArticleListDto> articleList;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public List<ArchiveArticleListDto> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<ArchiveArticleListDto> articleList) {
		this.articleList = articleList;
	}
}
