package com.mep.domain.admin.administrator.dao;

import static com.mep.util.TestDaoUtil.newAdministrator;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.database.entity.Administrator;
import com.mep.util.TestAbstract;

public class AdministratorUpdateConfirmDaoTest extends TestAbstract {

	@Autowired
	private AdministratorUpdateConfirmDao administratorUpdateConfirmDao;

	@Test
	public void shouldUpdate() {
		Administrator admin = newAdministrator();
		admin.setAdminId(2);
		admin.setAdminName("Ye Win 3");
		int count = this.administratorUpdateConfirmDao
				.updateAdministrator(admin);
		assertThat(count, is(1));
	}

}
