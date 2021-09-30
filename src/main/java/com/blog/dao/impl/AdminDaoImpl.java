package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.blog.dao.AdminDao;
import com.blog.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Admin> getAll() {
		String sql = "select * from tbl_admin";
		@SuppressWarnings("deprecation")
		List<Admin> listUser = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Admin>() {
			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Admin admin = new Admin();
				admin.setId(rs.getString("id"));
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
				admin.setState(rs.getInt("state"));
				admin.setRole(rs.getString("role"));
				return admin;
			}
		});
		return listUser;
	}

	@Override
	public int insert(Admin admin) {
		String sql = "insert into tbl_admin(id, name, password,state,role) values(?, ?, ?, ?,?)";
		if (jdbcTemplate.update(sql, admin.getId(), admin.getName(), admin.getPassword(), admin.getState(),admin.getRole()) > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean update(Admin admin) {
		String sql = "update tbl_admin set name=?, password=?,state=?,role=? where id = ?";
		if (jdbcTemplate.update(sql, admin.getName(), admin.getPassword(), admin.getState(),admin.getRole(), admin.getId()) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		String sql = "delete from tbl_admin where id = ?";
		if (jdbcTemplate.update(sql, id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Admin getDetail(String id) {
		@SuppressWarnings("deprecation")
		Admin admin = this.jdbcTemplate.queryForObject("select * from tbl_Admin where id ='" + id + "'",
				new Object[] {}, new RowMapper<Admin>() {
					public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
						Admin admin = new Admin();
						admin.setId(rs.getString("id"));
						admin.setName(rs.getString("name"));
						admin.setPassword(rs.getString("password"));
						admin.setState(rs.getInt("state"));
						admin.setRole(rs.getString("role"));
						return admin;
					}
				});
		return admin;

	}

	@Override
	public Admin login(String name, String password) {
		@SuppressWarnings("deprecation")
		Admin admin = this.jdbcTemplate.queryForObject("select * from tbl_Admin where name ='" + name + "' AND password = '"+password+"'",
				new Object[] {}, new RowMapper<Admin>() {
					public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
						Admin admin = new Admin();
						admin.setId(rs.getString("id"));
						admin.setName(rs.getString("name"));
						admin.setPassword(rs.getString("password"));
						admin.setState(rs.getInt("state"));
						admin.setRole(rs.getString("role"));
						return admin;
					}
				});
		return admin;
	}

}
