package com.blog.service;

import java.util.List;

import com.blog.model.CategoryDTO;

public interface CategoryService {
	List<CategoryDTO> getAll();
	int insert(CategoryDTO categoryDTO);
	boolean update(CategoryDTO categoryDTO);
	boolean delete(CategoryDTO categoryDTO);
	boolean delete(String id);
	CategoryDTO getDetail(String id);
}
