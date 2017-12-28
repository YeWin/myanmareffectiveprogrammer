package com.mep.domain.admin.category.service;

import static com.mep.util.TestServiceUtil.newCategoryDto;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.category.dto.CategoryDto;
import com.mep.util.TestAbstract;

public class CategoryInsertServiceTest extends TestAbstract {

	@Autowired
	private CategoryInsertService categoryInsertService;

	@Test
	public void shouldInsert() {
		CategoryDto categoryDto = newCategoryDto();
		boolean flag = categoryInsertService.insertCategory(categoryDto);
		assertThat(flag, is(true));
	}
}
