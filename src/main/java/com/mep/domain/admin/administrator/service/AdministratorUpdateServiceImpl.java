package com.mep.domain.admin.administrator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Administrator;
import com.mep.domain.admin.administrator.dao.AdministratorUpdateDao;
import com.mep.domain.admin.administrator.dto.AdministratorDto;
import com.mep.util.BeanConverter;

@Service
public class AdministratorUpdateServiceImpl implements
		AdministratorUpdateService {

	@Autowired
	AdministratorUpdateDao administratorUpdateDao;
	
	@Autowired
	private BeanConverter beanConverter;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AdministratorDto getAdministratorById(Integer adminId) {

		Administrator admin = administratorUpdateDao
				.getAdministratorById(adminId);

		return beanConvert(admin);
	}

	private AdministratorDto beanConvert(Administrator admin) {
		AdministratorDto adminDto = beanConverter.convert(admin,
				AdministratorDto.class);

		return adminDto;
	}

}
