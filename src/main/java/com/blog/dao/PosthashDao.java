package com.blog.dao;

import java.util.List;

import com.blog.entity.Posthash;

public interface PosthashDao {
	List<Posthash> getAll();
	List<Posthash> getAllByPostId(String id);
	int insert(Posthash posthash);
	boolean update(Posthash posthash);
	boolean delete(Posthash posthash);
	boolean delete(int id);
	Posthash getDetail(int id);
}
