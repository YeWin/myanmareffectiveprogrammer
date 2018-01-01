package com.mep.domain.admin.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Post;
import com.mep.domain.admin.post.dao.PostUpdateConfirmDao;
import com.mep.domain.admin.post.dto.PostDto;
import com.mep.util.BeanConverter;
import com.mep.util.DateUtil;

@Service
public class PostUpdateConfirmServiceImpl implements PostUpdateConfirmService {

	@Autowired
	private PostUpdateConfirmDao postUpdateConfirmDao;
	
	@Autowired
	private BeanConverter beanConverter;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updatePost(PostDto postDto) {

		postUpdateConfirmDao.updatePost(beanConvert(postDto));

		return true;
	}

	private Post beanConvert(PostDto postDto) {
		Post post = beanConverter.convert(postDto,
				Post.class);
		
		post.setUpdatedDate(DateUtil.getCurrentTime());

		return post;
	}

}
