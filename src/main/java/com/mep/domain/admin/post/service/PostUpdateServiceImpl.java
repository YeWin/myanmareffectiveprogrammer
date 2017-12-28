package com.mep.domain.admin.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Post;
import com.mep.domain.admin.post.dao.PostUpdateDao;
import com.mep.domain.admin.post.dto.PostDto;

@Service
public class PostUpdateServiceImpl implements PostUpdateService {

	@Autowired
	private PostUpdateDao postUpdateDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PostDto getPostById(Integer postId) {

		Post post = postUpdateDao.getPostById(postId);

		return setEntityModelToDtoModel(post);
	}

	private PostDto setEntityModelToDtoModel(Post post) {
		PostDto postDto = new PostDto();

		postDto.setPostId(post.getPostId());
		postDto.setCategoryId(post.getCategoryId());
		postDto.setAdminId(post.getAdminId());
		postDto.setPostTitleEng(post.getPostTitleEng());
		postDto.setPostTitleMmr(post.getPostTitleMmr());
		postDto.setPostTitleImgUrl(post.getPostTitleImgUrl());
		postDto.setPostContent(post.getPostContent());
		postDto.setContentType(post.getContentType());

		return postDto;
	}

}
