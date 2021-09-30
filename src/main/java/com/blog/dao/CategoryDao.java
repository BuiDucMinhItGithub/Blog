package com.blog.dao;

import java.util.List;

import com.blog.entity.Category;

public interface CategoryDao {
	List<Category> getAll();
	int insert(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	boolean delete(String id);
	Category getDetail(String id);
}
