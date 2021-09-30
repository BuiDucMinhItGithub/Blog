package com.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.entity.Category;
import com.blog.model.AdminDTO;
import com.blog.model.CategoryDTO;
import com.blog.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "view")
	public String index(HttpServletRequest request){
		List<CategoryDTO> list = categoryService.getAll();
		request.setAttribute("listCat", list);
		return "admin/category/index";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("category",new Category());
		return "admin/category/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addProcess(HttpServletRequest request, @ModelAttribute("category") CategoryDTO categoryDTO) {
		if(categoryService.insert(categoryDTO)>0) {
			return "redirect:/category/view";
		}else {
			return "redirect:/category/add";
		}
	}
	
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, @RequestParam(name = "id") String id) { 
		CategoryDTO categoryDTO = categoryService.getDetail(id);
//		ModelAndView model = new ModelAndView("editcategory");
//		model.addObject("category",categoryDTO);
		request.setAttribute("category", categoryDTO);
		return "admin/category/edit";
	}
	
	@RequestMapping(value = "category-edit", method = RequestMethod.POST)
	public String editProcess(@ModelAttribute("category") CategoryDTO categoryDTO, 
		@RequestParam(name = "name") String name,@RequestParam(name = "img") String img,@RequestParam(name = "id") String id) {
		categoryDTO.setId(id);
		categoryDTO.setName(name);
		categoryDTO.setImg(img);
		if(categoryService.update(categoryDTO)) {
			return "redirect:/category/view";
		}else {
			return "redirect:/category/view";
		}
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request,@ModelAttribute("admin") AdminDTO adminDTO, @RequestParam(name="id") String id) {
		if(categoryService.delete(id)) {
			return "redirect:/category/view";
		}else {
			return "redirect:/category/view";
		}	
	}
	
}
