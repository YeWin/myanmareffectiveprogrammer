package com.mep.domain.admin.administrator.dao;

import com.mep.database.entity.Administrator;

public interface AdministratorUpdateConfirmDao {
	
	long selectAdministratorByEmail(String adminEmail);

	int updateAdministrator(Administrator administrator);
}
