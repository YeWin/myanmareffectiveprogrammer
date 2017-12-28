package com.mep.domain.admin.administrator.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.administrator.dto.AdministratorListDto;
import com.mep.util.TestAbstract;

public class AdministratorListServiceTest extends TestAbstract {

	@Autowired
	private AdministratorListService administratorListService;

	@Test
	public void shouldReturnAdministratorList() {
		List<AdministratorListDto> administratorListDto = administratorListService
				.getAdministratorList();
		assertThat(administratorListDto, notNullValue());
		assertThat(administratorListDto.size(),
				anyOf(greaterThan(-1), is(not(0))));
	}
}