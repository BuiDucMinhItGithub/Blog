package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.blog.dao.CustomerDao;
import com.blog.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from tbl_customer";
		@SuppressWarnings("deprecation")
		List<Customer> listCustomer = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Customer>() {
			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setState(rs.getInt("state"));
				return customer;
			}
		});
		return listCustomer;
	}

	@Override
	public int insert(Customer customer) {
		String sql = "insert into tbl_customer(id, name,state) values(?, ?, ?)";
		if (jdbcTemplate.update(sql, customer.getId(), customer.getName(), customer.getState()) > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean update(Customer customer) {
		String sql = "update tbl_customer set name=?,state=? where id = ?";
		if (jdbcTemplate.update(sql, customer.getName(), customer.getState(), customer.getId()) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from tbl_customer where id = ?";
		if (jdbcTemplate.update(sql, id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Customer getDetail(int id) {
		@SuppressWarnings("deprecation")
		Customer customer = this.jdbcTemplate.queryForObject("select * from tbl_customer where id ='" + id + "'",
				new Object[] {}, new RowMapper<Customer>() {
					public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
						Customer customer = new Customer();
						customer.setId(rs.getInt("id"));
						customer.setName(rs.getString("name"));
						customer.setState(rs.getInt("state"));
						return customer;
					}
				});
		return customer;
	}

	
}
