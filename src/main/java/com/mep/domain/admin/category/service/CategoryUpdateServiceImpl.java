package com.mep.domain.admin.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Category;
import com.mep.domain.admin.category.dao.CategoryUpdateDao;
import com.mep.domain.admin.category.dto.CategoryDto;

@Service
public class CategoryUpdateServiceImpl implements CategoryUpdateService {

	@Autowired
	CategoryUpdateDao categoryUpdateDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CategoryDto getCategoryById(Integer categoryId) {

		Category category = categoryUpdateDao.getCategoryById(categoryId);

		return setEntityModelToDtoModel(category);
	}

	private CategoryDto setEntityModelToDtoModel(Category category) {
		CategoryDto categoryDto = new CategoryDto();

		categoryDto.setCategoryId(category.getCategoryId());
		categoryDto.setCategoryName(category.getCategoryName());

		return categoryDto;
	}

}
