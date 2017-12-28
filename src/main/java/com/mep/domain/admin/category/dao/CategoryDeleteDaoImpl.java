package com.mep.domain.admin.category.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.mapper.CategoryMapper;

@Repository
public class CategoryDeleteDaoImpl implements CategoryDeleteDao {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public int categoryDelete(Integer categoryId) {
		return categoryMapper.deleteByPrimaryKey(categoryId);
	}

}
