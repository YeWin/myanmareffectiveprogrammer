package com.mep.domain.admin.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Post;
import com.mep.domain.admin.post.dao.PostListDao;
import com.mep.domain.admin.post.dto.PostDto;
import com.mep.domain.admin.post.dto.PostListDto;

@Service
public class PostListServiceImpl implements PostListService {

	@Autowired
	private PostListDao postListDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<PostListDto> getPostList(PostDto postDto) {

		List<Post> postList = postListDao
				.getPostList(setDtoModelToEntityModel(postDto));

		List<PostListDto> postListDto = (List<PostListDto>) (List<?>) postList;

		return postListDto;
	}

	private Post setDtoModelToEntityModel(PostDto postDto) {

		Post post = new Post();

		post.setCategoryId(postDto.getCategoryId());
		post.setPostTitleEng(postDto.getPostTitleEng());
		post.setContentType(postDto.getContentType());

		return post;
	}

}
