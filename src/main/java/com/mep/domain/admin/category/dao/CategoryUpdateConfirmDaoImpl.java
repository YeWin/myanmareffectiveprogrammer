package com.mep.domain.admin.category.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.entity.Category;
import com.mep.database.mapper.CategoryMapper;

@Repository
public class CategoryUpdateConfirmDaoImpl implements CategoryUpdateConfirmDao {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public int updateCategory(Category category) {

		return categoryMapper.updateByPrimaryKeySelective(category);
	}
}
