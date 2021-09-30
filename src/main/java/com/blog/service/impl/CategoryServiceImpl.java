package com.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.CategoryDao;
import com.blog.entity.Category;
import com.blog.model.CategoryDTO;

import com.blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Override
	public List<CategoryDTO> getAll() {
		List<CategoryDTO> listCategoryDTO = new ArrayList<CategoryDTO>();
		List<Category> listcategory = categoryDao.getAll();
		for (Category category : listcategory) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setId(category.getId());
			categoryDTO.setName(category.getName());
			categoryDTO.setImg(category.getImg());
			listCategoryDTO.add(categoryDTO);
		}
		return listCategoryDTO;
	}

	@Override
	public int insert(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setName(categoryDTO.getName());
		category.setImg(categoryDTO.getImg());
		category.setId(categoryDTO.getId());
		if (categoryDao.insert(category) > 0)
			return 1;
		return 0;
	}

	@Override
	public boolean update(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setName(categoryDTO.getName());
		category.setImg(categoryDTO.getImg());
		category.setId(categoryDTO.getId());
		if (categoryDao.update(category)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(CategoryDTO categoryDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		if (categoryDao.delete(id)) {
			return true;
		} else {
			return false;
		}
	}

	public CategoryDTO getDetail(String id) {
		Category category = new Category();
		category = categoryDao.getDetail(id);
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setName(category.getName());
		categoryDTO.setId(category.getId());
		categoryDTO.setImg(category.getImg());
		return categoryDTO;
	}

}
