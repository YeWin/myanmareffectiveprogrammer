package com.mep.domain.admin.post.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.post.dto.CategoryDropdownDto;
import com.mep.util.TestAbstract;

public class PostInitServiceTest extends TestAbstract {

	@Autowired
	private PostInitService postInitService;

	@Test
	public void shouldReturnCategoryDropdown() {
		List<CategoryDropdownDto> categoryDropdownDto = postInitService
				.getCategoryDropdown();
		assertThat(categoryDropdownDto, notNullValue());
		assertThat(categoryDropdownDto.size(), anyOf(greaterThan(-1), is(not(0))));
	}

}
