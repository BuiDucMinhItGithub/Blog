package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.blog.dao.CategoryDao;
import com.blog.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Category> getAll() {
		String sql = "select * from tbl_category";
		@SuppressWarnings("deprecation")
		List<Category> listCategory = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Category>() {
			@Override
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Category category = new Category();
				category.setId(rs.getString("id"));
				category.setName(rs.getString("name"));
				category.setImg(rs.getString("img"));
				return category;
			}
		});
		return listCategory;
	}

	@Override
	public int insert(Category category) {
		String sql = "insert into tbl_category(id, name,img) values(?, ?,?)";
		if (jdbcTemplate.update(sql, category.getId(), category.getName(),category.getImg()) > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean update(Category category) {
		String sql = "update tbl_category set name=?, img = ? where id = ?";
		if (jdbcTemplate.update(sql, category.getName(), category.getImg(), category.getId()) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		String sql = "delete from tbl_category where id = ?";
		if (jdbcTemplate.update(sql, id) > 0) {
			return true;
		}
		return false;
	}

	public Category getDetail(String id) {
		@SuppressWarnings("deprecation")
		Category category = this.jdbcTemplate.queryForObject("select * from tbl_category where id ='" + id + "'",
				new Object[] {}, new RowMapper<Category>() {
					public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
						Category category = new Category();
						category.setId(rs.getString("id"));
						category.setName(rs.getString("name"));
						category.setImg(rs.getString("img"));
						return category;
					}
				});
		return category;

	}

}
