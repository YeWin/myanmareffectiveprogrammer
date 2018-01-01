package com.mep.domain.admin.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Post;
import com.mep.domain.admin.post.dao.PostUpdateDao;
import com.mep.domain.admin.post.dto.PostDto;
import com.mep.util.BeanConverter;

@Service
public class PostUpdateServiceImpl implements PostUpdateService {

	@Autowired
	private PostUpdateDao postUpdateDao;
	
	@Autowired
	private BeanConverter beanConverter;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PostDto getPostById(Integer postId) {

		Post post = postUpdateDao.getPostById(postId);

		return beanConvert(post);
	}

	private PostDto beanConvert(Post post) {
		PostDto postDto = beanConverter.convert(post,
				PostDto.class);

		return postDto;
	}

}
