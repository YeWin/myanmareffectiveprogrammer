package com.mep.domain.admin.category.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.entity.Category;
import com.mep.database.entity.CategoryExample;
import com.mep.database.mapper.CategoryMapper;

@Repository
public class CategoryListDaoImpl implements CategoryListDao {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> getCategoryList() {

		CategoryExample categoryExample = new CategoryExample();

		categoryExample.or().andCategoryIdIsNotNull();

		return categoryMapper.selectByExample(categoryExample);
	}

}
