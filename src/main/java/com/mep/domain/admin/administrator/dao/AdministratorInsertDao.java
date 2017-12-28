package com.mep.domain.admin.administrator.dao;

import com.mep.database.entity.Administrator;

public interface AdministratorInsertDao {
	
	long selectAdministratorByEmail(String adminEmail);

	int insertAdministrator(Administrator administrator);
}
