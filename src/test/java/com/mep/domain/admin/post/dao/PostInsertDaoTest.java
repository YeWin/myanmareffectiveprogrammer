package com.mep.domain.admin.post.dao;

import static com.mep.util.TestDaoUtil.newPost;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.database.entity.Post;
import com.mep.util.TestAbstract;

public class PostInsertDaoTest extends TestAbstract {

	@Autowired
	private PostInsertDao postInsertDao;

	@Test
	public void shouldInsert() {
		Post post = newPost();
		int count = this.postInsertDao
				.insertPost(post);
		assertThat(count, is(1));
		assertThat(post.getPostId(), notNullValue());
	}

}
