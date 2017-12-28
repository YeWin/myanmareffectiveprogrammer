package com.mep.domain.admin.category.dao;

import static com.mep.util.TestDaoUtil.newCategory;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.database.entity.Category;
import com.mep.util.TestAbstract;

public class CategoryInsertDaoTest extends TestAbstract {

	@Autowired
	private CategoryInsertDao categoryInsertDao;

	@Test
	public void shouldInsert() {
		Category category = newCategory();
		int count = this.categoryInsertDao.insertCategory(category);
		assertThat(count, is(1));
	}
}
