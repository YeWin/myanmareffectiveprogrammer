package com.mep.domain.admin.post.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.mapper.PostMapper;

@Repository
public class PostDeleteDaoImpl implements PostDeleteDao {
	
	@Autowired
	private PostMapper postMapper;

	@Override
	public int postDelete(Integer postId) {
		return postMapper.deleteByPrimaryKey(postId);
	}

}
