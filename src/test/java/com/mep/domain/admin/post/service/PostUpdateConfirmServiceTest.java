package com.mep.domain.admin.post.service;

import static com.mep.util.TestServiceUtil.newPostDto;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.post.dto.PostDto;
import com.mep.util.TestAbstract;

public class PostUpdateConfirmServiceTest extends TestAbstract {

	@Autowired
	private PostUpdateConfirmService postUpdateConfirmService;

	@Test
	public void shouldUpdate() {
		PostDto postDto = newPostDto();
		postDto.setPostId(2);
		boolean flag = this.postUpdateConfirmService.updatePost(postDto);
		assertThat(flag, is(true));
	}

}
