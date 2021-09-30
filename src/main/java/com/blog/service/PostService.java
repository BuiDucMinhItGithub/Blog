package com.blog.service;

import java.util.List;

import com.blog.model.PostDTO;

public interface PostService {
	List<PostDTO> getAll();
	List<PostDTO> getRandom();
	int insert(PostDTO postDTO);
	boolean update(PostDTO postDTO);
	boolean delete(PostDTO postDTO);
	boolean delete(String id);
	PostDTO getDetail(String id);
	List<PostDTO> getListByCategoryId(String id);
	List<PostDTO> getPostByCategoryId(String id);
	List<PostDTO> getPostByKey(String key);
	List<PostDTO> getPostByKeyWithLimit(String key, int start, int end);
	List<PostDTO> getListPostByIdHashtag(String id);
	List<PostDTO> getListPostByIdHashtagWithLimit(String id, int start, int end);
	List<PostDTO> getPostByCategoryIdWithLimit(String id, int start, int end);
	List<PostDTO> getAllWithLimit(int start, int end);
	List<PostDTO> getNewestList();
	List<PostDTO> getOldestList();
	List<PostDTO> getChart();
	List<PostDTO> getBestReact();
	boolean update(String id);
}	
