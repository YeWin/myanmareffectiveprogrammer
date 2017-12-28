package com.mep.domain.admin.post.dao;

import static com.mep.util.TestDaoUtil.newArchive;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.database.entity.Archive;
import com.mep.util.TestAbstract;

public class ArchiveInsertDaoTest extends TestAbstract {

	@Autowired
	private ArchiveInsertDao archiveInsertDao;

	@Test
	public void shouldInsert() {
		Archive archive = newArchive();
		int count = this.archiveInsertDao
				.insertArchive(archive);
		assertThat(count, is(1));		
	}

}
