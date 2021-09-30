package com.blog.dao;

import java.util.List;

import com.blog.entity.Admin;

public interface AdminDao {
	List<Admin> getAll();
	int insert(Admin admin);
	boolean update(Admin admin);
	boolean delete(Admin admin);
	boolean delete(String id);
	Admin getDetail(String id);
	Admin login(String name, String password);
}
