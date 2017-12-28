package com.mep.domain.admin.category.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.category.dto.CategoryDto;
import com.mep.util.TestAbstract;

public class CategoryUpdateServiceTest extends TestAbstract {

	@Autowired
	private CategoryUpdateService categoryUpdateService;

	@Test
	public void shouldReturnCategoryById() {
		CategoryDto categoryDto = this.categoryUpdateService.getCategoryById(2);
		assertThat(categoryDto, notNullValue());
	}

}
