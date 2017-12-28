package com.mep.domain.admin.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Post;
import com.mep.domain.admin.post.dao.PostUpdateConfirmDao;
import com.mep.domain.admin.post.dto.PostDto;
import com.mep.util.DateUtil;

@Service
public class PostUpdateConfirmServiceImpl implements PostUpdateConfirmService {

	@Autowired
	private PostUpdateConfirmDao postUpdateConfirmDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updatePost(PostDto postDto) {

		Post post = setDtoModelToEntityModel(postDto);
		postUpdateConfirmDao.updatePost(post);

		return true;
	}

	private Post setDtoModelToEntityModel(PostDto postDto) {
		Post post = new Post();

		post.setPostId(postDto.getPostId());
		post.setAdminId(postDto.getAdminId());
		post.setCategoryId(postDto.getCategoryId());
		post.setPostTitleEng(postDto.getPostTitleEng());
		post.setPostTitleMmr(postDto.getPostTitleMmr());
		post.setPostTitleImgUrl(postDto.getPostTitleImgUrl());
		post.setPostContent(postDto.getPostContent());
		post.setContentType(postDto.getContentType());
		post.setUpdatedDate(DateUtil.getCurrentTime());

		return post;
	}

}
