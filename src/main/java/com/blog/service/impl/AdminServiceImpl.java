package com.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.AdminDao;
import com.blog.entity.Admin;
import com.blog.model.AdminDTO;
import com.blog.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Override
	public List<AdminDTO> getAll() {
		// TODO Auto-generated method stub
		// gọi lại getAll từ UserDao và chuyển thành user dto, và user dto trả lại cho
		// trình duyệt hiện thị
		List<AdminDTO> listAdminDTO = new ArrayList<AdminDTO>();
		List<Admin> listUser = adminDao.getAll();
		for (Admin admin : listUser) {
			AdminDTO AdminDTO = new AdminDTO();
			AdminDTO.setName(admin.getName());
			AdminDTO.setId(admin.getId());
			AdminDTO.setPassword(admin.getPassword());
			AdminDTO.setState(admin.getState());
			AdminDTO.setRole(admin.getRole());
			listAdminDTO.add(AdminDTO);
		}
		return listAdminDTO;
	}

	@Override
	public int insert(AdminDTO adminDTO) {
		Admin admin = new Admin();
		admin.setName(adminDTO.getName());
		admin.setId(adminDTO.getId());
		admin.setPassword(adminDTO.getPassword());
		admin.setState(adminDTO.getState());
		admin.setRole(adminDTO.getRole());
		if (adminDao.insert(admin) > 0)
			return 1;
		return 0;
	}

	@Override
	public AdminDTO getDetail(String id) {
		Admin admin = new Admin();
		admin = adminDao.getDetail(id);
		AdminDTO AdminDTO = new AdminDTO();
		AdminDTO.setName(admin.getName());
		AdminDTO.setId(admin.getId());
		AdminDTO.setPassword(admin.getPassword());
		AdminDTO.setState(admin.getState());
		AdminDTO.setRole(admin.getRole());
		return AdminDTO;
	}

	@Override
	public boolean update(AdminDTO adminDTO) {
		Admin admin = new Admin();
		admin.setName(adminDTO.getName());
		admin.setId(adminDTO.getId());
		admin.setPassword(adminDTO.getPassword());
		admin.setState(adminDTO.getState());
		admin.setRole(adminDTO.getRole());
		if (adminDao.update(admin)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(AdminDTO adminDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		if (adminDao.delete(id)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public AdminDTO login(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//security

	

}
