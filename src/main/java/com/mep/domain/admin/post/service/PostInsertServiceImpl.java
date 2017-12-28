package com.mep.domain.admin.post.service;

import java.util.Date;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mep.database.entity.Archive;
import com.mep.database.entity.Post;
import com.mep.domain.admin.post.dao.ArchiveInsertDao;
import com.mep.domain.admin.post.dao.PostInsertDao;
import com.mep.domain.admin.post.dto.PostDto;
import com.mep.util.Constant;
import com.mep.util.DateUtil;

@Service
public class PostInsertServiceImpl implements PostInsertService {

	@Autowired
	private PostInsertDao postInsertDao;

	@Autowired
	private ArchiveInsertDao archiveInsertDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SystemException.class)
	public boolean insertPost(Integer adminId, PostDto postDto) {

		Date currentDate = DateUtil.getCurrentTime();

		Post post = insertPost(adminId, postDto, currentDate);

		insertArchive(post, currentDate);

		return true;
	}

	private Post insertPost(Integer adminId, PostDto postDto, Date currentDate) {

		Post post = setDtoModelToEntityModel(adminId, postDto, currentDate);
		postInsertDao.insertPost(post);

		return post;
	}

	private Post setDtoModelToEntityModel(Integer adminId, PostDto postDto,
			Date currentDate) {
		Post post = new Post();

		post.setAdminId(adminId);
		post.setCategoryId(postDto.getCategoryId());
		post.setPostTitleEng(postDto.getPostTitleEng());
		post.setPostTitleMmr(postDto.getPostTitleMmr());
		post.setPostTitleImgUrl(postDto.getPostTitleImgUrl());
		post.setPostContent(postDto.getPostContent());
		post.setContentType(postDto.getContentType());
		post.setCreatedDate(currentDate);

		return post;
	}

	private void insertArchive(Post post, Date currentDate) {
		Archive archive = prepareArchiveData(post, currentDate);
		archiveInsertDao.insertArchive(archive);
	}

	private Archive prepareArchiveData(Post post, Date currentDate) {

		Archive archive = new Archive();

		archive.setPostId(post.getPostId());
		archive.setYear(DateUtil.changeDateFormat(currentDate,
				Constant.DATE_FORMAT[2]));
		archive.setMonth(DateUtil.changeDateFormat(currentDate,
				Constant.DATE_FORMAT[3]));
		archive.setCreatedDate(currentDate);

		return archive;

	}

}
