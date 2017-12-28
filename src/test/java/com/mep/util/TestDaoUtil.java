package com.mep.util;

import com.mep.database.entity.Administrator;
import com.mep.database.entity.Archive;
import com.mep.database.entity.Category;
import com.mep.database.entity.Post;

public class TestDaoUtil {

	public static Category newCategory() {

		Category category = new Category();

		category.setCategoryName("Article");

		return category;
	}

	public static Administrator newAdministrator() {

		Administrator admin = new Administrator();

		admin.setAdminName("Ye Win");
		admin.setAdminEmail("yewin29081990@gmail.com");

		return admin;
	}

	public static Post newPost() {

		Post post = new Post();

		post.setAdminId(2);
		post.setCategoryId(2);
		post.setPostTitleEng("What kind of software developer are you?");
		post.setPostTitleMmr("What kind of software developer are you?");
		post.setPostTitleImgUrl("https://github.com/YeWin/msp-research/blob/master/ext%20(1).jpg?raw=true");
		post.setPostContent("Post content");
		post.setContentType(0);

		return post;
	}

	public static Post getSearchCriteriaPost() {
		Post post = new Post();

		post.setCategoryId(1);
		post.setPostTitleEng("What kind");

		return post;

	}
	
	public static Archive newArchive() {
		Archive archive = new Archive();
		
		archive.setPostId(2);
		archive.setYear("2017");
		archive.setMonth("08");
		
		return archive;
	}
}
