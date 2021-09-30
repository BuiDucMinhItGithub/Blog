package com.blog.service;

import java.util.List;

import com.blog.model.PosthashDTO;

public interface PosthashService {
	List<PosthashDTO> getAll();
	List<PosthashDTO> getAllByPostId(String id);
	int insert(PosthashDTO posthashDTO);
	boolean update(PosthashDTO posthashDTO);
	boolean delete(PosthashDTO posthashDTO);
	boolean delete(int id);
	PosthashDTO getDetail(int id);
}
