package com.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.CommentDao;
import com.blog.entity.Comment;
import com.blog.entity.CommentChart;
import com.blog.model.CommentChartDTO;
import com.blog.model.CommentDTO;
import com.blog.service.CommentService;
import com.blog.utils.DateUtils;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentDao commentDao;
	
	@Override
	public List<CommentDTO> getAll() {
		List<CommentDTO> listCommentDTO = new ArrayList<CommentDTO>();
		List<Comment> listComment = commentDao.getAll();
		for (Comment comment : listComment) {
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setId(comment.getId());
			commentDTO.setEmail(comment.getEmail());
			commentDTO.setName(comment.getName());
			commentDTO.setDate(comment.getDate());
			commentDTO.setContent(comment.getContent());
			commentDTO.setId_post(comment.getId_post());
			commentDTO.setName_post(comment.getName_post());
			listCommentDTO.add(commentDTO);
		}		
		return listCommentDTO;
	}

	@Override
	public int insert(CommentDTO commentDTO) {
		Comment comment = new Comment();
//		comment.setId(commentDTO.getId());
		comment.setEmail(commentDTO.getEmail());
		comment.setName(commentDTO.getName());
		comment.setDate(DateUtils.getTime());
		//System.out.println(DateUtils.getCurHH());
		comment.setContent(commentDTO.getContent());
		comment.setId_post(commentDTO.getId_post());
		if(commentDao.insert(comment)>0) 
				return 1;
		return 0;
	}

	@Override
	public boolean update(CommentDTO commentDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(CommentDTO commentDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		if(commentDao.delete(id)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public CommentDTO getDetail(int id) {
		Comment comment = new Comment();
		comment = commentDao.getDetail(id);
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setId(comment.getId());
			commentDTO.setEmail(comment.getEmail());
			commentDTO.setName(comment.getName());
			commentDTO.setDate(comment.getDate());
			commentDTO.setContent(comment.getContent());
			commentDTO.setId_post(comment.getId_post());
			return commentDTO;
	}

	@Override
	public List<CommentDTO> getListByPostId(String id) {
		List<CommentDTO> listCommentDTO = new ArrayList<CommentDTO>();
		List<Comment> listComment = commentDao.getListByPostId(id);
		for (Comment comment : listComment) {
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setId(comment.getId());
			commentDTO.setEmail(comment.getEmail());
			commentDTO.setName(comment.getName());
			commentDTO.setDate(comment.getDate());
			commentDTO.setContent(comment.getContent());
			commentDTO.setId_post(comment.getId_post());
			listCommentDTO.add(commentDTO);
		}		
		return listCommentDTO;
	}

	@Override
	public List<CommentChartDTO> getChart() {
		List<CommentChartDTO> listCommentDTO = new ArrayList<CommentChartDTO>();
		List<CommentChart> listComment = commentDao.getChart();
		for (CommentChart comment : listComment) {
			CommentChartDTO commentDTO = new CommentChartDTO();
			commentDTO.setAmount(comment.getAmount());
			commentDTO.setMonth(comment.getMonth());
			listCommentDTO.add(commentDTO);
		}		
		return listCommentDTO;
	}

	@Override
	public List<CommentChartDTO> getChartDay() {
		List<CommentChartDTO> listCommentDTO = new ArrayList<CommentChartDTO>();
		List<CommentChart> listComment = commentDao.getChartDay();
		for (CommentChart comment : listComment) {
			CommentChartDTO commentDTO = new CommentChartDTO();
			commentDTO.setAmount(comment.getAmount());
			commentDTO.setMonth(comment.getMonth());
			listCommentDTO.add(commentDTO);
		}		
		return listCommentDTO;
	}

	@Override
	public List<CommentChartDTO> getCommentSurvey() {
		List<CommentChartDTO> listCommentDTO = new ArrayList<CommentChartDTO>();
		List<CommentChart> listComment = commentDao.getCommentSurvey();
		for (CommentChart comment : listComment) {
			CommentChartDTO commentDTO = new CommentChartDTO();
			commentDTO.setAmount(comment.getAmount());
			commentDTO.setMonth(comment.getMonth());
			listCommentDTO.add(commentDTO);
		}		
		return listCommentDTO;
	}

}
