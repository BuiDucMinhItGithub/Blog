package com.blog.service;

import java.util.List;

import com.blog.model.CustomerDTO;

public interface CustomerService {
	List<CustomerDTO> getAll();
	int insert(CustomerDTO customerDTO);
	boolean update(CustomerDTO customerDTO);
	boolean delete(CustomerDTO customerDTO);
	boolean delete(int id);
	CustomerDTO getDetail(int id);
}
