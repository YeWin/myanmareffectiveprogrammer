package com.mep.domain.admin.administrator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.domain.admin.administrator.dao.AdministratorDeleteDao;

@Service
public class AdministratorDeleteServiceImpl implements
		AdministratorDeleteService {

	@Autowired
	AdministratorDeleteDao administratorDeleteDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean admnistratorDelete(Integer adminId) {
		administratorDeleteDao.admnistratorDelete(adminId);

		return true;
	}

}
