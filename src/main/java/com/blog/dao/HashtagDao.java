package com.blog.dao;

import java.util.List;

import com.blog.entity.Hashtag;

public interface HashtagDao {
	List<Hashtag> getAll();
	int insert(Hashtag hashtag);
	boolean update(Hashtag hashtag);
	boolean delete(Hashtag hashtag);
	boolean delete(String id);
	Hashtag getDetail(String id);
	List<Hashtag> getAllByPostId(String id);
	List<Hashtag> getBestHashtag();
}
