package com.mep.domain.user.archive.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.user.archive.dto.ArchiveYearListDto;
import com.mep.util.TestAbstract;

public class ArchiveListServiceTest extends TestAbstract {

	@Autowired
	private ArchiveListService archiveListService;

	@Test
	public void shouldReturnArchiveList() {
		List<ArchiveYearListDto> archiveList = archiveListService.getArchiveList();

		assertThat(archiveList, notNullValue());
		assertThat(archiveList.size(), anyOf(greaterThan(-1), is(not(0))));
	}

}
