package com.mep.domain.admin.post.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.post.dto.PostDto;
import com.mep.util.TestAbstract;

public class PostUpdateServiceTest  extends TestAbstract {

	@Autowired
	private PostUpdateService postUpdateService;

	@Test
	public void shouldReturnPostById() {
		PostDto postDto = this.postUpdateService
				.getPostById(2);
		assertThat(postDto, notNullValue());
	}

}
