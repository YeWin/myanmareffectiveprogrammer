package com.mep.domain.user.archive.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mep.domain.user.archive.entity.ArchiveList;

@Mapper
public interface ArchiveListMapper {

	List<ArchiveList> getArchiveList();
}
