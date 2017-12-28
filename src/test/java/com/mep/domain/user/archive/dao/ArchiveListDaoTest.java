package com.mep.domain.user.archive.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.user.archive.entity.ArchiveList;
import com.mep.util.TestAbstract;

public class ArchiveListDaoTest extends TestAbstract {

	@Autowired
	private ArchiveListDao archiveListDao;

	@Test
	public void shouldReturnArchiveList() {
		List<ArchiveList> archiveList = archiveListDao.getArchiveList();

		assertThat(archiveList, notNullValue());
		assertThat(archiveList.size(), anyOf(greaterThan(-1), is(not(0))));
	}

}
