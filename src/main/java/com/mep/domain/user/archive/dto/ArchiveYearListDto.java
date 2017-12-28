package com.mep.domain.user.archive.dto;

import java.io.Serializable;
import java.util.List;

public class ArchiveYearListDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String year;
	
	private List<ArchiveMonthListDto> monthList;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<ArchiveMonthListDto> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<ArchiveMonthListDto> monthList) {
		this.monthList = monthList;
	}
}
