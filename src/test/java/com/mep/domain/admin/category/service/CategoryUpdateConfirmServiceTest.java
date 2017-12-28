package com.mep.domain.admin.category.service;

import static com.mep.util.TestServiceUtil.newCategoryDto;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.category.dto.CategoryDto;
import com.mep.util.TestAbstract;

public class CategoryUpdateConfirmServiceTest extends TestAbstract {

	@Autowired
	CategoryUpdateConfirmService categoryUpdateConfirmService;

	@Test
	public void shouldUpdate() {
		CategoryDto categoryDto = newCategoryDto();
		categoryDto.setCategoryId(2);
		categoryDto.setCategoryName("Java Best Practices");
		boolean flag = categoryUpdateConfirmService.updateCategory(categoryDto);
		assertThat(flag, is(true));
	}
}
