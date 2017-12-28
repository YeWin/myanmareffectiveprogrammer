package com.mep.domain.user.archive.service;

import java.util.List;

import com.mep.domain.user.archive.dto.ArchiveYearListDto;

public interface ArchiveListService {
	
	List<ArchiveYearListDto> getArchiveList();
}
