package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.blog.dao.PosthashDao;
import com.blog.entity.Post;
import com.blog.entity.Posthash;

@Repository
public class PosthashDaoImpl implements PosthashDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Posthash> getAll() {
		String sql = "select tbl_posthash.id,tbl_posthash.id_post,tbl_posthash.id_hashtag,tbl_post.title,tbl_hashtag.name"
				+ " from tbl_posthash,tbl_post,tbl_hashtag where tbl_posthash.id_post = tbl_post.id AND tbl_hashtag.id = tbl_posthash.id_hashtag";
		@SuppressWarnings("deprecation")
		List<Posthash> listPosthash = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Posthash>() {
			@Override
			public Posthash mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Posthash posthash = new Posthash();
				posthash.setId(rs.getInt("id"));
				posthash.setId_post(rs.getString("id_post"));
				posthash.setId_hashtag(rs.getString("id_hashtag"));
				posthash.setPost_title(rs.getString("title"));
				posthash.setHashtag_name(rs.getString("name"));
				return posthash;
			}
		});
		return listPosthash;
	}

	@Override
	public List<Posthash> getAllByPostId(String id) {
		@SuppressWarnings("deprecation")
		List<Posthash> posthashList = this.jdbcTemplate.query("select * from tbl_posthash where id_post ='" + id + "'",
				new Object[] {}, new RowMapper<Posthash>() {
					public Posthash mapRow(ResultSet rs, int rowNum) throws SQLException {
						Posthash posthash = new Posthash();
						posthash.setId(rs.getInt("id"));
						posthash.setId_post(rs.getString("id_post"));
						posthash.setId_hashtag(rs.getString("id_hashtag"));
						return posthash;
					}
				});
		return posthashList;
	}

	@Override
	public int insert(Posthash posthash) {
		String sql = "insert into tbl_posthash(id_post, id_hashtag) values(?, ?)";
		if (jdbcTemplate.update(sql, posthash.getId_post(), posthash.getId_hashtag()) > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean update(Posthash posthash) {
		String sql = "update tbl_posthash set id_post=?, id_hashtag=? where id = ?";
		if (jdbcTemplate.update(sql, posthash.getId_post(), posthash.getId_hashtag(), posthash.getId()) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Posthash posthash) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from tbl_posthash where id = ?";
		if (jdbcTemplate.update(sql, id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Posthash getDetail(int id) {
		@SuppressWarnings("deprecation")
		Posthash posthash = this.jdbcTemplate.queryForObject("select * from tbl_posthash where id ='" + id + "'",
				new Object[] {}, new RowMapper<Posthash>() {
					public Posthash mapRow(ResultSet rs, int rowNum) throws SQLException {
						Posthash posthash = new Posthash();
						posthash.setId(rs.getInt("id"));
						posthash.setId_post(rs.getString("id_post"));
						posthash.setId_hashtag(rs.getString("id_hashtag"));
						return posthash;
					}
				});
		return posthash;
	}
	
	public List<Post> getListPostRelateHashtag(String id){
//		tbl_post.id,tbl_post.title,tbl_post.content,tbl_post.author,tbl_post.date,tbl_post.img
				String sql = "SELECT DISTINCT tbl_post.id,tbl_post.title,tbl_post.content,tbl_post.author,tbl_post.date,tbl_post.img FROM tbl_posthash,tbl_post,tbl_hashtag WHERE tbl_posthash.id_post=tbl_post.id AND tbl_posthash.id_hashtag=tbl_hashtag.id AND tbl_posthash.id_hashtag = '"+id+"'";
				@SuppressWarnings("deprecation")
				List<Post> listPostRelated = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Post>() {
					@Override
					public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						Post post = new Post();
						post.setId(rs.getString("id"));
						post.setTitle(rs.getString("title"));
						post.setContent(rs.getString("content"));
						post.setAuthor(rs.getString("author"));
						post.setDate(rs.getString("date"));
						post.setImg(rs.getString("img"));
						return post;
					}
				});
				return listPostRelated;
	}

}
