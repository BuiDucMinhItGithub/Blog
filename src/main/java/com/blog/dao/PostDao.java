package com.blog.dao;

import java.util.List;

import com.blog.entity.Post;

public interface PostDao {
	List<Post> getAll();
	int insert(Post post);
	boolean update(Post post);
	boolean delete(Post post);
	boolean delete(String id);
	Post getDetail(String id);
	List<Post> getListByCategoryId(String id);
	List<Post> getRandom();
	List<Post> getPostByCategoryId(String id);
	List<Post> getPostByKey(String key);
	List<Post> getPostByKeyWithLimit(String key, int start, int end);
	List<Post> getListPostByIdHashtag(String id);
	List<Post> getListPostByIdHashtagWithLimit(String id,int start,int end);
	List<Post> getPostByCategoryIdWithLimit(String id, int start, int end);
	List<Post> getAllWithLimit(int start, int end);
	List<Post> getNewestList();
	List<Post> getOldestList();
	List<Post> getChart();
	List<Post> getBestReact();
	boolean update(String id);
	
}
