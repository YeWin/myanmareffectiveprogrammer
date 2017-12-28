package com.mep.domain.admin.post.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.entity.Post;
import com.mep.database.mapper.PostMapper;

@Repository
public class PostUpdateDaoImpl implements PostUpdateDao {
	
	@Autowired
	private PostMapper postMapper;

	@Override
	public Post getPostById(Integer postId) {
		return postMapper.selectByPrimaryKey(postId);
	}

}
