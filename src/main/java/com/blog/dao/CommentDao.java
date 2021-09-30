package com.blog.dao;

import java.util.List;

import com.blog.entity.Comment;
import com.blog.entity.CommentChart;

public interface CommentDao {
	List<Comment> getAll();
	int insert(Comment comment);
	boolean update(Comment comment);
	boolean delete(Comment comment);
	boolean delete(int id);
	Comment getDetail(int id);
	List<Comment> getListByPostId(String id);
	List<CommentChart> getChart();
	List<CommentChart> getChartDay();
	List<CommentChart> getCommentSurvey();
}
