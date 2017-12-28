package com.mep.domain.user.article.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mep.domain.user.article.entity.ArticleDashboard;
import com.mep.domain.user.article.entity.ArticleSingle;
import com.mep.domain.user.article.mapper.ArticleSingleMapper;

@Repository
public class ArticleSingleDaoImpl implements ArticleSingleDao {

	@Autowired
	private ArticleSingleMapper articleSingleMapper;

	@Override
	public List<ArticleSingle> getArticle(String postTitleEng) {
		return articleSingleMapper.getArticle(postTitleEng);
	}

	@Override
	public List<ArticleDashboard> getLastSevenArticle(String postTitleEng) {
		return articleSingleMapper.getLastSevenArticle(postTitleEng);
	}
}
