package com.mep.domain.user.archive.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.domain.user.archive.entity.ArchiveList;
import com.mep.domain.user.archive.mapper.ArchiveListMapper;

@Repository
public class ArchiveListDaoImpl implements ArchiveListDao {

	@Autowired
	ArchiveListMapper archiveMapper;

	@Override
	public List<ArchiveList> getArchiveList() {
		return archiveMapper.getArchiveList();
	}

}
