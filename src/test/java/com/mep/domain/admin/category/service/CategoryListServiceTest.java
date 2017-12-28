package com.mep.domain.admin.category.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.category.dto.CategoryListDto;
import com.mep.util.TestAbstract;

public class CategoryListServiceTest extends TestAbstract {

	@Autowired
	private CategoryListService categoryListService;

	@Test
	public void shouldReturnCategoryList() {
		List<CategoryListDto> categoryListDto = categoryListService
				.getCategoryList();
		assertThat(categoryListDto, notNullValue());
		assertThat(categoryListDto.size(), anyOf(greaterThan(-1), is(not(0))));
	}
}
