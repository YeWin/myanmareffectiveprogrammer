package com.mep.domain.admin.post.service;

import static com.mep.util.TestServiceUtil.newPostDto;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.post.dto.PostDto;
import com.mep.util.TestAbstract;

public class PostInsertServiceTest extends TestAbstract {

	@Autowired
	PostInsertService postInsertService;
	
	@Test
	public void shouldInsert() {
		PostDto postDto = newPostDto();
		boolean flag = postInsertService.insertPost(2, postDto);
		assertThat(flag, is(true));
	}
}
