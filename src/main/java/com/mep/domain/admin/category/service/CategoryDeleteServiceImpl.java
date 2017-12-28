package com.mep.domain.admin.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.domain.admin.category.dao.CategoryDeleteDao;

@Service
public class CategoryDeleteServiceImpl implements CategoryDeleteService {

	@Autowired
	CategoryDeleteDao categoryDeleteDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean categoryDelete(Integer categoryId) {
		categoryDeleteDao.categoryDelete(categoryId);

		return true;
	}

}
