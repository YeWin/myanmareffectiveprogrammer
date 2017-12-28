package com.mep.domain.admin.post.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.database.entity.Post;
import com.mep.domain.admin.post.mapper.PostListMapper;

@Repository
public class PostListDaoImpl implements PostListDao {
	
	@Autowired
	private PostListMapper postListMapper;

	@Override
	public List<Post> getPostList(Post post) {

		return postListMapper.getPostList(post);
	}
}
