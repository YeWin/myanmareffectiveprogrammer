package com.mep.domain.admin.administrator.dao;

import static com.mep.util.TestDaoUtil.newAdministrator;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.database.entity.Administrator;
import com.mep.domain.admin.administrator.dao.AdministratorInsertDao;
import com.mep.util.TestAbstract;

public class AdministratorInsertDaoTest extends TestAbstract {

	@Autowired
	private AdministratorInsertDao administratorInsertDao;

	@Test
	public void shouldInsert() {
		Administrator administrator = newAdministrator();
		int count = this.administratorInsertDao
				.insertAdministrator(administrator);
		assertThat(count, is(1));
	}
}
