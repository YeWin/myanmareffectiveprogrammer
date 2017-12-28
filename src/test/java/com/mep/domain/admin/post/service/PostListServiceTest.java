package com.mep.domain.admin.post.service;

import static com.mep.util.TestServiceUtil.getSearchCriteriaPostDto;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.domain.admin.post.dto.PostDto;
import com.mep.domain.admin.post.dto.PostListDto;
import com.mep.util.TestAbstract;

public class PostListServiceTest extends TestAbstract {

	@Autowired
	private PostListService postListService;

	@Test
	public void shouldReturnPostList() {
		PostDto postDto = getSearchCriteriaPostDto();
		
		List<PostListDto> postListDto = postListService
				.getPostList(postDto);
		assertThat(postListDto, notNullValue());
		assertThat(postListDto.size(), anyOf(greaterThan(-1), is(not(0))));
	}

}
