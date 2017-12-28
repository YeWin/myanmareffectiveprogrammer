package com.mep.domain.admin.post.service;

import java.util.List;

import com.mep.domain.admin.post.dto.PostDto;
import com.mep.domain.admin.post.dto.PostListDto;

public interface PostListService {

	List<PostListDto> getPostList(PostDto postDto);
}
