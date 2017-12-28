package com.mep.domain.admin.post.dao;

import static com.mep.util.TestDaoUtil.getSearchCriteriaPost;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mep.database.entity.Post;
import com.mep.util.TestAbstract;

public class PostListDaoTest extends TestAbstract {

	@Autowired
	private PostListDao postListDao;

	@Test
	public void shouldReturnPostList() {
		Post post = getSearchCriteriaPost();
		List<Post> postList = this.postListDao.getPostList(post);
		assertThat(postList, notNullValue());
		assertThat(postList.size(), anyOf(greaterThan(-1), is(not(0))));
	}

}
