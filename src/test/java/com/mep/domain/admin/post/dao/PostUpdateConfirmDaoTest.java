package com.mep.domain.admin.post.dao;

import static com.mep.util.TestDaoUtil.newPost;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.database.entity.Post;
import com.mep.util.TestAbstract;

public class PostUpdateConfirmDaoTest extends TestAbstract {

	@Autowired
	private PostUpdateConfirmDao postUpdateConfirmDao;

	@Test
	public void shouldUpdate() {
		Post post = newPost();
		post.setPostId(1);
		int count = this.postUpdateConfirmDao
				.updatePost(post);
		assertThat(count, is(1));
	}

}
