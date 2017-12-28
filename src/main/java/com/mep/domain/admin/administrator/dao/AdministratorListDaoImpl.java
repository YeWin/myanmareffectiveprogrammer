package com.mep.domain.admin.administrator.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.entity.Administrator;
import com.mep.database.entity.AdministratorExample;
import com.mep.database.mapper.AdministratorMapper;

@Repository
public class AdministratorListDaoImpl implements AdministratorListDao {

	@Autowired
	private AdministratorMapper administratorMapper;

	@Override
	public List<Administrator> getAdministratorList() {

		AdministratorExample administratorExample = new AdministratorExample();

		administratorExample.or().andAdminIdIsNotNull();

		return administratorMapper.selectByExample(administratorExample);
	}

}
