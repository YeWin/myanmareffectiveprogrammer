package com.mep.domain.admin.administrator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.mapper.AdministratorMapper;

@Repository
public class AdministratorDeleteDaoImpl implements AdministratorDeleteDao {

	@Autowired
	private AdministratorMapper administratorMapper;

	@Override
	public int admnistratorDelete(Integer adminId) {
		return administratorMapper.deleteByPrimaryKey(adminId);
	}

}
