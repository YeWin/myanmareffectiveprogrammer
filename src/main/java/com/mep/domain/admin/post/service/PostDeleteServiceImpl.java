package com.mep.domain.admin.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.domain.admin.post.dao.PostDeleteDao;

@Service
public class PostDeleteServiceImpl implements PostDeleteService {

	@Autowired
	private PostDeleteDao postDeleteDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean postDelete(Integer postId) {
		postDeleteDao.postDelete(postId);

		return true;
	}

}
