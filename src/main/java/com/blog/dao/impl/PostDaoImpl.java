package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.blog.dao.PostDao;
import com.blog.entity.Post;
import com.blog.utils.DateUtils;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Post> getAll() {
		String sql = "SELECT tbl_post.id,tbl_post.title,tbl_post.content,"
				+ "tbl_post.author,tbl_post.date,tbl_post.img,tbl_post.number_comment,"
				+ "tbl_post.id_category,tbl_category.name "
				+ "FROM tbl_post,tbl_category "
				+ "WHERE tbl_post.id_category = tbl_category.id";
		@SuppressWarnings("deprecation")
		List<Post> listPost = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Post>() {
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
				post.setId_category(rs.getString("id_category"));
				post.setName_category(rs.getString("name"));
				post.setSoLuongBinhLuan(rs.getInt("number_comment"));
				return post;

			}
		});
		return listPost;
	}
	
	@Override
	public List<Post> getListByCategoryId(String id) {
		String sql = "SELECT * FROM tbl_post,tbl_category WHERE tbl_post.id_category=tbl_category.id AND tbl_post.id_category = '"+id+"'";
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
				post.setId_category(rs.getString("id_category"));
				post.setSoLuongBinhLuan(rs.getInt("number_comment"));
//				post.setName_category(rs.getString("name_category"));
				return post;

			}
		});
		return listPostRelated;
	}

	@Override
	public int insert(Post post) {
		String sql = "insert into tbl_post(id, title, content,author,date,img,id_category,number_number) values(?, ?, ?, ?, ?, ?, ?,null)";
			if (jdbcTemplate.update(sql, post.getId(), post.getTitle(), post.getContent(), post.getAuthor(), DateUtils.getTime(),
					post.getImg(),post.getId_category()) > 0) {
				return 1;
			}
		return 0;
	}

	@Override
	public boolean update(Post post) {
		String sql = "update tbl_post set title=?, content=?, author=?, img =?, id_category = ? where id = ?";
		if (jdbcTemplate.update(sql, post.getTitle(), post.getContent(), post.getAuthor(), post.getImg(),post.getId_category(),
				post.getId()) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Post post) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		String sql = "delete from tbl_post where id = ?";
		if (jdbcTemplate.update(sql, id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Post getDetail(String id) {
		@SuppressWarnings("deprecation")
		Post post = this.jdbcTemplate.queryForObject("select * from tbl_post where id ='" + id + "'", new Object[] {},
				new RowMapper<Post>() {
					public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
						Post post = new Post();
						post.setId(rs.getString("id"));
						post.setTitle(rs.getString("title"));
						post.setContent(rs.getString("content"));
						post.setAuthor(rs.getString("author"));
						post.setDate(rs.getString("date"));
						post.setImg(rs.getString("img"));
						post.setId_category(rs.getString("id_category"));
						post.setSoLuongBinhLuan(rs.getInt("number_comment"));
//						post.setName_category(rs.getString("name_category"));
						return post;
					}
				});
		return post;
	}

	@Override
	public List<Post> getRandom() {
		String sql = "SELECT * FROM tbl_post ORDER BY tbl_post.title LIMIT 20";
		@SuppressWarnings("deprecation")
		List<Post> listPostRandom = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Post>() {
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
				post.setId_category(rs.getString("id_category"));
//				post.setName_category(rs.getString("name_category"));
				return post;

			}
		});
		return listPostRandom;
	}

	@Override
	public List<Post> getPostByCategoryId(String id) {
		String sql = "SELECT * FROM tbl_post,tbl_category WHERE tbl_post.id_category=tbl_category.id AND tbl_post.id_category = '"+id+"'";
		@SuppressWarnings("deprecation")
		List<Post> listPostByCategoryId = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Post>() {
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
				post.setId_category(rs.getString("id_category"));
				post.setSoLuongBinhLuan(rs.getInt("number_comment"));
//				post.setName_category(rs.getString("name_category"));
				return post;

			}
		});
		return listPostByCategoryId;
	}

	@Override
	public List<Post> getPostByKey(String key) {
		String sql = "SELECT * FROM tbl_post WHERE tbl_post.title like '%"+key+"%'";
		@SuppressWarnings("deprecation")
		List<Post> listPostByCategoryId = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Post>() {
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
				post.setId_category(rs.getString("id_category"));
				post.setSoLuongBinhLuan(rs.getInt("number_comment"));
//				post.setName_category(rs.getString("name_category"));
				return post;

			}
		});
		return listPostByCategoryId;
	}

	
	@Override
	public List<Post> getListPostByIdHashtag(String id) {
		String sql = "SELECT DISTINCT tbl_post.id,tbl_post.title,"
				+ "tbl_post.content,tbl_post.author,tbl_post.date,tbl_post.img,tbl_post.id_category,tbl_post.number_comment,"
				+ "tbl_posthash.id_hashtag,tbl_posthash.id_hashtag,tbl_hashtag.id FROM tbl_posthash,tbl_post,tbl_hashtag"
				+ " WHERE tbl_post.id = tbl_posthash.id_post and tbl_posthash.id_hashtag = tbl_hashtag.id AND tbl_hashtag.id = '"+id+"'";
		@SuppressWarnings("deprecation")
		List<Post> listPost = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Post>() {
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
				post.setId_category(rs.getString("id_category"));
				post.setSoLuongBinhLuan(rs.getInt("number_comment"));
//				post.setName_category(rs.getString("name"));
				return post;

			}
		});
		return listPost;
	}

	@Override
	public List<Post> getPostByCategoryIdWithLimit(String id, int start, int end) {
		String sql = "SELECT * FROM tbl_post,tbl_category WHERE tbl_post.id_category=tbl_category.id AND tbl_post.id_category = '"+id+"' LIMIT "+start+","+end+"";
		@SuppressWarnings("deprecation")
		List<Post> listPostByCategoryId = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Post>() {
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
				post.setId_category(rs.getString("id_category"));
				post.setSoLuongBinhLuan(rs.getInt("number_comment"));
//				post.setName_category(rs.getString("name_category"));
				return post;

			}
		});
		return listPostByCategoryId;
	}

	@Override
	public List<Post> getPostByKeyWithLimit(String key, int start, int end) {
		String sql = "SELECT * FROM tbl_post WHERE tbl_post.title like '%"+key+"%' LIMIT "+start+","+end+"";
		@SuppressWarnings("deprecation")
		List<Post> listPostByCategoryId = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Post>() {
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
				post.setId_category(rs.getString("id_category"));
				post.setSoLuongBinhLuan(rs.getInt("number_comment"));
				return post;

			}
		});
		return listPostByCategoryId;
	}

	@Override
	public List<Post> getListPostByIdHashtagWithLimit(String id, int start, int end) {
		String sql = "SELECT DISTINCT tbl_post.id,tbl_post.title,"
				+ "tbl_post.content,tbl_post.author,tbl_post.date,tbl_post.img,tbl_post.id_category,tbl_post.number_comment,"
				+ "tbl_posthash.id_hashtag,tbl_posthash.id_hashtag,tbl_hashtag.id FROM tbl_posthash,tbl_post,tbl_hashtag"
				+ " WHERE tbl_post.id = tbl_posthash.id_post and tbl_posthash.id_hashtag = tbl_hashtag.id AND tbl_hashtag.id = '"+id+"' LIMIT "+start+","+end+"";
		@SuppressWarnings("deprecation")
		List<Post> listPost = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Post>() {
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
				post.setId_category(rs.getString("id_category"));
				post.setSoLuongBinhLuan(rs.getInt("number_comment"));
//				post.setName_category(rs.getString("name"));
				return post;

			}
		});
		return listPost;
	}
