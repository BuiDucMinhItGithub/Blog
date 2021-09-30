package com.blog.service;

import java.util.List;

import com.blog.model.CommentChartDTO;
import com.blog.model.CommentDTO;

public interface CommentService {
	List<CommentDTO> getAll();
	int insert(CommentDTO commentDTO);
	boolean update(CommentDTO commentDTO);
	boolean delete(CommentDTO commentDTO);
	boolean delete(int id);
	CommentDTO getDetail(int id);
	List<CommentDTO> getListByPostId(String id);
	List<CommentChartDTO> getChart();
	List<CommentChartDTO> getChartDay();
	List<CommentChartDTO> getCommentSurvey();
}	
