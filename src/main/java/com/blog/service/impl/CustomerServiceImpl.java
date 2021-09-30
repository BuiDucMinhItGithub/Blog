package com.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.CustomerDao;
import com.blog.entity.Customer;
import com.blog.model.CustomerDTO;
import com.blog.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;

	@Override
	public List<CustomerDTO> getAll() {
		List<CustomerDTO> listCustomerDTO = new ArrayList<CustomerDTO>();
		List<Customer> listCustomer = customerDao.getAll();
		for (Customer customer : listCustomer) {
			CustomerDTO CustomerDTO = new CustomerDTO();
			CustomerDTO.setName(customer.getName());
			CustomerDTO.setId(customer.getId());
			CustomerDTO.setState(customer.getState());
			listCustomerDTO.add(CustomerDTO);
		}
		return listCustomerDTO;
	}

	@Override
	public int insert(CustomerDTO CustomerDTO) {
		Customer customer = new Customer();
		customer.setName(CustomerDTO.getName());
		customer.setId(CustomerDTO.getId());
		customer.setState(CustomerDTO.getState());
		if (customerDao.insert(customer) > 0)
			return 1;
		return 0;
	}

	@Override
	public CustomerDTO getDetail(int id) {
		Customer customer = new Customer();
		customer = customerDao.getDetail(id);
		CustomerDTO CustomerDTO = new CustomerDTO();
		CustomerDTO.setName(customer.getName());
		CustomerDTO.setId(customer.getId());
		CustomerDTO.setState(customer.getState());
		return CustomerDTO;
	}

	@Override
	public boolean update(CustomerDTO CustomerDTO) {
		Customer customer = new Customer();
		customer.setName(CustomerDTO.getName());
		customer.setId(CustomerDTO.getId());
		customer.setState(CustomerDTO.getState());
		if (customerDao.update(customer)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(CustomerDTO CustomerDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		if (customerDao.delete(id)) {
			return true;
		} else {
			return false;
		}
	}


}
