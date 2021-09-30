package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.blog.dao.HashtagDao;
import com.blog.entity.Hashtag;

@Repository
public class HashtagDaoImpl implements HashtagDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Hashtag> getAll() {
		String sql = "select * from tbl_hashtag";
		@SuppressWarnings("deprecation")
		List<Hashtag> listHashtag = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Hashtag>() {
			@Override
			public Hashtag mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Hashtag hashtag = new Hashtag();
				hashtag.setId(rs.getString("id"));
				hashtag.setName(rs.getString("name"));
				return hashtag;
			}
		});
		return listHashtag;
	}

	@Override
	public int insert(Hashtag hashtag) {
		String sql = "insert into tbl_hashtag(id, name) values(?, ?)";
		if (jdbcTemplate.update(sql, hashtag.getId(), hashtag.getName()) > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean update(Hashtag hashtag) {
		String sql = "update tbl_hashtag set name=? where id = ?";
		if (jdbcTemplate.update(sql, hashtag.getName(),hashtag.getId()) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Hashtag hashtag) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		String sql = "delete from tbl_hashtag where id = ?";
		if (jdbcTemplate.update(sql, id) > 0) {
			return true;
		}
		return false;
	}

	public Hashtag getDetail(String id) {
		@SuppressWarnings("deprecation")
		Hashtag hashtag = this.jdbcTemplate.queryForObject("select * from tbl_hashtag where id ='" + id + "'",
				new Object[] {}, new RowMapper<Hashtag>() {
					public Hashtag mapRow(ResultSet rs, int rowNum) throws SQLException {
						Hashtag hashtag = new Hashtag();
						hashtag.setId(rs.getString("id"));
						hashtag.setName(rs.getString("name"));
						return hashtag;
					}
				});
		return hashtag;

	}

	@Override
	public List<Hashtag> getAllByPostId(String id) {
		@SuppressWarnings("deprecation")
		List<Hashtag> posthashList = this.jdbcTemplate.query("SELECT DISTINCT tbl_hashtag.id,tbl_hashtag.name FROM tbl_posthash,tbl_hashtag,tbl_post WHERE tbl_posthash.id_post = tbl_post.id AND tbl_posthash.id_hashtag = tbl_hashtag.id AND tbl_post.id ='" + id + "'",
				new Object[] {}, new RowMapper<Hashtag>() {
					public Hashtag mapRow(ResultSet rs, int rowNum) throws SQLException {
						Hashtag hashtag = new Hashtag();
						hashtag.setId(rs.getString("id"));
						hashtag.setName(rs.getString("name"));
						return hashtag;
					}
				});
		return posthashList;
	}

	@Override
	public List<Hashtag> getBestHashtag() {
		@SuppressWarnings("deprecation")
		List<Hashtag> posthashList = this.jdbcTemplate.query("SELECT DISTINCT tbl_hashtag.id,tbl_hashtag.name, "
				+ "SUM(tbl_posthash.id_hashtag = tbl_hashtag.id and tbl_post.id = tbl_posthash.id_post) as soluong"
				+ " from tbl_post,tbl_hashtag,tbl_posthash group by tbl_hashtag.id "
				+ "order by soluong desc LIMIT 10"
				+ "",
				new Object[] {}, new RowMapper<Hashtag>() {
					public Hashtag mapRow(ResultSet rs, int rowNum) throws SQLException {
						Hashtag hashtag = new Hashtag();
						hashtag.setId(rs.getString("id"));
						hashtag.setName(rs.getString("name"));
						return hashtag;
					}
				});
		return posthashList;
	}

}
