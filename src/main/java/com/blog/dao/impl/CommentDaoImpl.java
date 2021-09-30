package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.blog.dao.CommentDao;
import com.blog.entity.Comment;
import com.blog.entity.CommentChart;
import com.blog.utils.DateUtils;

@Repository
public class CommentDaoImpl implements CommentDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Comment> getAll() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String sql = "select tbl_comment.id,tbl_comment.email,tbl_comment.name,tbl_comment.date,tbl_comment.content,tbl_comment.id_post,tbl_post.title from tbl_comment,tbl_post where tbl_post.id = tbl_comment.id_post\r\n"
						+ "";
				@SuppressWarnings("deprecation")
				List<Comment> listComment = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Comment>() {
					@Override
					public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						Comment comment = new Comment();
						comment.setId(rs.getInt("id"));
						comment.setName(rs.getString("name"));
						comment.setEmail(rs.getString("email"));
						comment.setDate(rs.getString("date"));
						comment.setContent(rs.getString("content"));
						comment.setId_post(rs.getString("id_post"));
						comment.setName_post(rs.getString("title"));
						return comment;
					}
				});
				return listComment;
	}

	@Override
	public int insert(Comment comment) {
		String sql = "insert into tbl_comment(email,name,date,content,id_post) values(?, ?, ?, ?, ?)";
		if (jdbcTemplate.update(sql, comment.getEmail(),comment.getName(),DateUtils.getTime(),comment.getContent(), comment.getId_post()) > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean update(Comment comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Comment comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from tbl_comment where id = ?";
		if (jdbcTemplate.update(sql, id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Comment getDetail(int id) {
		@SuppressWarnings("deprecation")
		Comment comment = this.jdbcTemplate.queryForObject("select * from tbl_comment where id ='" + id + "'", new Object[] {},
				new RowMapper<Comment>() {
					public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
						Comment comment = new Comment();
						comment.setId(rs.getInt("id"));
						comment.setName(rs.getString("name"));
						comment.setEmail(rs.getString("email"));
						comment.setDate(rs.getString("date"));
						comment.setContent(rs.getString("content"));
						comment.setId_post(rs.getString("id_post"));
//						post.setName_category(rs.getString("name_category"));
						return comment;
					}
				});
		return comment;
	}

	@Override
	public List<Comment> getListByPostId(String id) {
		String sql = "select * from tbl_comment,tbl_post where tbl_comment.id_post = tbl_post.id and tbl_comment.id_post ='" + id + "' ";
		@SuppressWarnings("deprecation")
		List<Comment> listComment = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Comment>() {
			@Override
			public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Comment comment = new Comment();
				comment.setId(rs.getInt("id"));
				comment.setName(rs.getString("name"));
				comment.setEmail(rs.getString("email"));
				comment.setDate(rs.getString("date"));
				comment.setContent(rs.getString("content"));
				comment.setId_post(rs.getString("id_post"));
				return comment;
			}
		});
		return listComment;
	}

	@Override
	public List<CommentChart> getChart() {
		String sql = "SELECT DISTINCT COUNT(tbl_comment.id) as amount, MONTH(tbl_comment.date) as month,tbl_comment.id,tbl_comment.email,tbl_comment.name,tbl_comment.date,tbl_comment.content,tbl_comment.id_post FROM tbl_comment GROUP BY MONTH(tbl_comment.date)"
				+ "";
		@SuppressWarnings("deprecation")
		List<CommentChart> listComment = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<CommentChart>() {
			@Override
			public CommentChart mapRow(ResultSet rs, int rowNum) throws SQLException {
				CommentChart comment = new CommentChart();
				comment.setAmount(rs.getInt("amount"));
				comment.setMonth(rs.getInt("month"));
				return comment;
			}
		});
		return listComment;
	}

	@Override
	public List<CommentChart> getChartDay() {
		String sql = "SELECT DISTINCT COUNT(tbl_comment.id) as amount, DAY(tbl_comment.date) as month FROM tbl_comment WHERE month(CURRENT_DATE()) = month(tbl_comment.date) GROUP BY DAY(tbl_comment.date)"
				+ "";
		@SuppressWarnings("deprecation")
		List<CommentChart> listComment = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<CommentChart>() {
			@Override
			public CommentChart mapRow(ResultSet rs, int rowNum) throws SQLException {
				CommentChart comment = new CommentChart();
				comment.setAmount(rs.getInt("amount"));
				comment.setMonth(rs.getInt("month"));
				return comment;
			}
		});
		return listComment;
	}

	@Override
	public List<CommentChart> getCommentSurvey() {
		String sql = "SELECT COUNT(tbl_comment.id) as amount, DAY(tbl_comment.date) as month FROM tbl_comment GROUP BY DAY(tbl_comment.date)"
				+ "";
		@SuppressWarnings("deprecation")
		List<CommentChart> listComment = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<CommentChart>() {
			@Override
			public CommentChart mapRow(ResultSet rs, int rowNum) throws SQLException {
				CommentChart comment = new CommentChart();
				comment.setAmount(rs.getInt("amount"));
				comment.setMonth(rs.getInt("month"));
				return comment;
			}
		});
		return listComment;
	}

}
