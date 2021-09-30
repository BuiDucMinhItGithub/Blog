package com.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.entity.Admin;
import com.blog.model.AdminDTO;
import com.blog.model.CategoryDTO;
import com.blog.model.CommentChartDTO;
import com.blog.model.CommentDTO;
import com.blog.model.HashtagDTO;
import com.blog.model.PostDTO;
import com.blog.service.AdminService;
import com.blog.service.CategoryService;
import com.blog.service.CommentService;
import com.blog.service.HashtagService;
import com.blog.service.PostService;








@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	PostService postService;
	@Autowired
	CommentService commentService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	HashtagService hashtagService;


	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String index(HttpServletRequest request){
		List<AdminDTO> list = adminService.getAll();
		request.setAttribute("listUser", list);
		return "admin/admin/index";
	}
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String indexOne(HttpServletRequest request){
		List<PostDTO> postChart = postService.getChart();
		List<CommentChartDTO> commentChart = commentService.getChart();
		List<CommentChartDTO> commentChartDay = commentService.getChartDay();
		List<CommentChartDTO> commentChartSurvey = commentService.getCommentSurvey();
		List<PostDTO> list = postService.getAll();
		List<CategoryDTO> listCategory = categoryService.getAll();
		List<HashtagDTO> listHashtag = hashtagService.getAll();
		List<CommentDTO> listComment = commentService.getAll();
		List<AdminDTO> listAdmin = adminService.getAll();
		int sizepost = list.size();
		int sizecat = listCategory.size();
		int sizehashtag = listHashtag.size();
		int sizeadmin = listAdmin.size();
		int sizecomment = listComment.size();
		
		request.setAttribute("sizepost", sizepost);
		request.setAttribute("sizecat", sizecat);
		request.setAttribute("sizehashtag", sizehashtag);
		request.setAttribute("sizeadmin", sizeadmin);
		request.setAttribute("sizecomment", sizecomment);
		request.setAttribute("postChart", postChart);
		request.setAttribute("commentChart", commentChart);
		request.setAttribute("commentChartDay", commentChartDay);
		request.setAttribute("commentChartSurvey", commentChartSurvey);
		return "admin/admin/main";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
	       model.addAttribute("title", "Logout");
	       return "admin/admin/login";
	}

	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addUser(Model model) {
		model.addAttribute("admin",new Admin());
		return "admin/admin/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addProcess(ModelMap map, @ModelAttribute("admin") AdminDTO adminDTO) {
		if(adminService.insert(adminDTO)>0) {
			return "redirect:/admin/view";
		}else {
			return "redirect:/admin/add";
		}
	}
	
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public ModelAndView edit(HttpServletRequest request, @RequestParam(name = "id") String id) { 
		AdminDTO adminDTO = adminService.getDetail(id);
		ModelAndView model = new ModelAndView("admin/admin/edit");
		model.addObject("admin",adminDTO);
		System.out.println(adminDTO);
		return model;
	}
	
	@RequestMapping(value = "admin-edit", method = RequestMethod.POST)
	public String adminProcess(@ModelAttribute("admin") AdminDTO adminDTO, 
		@RequestParam(name = "name") String name,@RequestParam(name = "id") String id,
		@RequestParam(name = "password") String password, @RequestParam(name = "state") int state,
		@RequestParam(name = "role") String role) {
		adminDTO.setId(id);
		adminDTO.setName(name);
		adminDTO.setPassword(password);
		adminDTO.setState(state);
		adminDTO.setRole(role);
		if(adminService.update(adminDTO)) {
			return "redirect:/admin/view";
		}else {
			return "redirect:/admin/edit";
		}
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String admindelete(HttpServletRequest request,@ModelAttribute("admin") AdminDTO adminDTO, @RequestParam(name="id") String id) {
		if(adminService.delete(id)) {
			return "redirect:/admin/view";
		}else {
			return "redirect:/adminview";
		}	
	}
	
	@RequestMapping(value = "403", method = RequestMethod.GET)
	public String denied(HttpServletRequest request) {
		request.setAttribute("message", "Bạn không có đủ quyền để truy cập trang này");
		return "/403";
	}
	
}
