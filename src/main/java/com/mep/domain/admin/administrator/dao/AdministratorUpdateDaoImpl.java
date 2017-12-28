package com.mep.domain.admin.administrator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.entity.Administrator;
import com.mep.database.mapper.AdministratorMapper;

@Repository
public class AdministratorUpdateDaoImpl implements AdministratorUpdateDao {

	@Autowired
	private AdministratorMapper administratorMapper;

	@Override
	public Administrator getAdministratorById(Integer adminId) {
		return administratorMapper.selectByPrimaryKey(adminId);
	}

}
