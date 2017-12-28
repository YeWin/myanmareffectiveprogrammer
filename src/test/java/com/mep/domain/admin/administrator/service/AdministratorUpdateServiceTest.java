package com.mep.domain.admin.administrator.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.util.TestAbstract;

public class AdministratorUpdateServiceTest extends TestAbstract {

	@Autowired
	private AdministratorUpdateService administratorUpdateService;

	@Test
	public void shouldReturnAdministratorById() {
		AdministratorDto adminDto = this.administratorUpdateService
				.getAdministratorById(2);
		assertThat(adminDto, notNullValue());
	}

}
