package com.blog.controller;

import java.lang.reflect.Array;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.entity.Posthash;
import com.blog.model.AdminDTO;
import com.blog.model.HashtagDTO;
import com.blog.model.PostDTO;
import com.blog.model.PosthashDTO;
import com.blog.service.HashtagService;
import com.blog.service.PostService;
import com.blog.service.PosthashService;

@Controller
@RequestMapping("/posthashtag")
public class PostHashtagController {

	@Autowired
	PosthashService posthashService;
	
	@Autowired
	HashtagService hashtagService;
	
	@Autowired
	PostService postService;
	
	@RequestMapping(value = "view")
	public String index(HttpServletRequest request){
		List<PosthashDTO> list = posthashService.getAll();
		request.setAttribute("listPosthash", list);
		return "admin/posthash/index";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		List<PostDTO> listPost = postService.getAll();
		List<HashtagDTO> listHashtag = hashtagService.getAll();
		request.setAttribute("posthash",new Posthash());
		request.setAttribute("listHashtag", listHashtag);
		request.setAttribute("listPost", listPost);
		return "admin/posthash/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addProcess(@ModelAttribute("posthash") PosthashDTO posthashDTO,@RequestParam("id_hashtag") String[] id_hashtag,@RequestParam("id_post") String id_post) {
		for (int i = 0; i < id_hashtag.length; i++) {
			System.out.println(Array.get(id_hashtag, i));
			String a = (String) Array.get(id_hashtag, i);
			posthashDTO.setId_hashtag(a);
			posthashDTO.setId_post(id_post);
			posthashService.insert(posthashDTO);
		}
		return "redirect:/posthashtag/view";
	}
	
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, @RequestParam(name = "id") int id) { 
		PosthashDTO posthashDTO = posthashService.getDetail(id);
		List<PostDTO> listPost = postService.getAll();
		List<HashtagDTO> listHashtag = hashtagService.getAll();
		PostDTO postDTO = postService.getDetail(posthashDTO.getId_post());
		HashtagDTO hashtagDTO = hashtagService.getDetail(posthashDTO.getId_hashtag());
//		ModelAndView model = new ModelAndView("editposthash");
		request.setAttribute("posthash",posthashDTO);
		request.setAttribute("listPost",listPost);
		request.setAttribute("listHashtag",listHashtag);
		request.setAttribute("post", postDTO);
		request.setAttribute("hashtag", hashtagDTO);
		return "admin/posthash/edit";
	}
	
	@RequestMapping(value = "posthash-edit", method = RequestMethod.POST)
	public String editProcess(@ModelAttribute("posthash") PosthashDTO posthashDTO, 
		@RequestParam(name = "id_post") String id_post,@RequestParam(name = "id_hashtag") String id_hashtag,@RequestParam(name = "id") int id) {
		posthashDTO.setId(id);
		posthashDTO.setId_post(id_post);
		posthashDTO.setId_hashtag(id_hashtag);		
		if(posthashService.update(posthashDTO)) {
			return "redirect:/posthashtag/view";
		}else {
			return "redirect:/posthashtag/view";
		}
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request,@ModelAttribute("posthash") AdminDTO adminDTO, @RequestParam(name="id") int id) {
		if(posthashService.delete(id)) {
			return "redirect:/posthashtag/view";
		}else {
			return "redirect:/posthashtag/view";
		}	
	}
}
