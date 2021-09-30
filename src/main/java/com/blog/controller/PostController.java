package com.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.entity.Post;
import com.blog.model.CategoryDTO;
import com.blog.model.PostDTO;
import com.blog.service.CategoryService;
import com.blog.service.HashtagService;
import com.blog.service.PostService;
import com.blog.service.PosthashService;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	PostService postService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	HashtagService hashtagService;
	@Autowired
	PosthashService posthashService;
	
	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String viewPost(HttpServletRequest request) {
		List<PostDTO> list = postService.getAll();
		request.setAttribute("listPost", list);
		return "admin/post/index";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		List<CategoryDTO> listCategory = categoryService.getAll();
		request.setAttribute("post",new Post());
		request.setAttribute("listCategory", listCategory);
		return "admin/post/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String addUser(ModelMap map, @ModelAttribute("post") PostDTO postDTO) {
		if(postService.insert(postDTO)>0) {
			return "redirect:/post/view";
		}else {
			return "false";
		}
	}
	
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, @RequestParam(name = "id") String id) { 
		PostDTO postDTO = postService.getDetail(id);
		List<CategoryDTO> listCategory = categoryService.getAll();
		CategoryDTO categoryDTO = categoryService.getDetail(postDTO.getId_category());
		request.setAttribute("listCategory", listCategory);
		request.setAttribute("post",postDTO);
		request.setAttribute("category",categoryDTO);
		return "admin/post/edit";
	}
	
	@RequestMapping(value = "post-edit", method = RequestMethod.POST)
	public String adminedit(@ModelAttribute("post") PostDTO postDTO, 
		@RequestParam(name = "title") String title,@RequestParam(name = "id") String id,
		@RequestParam(name = "content") String content, @RequestParam(name = "author") String author,
		@RequestParam(name = "img") String img,@RequestParam(name = "id_category") String id_category) {
		postDTO.setId(id);
		postDTO.setTitle(title);
		postDTO.setContent(content);
		postDTO.setAuthor(author);
//		postDTO.setDate(date);
		postDTO.setImg(img);
		postDTO.setId_category(id_category);
		if(postService.update(postDTO)) {
			return "redirect:/post/view";
		}else {
			return "redirect:/post/post-edit";
		}
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String admindelete(HttpServletRequest request,@ModelAttribute("Post") PostDTO postDTO, @RequestParam(name="id") String id) {
		if(postService.delete(id)) {
			return "redirect:/post/view";
		}else {
			return "redirect:/post/view";
		}	
	}
	
	
}
