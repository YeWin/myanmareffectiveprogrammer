package com.mep.domain.admin.post.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.entity.Archive;
import com.mep.database.mapper.ArchiveMapper;

@Repository
public class ArchiveInsertDaoImpl implements ArchiveInsertDao {
	
	@Autowired
	private ArchiveMapper archiveMapper;

	@Override
	public int insertArchive(Archive archive) {
		return archiveMapper.insertSelective(archive);
	}

}
