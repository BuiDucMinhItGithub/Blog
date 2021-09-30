package com.blog.dao;

import java.util.List;

import com.blog.entity.Customer;

public interface CustomerDao {
	List<Customer> getAll();
	int insert(Customer customer);
	boolean update(Customer customer);
	boolean delete(Customer customer);
	boolean delete(int id);
	Customer getDetail(int id);
}
