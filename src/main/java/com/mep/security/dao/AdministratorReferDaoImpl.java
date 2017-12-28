package com.mep.security.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.entity.Administrator;
import com.mep.database.entity.AdministratorExample;
import com.mep.database.mapper.AdministratorMapper;

@Repository
public class AdministratorReferDaoImpl implements AdministratorReferDao {

	@Autowired
	private AdministratorMapper administratorMapper;

	@Override
	public List<Administrator> getAdminInformationByEmail(String adminEmail) {

		AdministratorExample adminExample = new AdministratorExample();
		adminExample.or().andAdminEmailEqualTo(adminEmail);

		return administratorMapper.selectByExample(adminExample);
	}

}
