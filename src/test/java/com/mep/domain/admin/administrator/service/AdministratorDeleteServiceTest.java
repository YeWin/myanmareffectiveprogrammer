package com.mep.domain.admin.administrator.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.util.TestAbstract;

public class AdministratorDeleteServiceTest extends TestAbstract {

	@Autowired
	AdministratorDeleteService administratorDeleteService;

	@Test
	public void shouldDelete() {
		boolean flag = administratorDeleteService.admnistratorDelete(3);
		assertThat(flag, is(true));
	}
}
