package com.mep.domain.admin.post.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.entity.Post;
import com.mep.database.mapper.PostMapper;

@Repository
public class PostInsertDaoImpl implements PostInsertDao {
	
	@Autowired
	private PostMapper postMapper;

	@Override
	public int insertPost(Post post) {
		return postMapper.insertSelective(post);
	}

}
