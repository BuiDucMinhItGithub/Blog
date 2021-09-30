package com.blog.service;

import java.util.List;

import com.blog.model.AdminDTO;

public interface AdminService {
	List<AdminDTO> getAll();
	int insert(AdminDTO adminDTO);
	boolean update(AdminDTO adminDTO);
	boolean delete(AdminDTO adminDTO);
	boolean delete(String id);
	AdminDTO getDetail(String id);
	AdminDTO login(String name, String password);
}
