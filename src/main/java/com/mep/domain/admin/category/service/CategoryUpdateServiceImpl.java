package com.mep.domain.admin.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Category;
import com.mep.domain.admin.category.dao.CategoryUpdateDao;
import com.mep.domain.admin.category.dto.CategoryDto;
import com.mep.util.BeanConverter;

@Service
public class CategoryUpdateServiceImpl implements CategoryUpdateService {

	@Autowired
	CategoryUpdateDao categoryUpdateDao;
	
	@Autowired
	private BeanConverter beanConverter;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CategoryDto getCategoryById(Integer categoryId) {

		Category category = categoryUpdateDao.getCategoryById(categoryId);

		return beanConvert(category);
	}

	private CategoryDto beanConvert(Category category) {
		CategoryDto categoryDto = beanConverter.convert(category,
				CategoryDto.class);

		return categoryDto;
	}

}
