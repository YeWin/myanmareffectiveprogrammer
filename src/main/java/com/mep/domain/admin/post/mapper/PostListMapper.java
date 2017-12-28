package com.mep.domain.admin.post.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mep.database.entity.Post;

@Mapper
public interface PostListMapper {
	
	List<Post> getPostList(@Param("post") Post post);
}
