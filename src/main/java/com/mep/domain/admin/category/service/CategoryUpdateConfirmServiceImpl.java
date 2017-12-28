package com.mep.domain.admin.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Category;
import com.mep.domain.admin.category.dao.CategoryUpdateConfirmDao;
import com.mep.domain.admin.category.dto.CategoryDto;
import com.mep.util.DateUtil;

@Service
public class CategoryUpdateConfirmServiceImpl implements
		CategoryUpdateConfirmService {

	@Autowired
	CategoryUpdateConfirmDao categoryUpdateConfirmDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateCategory(CategoryDto categoryDto) {

		categoryUpdateConfirmDao
				.updateCategory(setDtoModelToEntityModel(categoryDto));

		return true;
	}

	private Category setDtoModelToEntityModel(CategoryDto categoryDto) {
		Category category = new Category();

		category.setCategoryId(categoryDto.getCategoryId());
		category.setCategoryName(categoryDto.getCategoryName());
		category.setUpdatedDate(DateUtil.getCurrentTime());

		return category;
	}

}
