package com.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.entity.Hashtag;
import com.blog.model.HashtagDTO;
import com.blog.service.HashtagService;

@Controller
@RequestMapping("/hashtag")
public class HashtagController {
	@Autowired
	HashtagService hashtagService;
	
	@RequestMapping(value = "view")
	public String index(HttpServletRequest request){
		List<HashtagDTO> list = hashtagService.getAll();
		request.setAttribute("listHashtag", list);
		return "admin/hashtag/index";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(HttpServletRequest request) {
		request.setAttribute("hashtag",new Hashtag());
		return "admin/hashtag/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addProcess(HttpServletRequest request, @ModelAttribute("hashtag") HashtagDTO hashtagDTO) {
		if(hashtagService.insert(hashtagDTO)>0) {
			return "redirect:/hashtag/view";
		}else {
			return "redirect:/hashtag/add";
		}
	}
	
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, @RequestParam(name = "id") String id) { 
		HashtagDTO hashtagDTO = hashtagService.getDetail(id);
		request.setAttribute("hashtag",hashtagDTO);
		return "admin/hashtag/edit";
	}
	
	@RequestMapping(value = "hashtag-edit", method = RequestMethod.POST)
	public String editProcess(@ModelAttribute("hashtag") HashtagDTO hashtagDTO, 
		@RequestParam(name = "name") String name,@RequestParam(name = "id") String id) {
		hashtagDTO.setId(id);
		hashtagDTO.setName(name);
		if(hashtagService.update(hashtagDTO)) {
			return "redirect:/hashtag/view";
		}else {
			return "redirect:/hashtag/view";
		}
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request,@ModelAttribute("hashtag") HashtagDTO hashtagDTO, @RequestParam(name="id") String id) {
		if(hashtagService.delete(id)) {
			return "redirect:/hashtag/view";
		}else {
			return "redirect:/hashtag/view";
		}	
	}
}
