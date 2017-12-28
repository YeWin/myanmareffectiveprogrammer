package com.mep.domain.admin.administrator.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.database.entity.Administrator;
import com.mep.util.TestAbstract;

public class AdministratorListDaoTest extends TestAbstract {

	@Autowired
	private AdministratorListDao administratorListDao;

	@Test
	public void shouldReturnAdministratorList() {
		List<Administrator> administrator = this.administratorListDao
				.getAdministratorList();
		assertThat(administrator, notNullValue());
		assertThat(administrator.size(), anyOf(greaterThan(-1), is(not(0))));
	}
}