//SELECT tbl_post.title, count(tbl_comment.name) as tong FROM ((tbl_post INNER JOIN tbl_comment ON tbl_post.id = tbl_comment.id_post) INNER JOIN tbl_category ON tbl_post.id_category = tbl_category.id) group by tbl_comment.id

	@Override
	public List<Post> getAllWithLimit(int start, int end) {
		String sql = "SELECT tbl_post.id,tbl_post.title,tbl_post.content,"
				+ "tbl_post.author,tbl_post.date,tbl_post.img,"
				+ "tbl_post.id_category,tbl_category.name,tbl_post.number_comment "
				+ "FROM tbl_post,tbl_category "
				+ "WHERE tbl_post.id_category = tbl_category.id LIMIT "+start+","+end+"";
		@SuppressWarnings("deprecation")
		List<Post> listPost = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Post>() {
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
				post.setId_category(rs.getString("id_category"));
				post.setName_category(rs.getString("name"));
				post.setSoLuongBinhLuan(rs.getInt("number_comment"));
				return post;

			}
		});
		return listPost;
	}

	@Override
	public List<Post> getNewestList() {
		String sql = "SELECT * FROM tbl_post ORDER BY tbl_post.date DESC LIMIT 16";
		@SuppressWarnings("deprecation")
		List<Post> listPostRandom = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Post>() {
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
				post.setId_category(rs.getString("id_category"));
//				post.setName_category(rs.getString("name_category"));
				return post;

			}
		});
		return listPostRandom;
	}

	@Override
	public List<Post> getChart() {
		String sql = "SELECT COUNT(tbl_post.title) as tong, tbl_post.id, tbl_post.title,tbl_post.content,tbl_post.author,tbl_post.date,tbl_post.img,tbl_post.id_category, MONTH(tbl_post.date) as month FROM tbl_post GROUP BY MONTH(tbl_post.date)";
		@SuppressWarnings("deprecation")
		List<Post> listPostRandom = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Post>() {
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
				post.setId_category(rs.getString("id_category"));
				post.setAmount(rs.getInt("tong"));
				post.setMonth(rs.getString("month"));
				return post;

			}
		});
		return listPostRandom;
		
	}

	@Override
	public List<Post> getBestReact() {
		String sql = "SELECT DISTINCT tbl_post.title,tbl_post.id, COUNT(*) AS tong, SUM(tbl_post.id = tbl_comment.id_post) as soluong "
				+ "from tbl_post,tbl_comment group by tbl_post.id order by soluong desc LIMIT 12"
				+ "";
		@SuppressWarnings("deprecation")
		List<Post> listPostRandom = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Post>() {
			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Post post = new Post();
				post.setId(rs.getString("id"));
				post.setTitle(rs.getString("title"));
				post.setSoLuongBinhLuan(rs.getInt("soluong"));
				return post;

			}
		});
		return listPostRandom;
	}

	@Override
	public List<Post> getOldestList() {
		String sql = "SELECT * FROM tbl_post ORDER BY tbl_post.date ASC LIMIT 13";
		@SuppressWarnings("deprecation")
		List<Post> listPostRandom = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Post>() {
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
				post.setId_category(rs.getString("id_category"));
//				post.setName_category(rs.getString("name_category"));
				return post;

			}
		});
		return listPostRandom;
	}

	

	@Override
	public boolean update(String id) {
		String sql = "UPDATE tbl_post SET tbl_post.number_comment = (SELECT sum(tbl_post.id=tbl_comment.id_post) as soluong FROM tbl_post,tbl_comment WHERE tbl_post.id = ?) + 1 WHERE tbl_post.id = ?";
		if (jdbcTemplate.update(sql, id,id) > 0) {
			return true;
		}
		return false;
	}

}
