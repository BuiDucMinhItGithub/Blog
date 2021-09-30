package com.blog.service;

import java.util.List;

import com.blog.model.HashtagDTO;

public interface HashtagService {
	List<HashtagDTO> getAll();
	List<HashtagDTO> getAllByPostId(String id);
	int insert(HashtagDTO hashtagDTO);
	boolean update(HashtagDTO hashtagDTO);
	boolean delete(HashtagDTO hashtagDTO);
	boolean delete(String id);
	HashtagDTO getDetail(String id);
	List<HashtagDTO> getBestHashtag();
}
