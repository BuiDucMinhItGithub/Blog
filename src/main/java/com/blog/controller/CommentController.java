package com.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.model.CommentDTO;
import com.blog.service.CommentService;

@Controller
@RequestMapping("comment")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String index(HttpServletRequest request){
		List<CommentDTO> list = commentService.getAll();
		request.setAttribute("listComment", list);
		return "admin/comment/index";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String admindelete(HttpServletRequest request, @RequestParam(name="id") int id) {
		if(commentService.delete(id)) {
			return "redirect:/comment/view";
		}else {
			return "redirect:/comment/view";
		}	
	}
}
