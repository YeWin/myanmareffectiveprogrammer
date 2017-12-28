package com.mep.security.dao;

import java.util.List;

import com.mep.database.entity.Administrator;

public interface AdministratorReferDao {

	List<Administrator> getAdminInformationByEmail(String adminEmail);
}
