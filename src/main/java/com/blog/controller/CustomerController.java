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
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.entity.Customer;
import com.blog.model.CategoryDTO;
import com.blog.model.CommentDTO;
import com.blog.model.CustomerDTO;
import com.blog.model.HashtagDTO;
import com.blog.model.PostDTO;
import com.blog.service.CategoryService;
import com.blog.service.CommentService;
import com.blog.service.CustomerService;
import com.blog.service.HashtagService;
import com.blog.service.PostService;
import com.blog.service.PosthashService;
import com.blog.utils.StringUtils;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@Autowired
	PostService postService;
	@Autowired
	PosthashService posthashService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	CommentService commentService;
	@Autowired
	HashtagService hashtagService;
	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String index(HttpServletRequest request){
		List<CustomerDTO> list = customerService.getAll();
		request.setAttribute("listCus", list);
		return "admin/customer/index";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addUser(Model model) {
		model.addAttribute("customer",new Customer());
		return "admin/customer/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addProcess(@ModelAttribute("customer") CustomerDTO customerDTO) {
		String a = "";
		if(customerService.insert(customerDTO)>0) {
			 a = "redirect:/customer/view";
		}else {
			 a= "redirect:/customer/add";
		}
		return a;
	}
	
	@RequestMapping(value="edit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, @RequestParam(name = "id") int id) { 
		CustomerDTO customerDTO = customerService.getDetail(id);
		request.setAttribute("customer",customerDTO);
		return "admin/customer/edit";
	}
	
	@RequestMapping(value = "customer-edit", method = RequestMethod.POST)
	public String editProcess(@ModelAttribute("customer") CustomerDTO customerDTO, 
		@RequestParam(name = "name") String name,@RequestParam(name = "id") int id, @RequestParam(name = "state") int state) {
		customerDTO.setId(id);
		customerDTO.setName(name);
		customerDTO.setState(state);
		if(customerService.update(customerDTO)) {
			return "redirect:/customer/view";
		}else {
			return "redirect:/customer/edit";
		}
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String admindelete(@RequestParam(name="id") int id) {
		customerService.delete(id);
		return "redirect:/customer/view";
	}
	
	@RequestMapping(value = {"index","/"}, method = RequestMethod.GET)
	public String trangchu(HttpServletRequest request,@RequestParam(name = "limit", required = false) int limit){
		int record_per_page = 16;
		int start = (limit-1) * record_per_page;
		int end = start+record_per_page;
		int max = 0;
		List<PostDTO> listPost = postService.getAll();
		max = listPost.size();
		List<PostDTO> listPostWithLimit = postService.getAllWithLimit(0,end);
		List<PostDTO> listPostRandom = postService.getRandom();
		List<PostDTO> listPostNewest = postService.getNewestList();
		List<PostDTO> listPostOldest = postService.getOldestList();
		List<CategoryDTO> listCat = categoryService.getAll();
		List<HashtagDTO> listHashtag = hashtagService.getAll();
		List<PostDTO> listBestReact = postService.getBestReact();
		List<HashtagDTO> listBestHashtag = hashtagService.getBestHashtag();
		request.setAttribute("listBestHashtag", listBestHashtag);
		request.setAttribute("listHashtag", listHashtag);
		request.setAttribute("listPost", listPost);
		request.setAttribute("listCat", listCat);
		request.setAttribute("listPostRandom", listPostRandom);
		request.setAttribute("listPostWithLimit", listPostWithLimit);
		request.setAttribute("listPostNewest", listPostNewest);
		request.setAttribute("listPostOldest", listPostOldest);
		request.setAttribute("listBestReact", listBestReact);
		request.setAttribute("max", max);
		return "user/trangchu";
	}
	
	@RequestMapping(path = "indexload",produces = "text/plain;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	public String indexLoad(HttpServletRequest request,@RequestParam(name = "limit", required = false) int limit){
		List<PostDTO> listPost = postService.getAll();
		int max = listPost.size();
		int record_per_page = 16;
		int start = (limit-1) * record_per_page;
		int end = start+record_per_page;
		String html = "";
		List<PostDTO> listPostWithLimit = postService.getAllWithLimit(0,end);	
		html += "<nav class='navbar navbar-expand-sm section__header'>";
		html += "<h3>Bài đăng</h3>";
		html += "<div class='navbar-nav ml-auto'>";
		html += "<div class='section__header-btn'></div>";
		html += "</div>";
		html += "</nav>";
		for (PostDTO postDTO : listPostWithLimit) {
			html += "<div class='section__article mt-3'>";
			html += "<div class='section__article-img'>";
			html += "<a href='detail?id="+postDTO.getId()+"'><div style='width: 100%'>"+postDTO.getImg()+"</div></a>";
			html += "</div>";
			html += "<div class='section__article-txtarticle row mt-2'>";
			html += "<div class='txtarticle__title col-sm-12'>";
			html += "<a href='detail?id="+postDTO.getId()+"'>";
			html += "<h4 id='h4_text'>"+postDTO.getTitle()+"</h4>";
			html += "</a>";
			html += "</div>";
			html += "<div class='txtarticle__language mt-3'>";
			html += "<span id='date_post'>"+postDTO.getDate()+"</span> <span id='author_post'>"+postDTO.getAuthor()+"</span>";
			html += "</div>";
			html += "<div class='txtarticle__comment'>";
			html += "<div class='txtarticle__comment-icon'>";
			html += "<a href=''>";
			html += " <span id='comment_space'><i class='fa fa-comment-o' aria-hidden='true'></i></i></span>";
			html += "<span> "+postDTO.getSoLuongBinhLuan()+" Bình luận</span>";
			html += " </a>";
			html += "</div>";
			html += "</div>";
			html += "</div>";
			html += "</div>";
		}
		List<PostDTO> listPostRandom = postService.getRandom();
		List<CategoryDTO> listCat = categoryService.getAll();
		List<HashtagDTO> listHashtag = hashtagService.getAll();
		List<PostDTO> listPostNewest = postService.getNewestList();
//		List<HashtagDTO> listBestHashtag = hashtagService.getBestHashtag();
//		request.setAttribute("listBestHashtag", listBestHashtag);
		request.setAttribute("listPostNewest", listPostNewest);
		request.setAttribute("listHashtag", listHashtag);
		request.setAttribute("listPost", listPost);
		request.setAttribute("listCat", listCat);
		request.setAttribute("listPostRandom", listPostRandom);
		request.setAttribute("listPostWithLimit", listPostWithLimit);
		
		request.setAttribute("max", max);
		return html;
	}
	
	
	
	@RequestMapping(value = "list", method = { RequestMethod.GET, RequestMethod.POST })
	public String danhsachbaiviet(HttpServletRequest request,Model mol,
			@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "key", required = false) String key,
			@RequestParam(name = "tag", required = false) String tag,
			@RequestParam(name = "limit", required = false) int limit){

		int record_per_page = 8;
		int start = (limit-1) * record_per_page;
		int end = start+record_per_page;
		int max = 0;
		request.setAttribute("Title", "Danh sách bài viết");
		if(key != null) {
			List<PostDTO> listPostByKeyWithoutLimit = postService.getPostByKey(key);
			max = listPostByKeyWithoutLimit.size();
			List<PostDTO> listPostByKey = postService.getPostByKeyWithLimit(key,0,end);
			List<CategoryDTO> listCategory = categoryService.getAll();
			List<HashtagDTO> listHashtag = hashtagService.getAll();
			List<HashtagDTO> listBestHashtag = hashtagService.getBestHashtag();
			request.setAttribute("listBestHashtag", listBestHashtag);
			request.setAttribute("listHashtag", listHashtag);
			request.setAttribute("listPost", listPostByKey);
			request.setAttribute("listCategory", listCategory);
			request.setAttribute("max", max);
		}
		if(id != null) {
			List<CategoryDTO> listCategory = categoryService.getAll();
			List<PostDTO> listPostByCategoryIdWithoutLimit = postService.getPostByCategoryId(id);
			max = listPostByCategoryIdWithoutLimit.size();
			List<PostDTO> listPostByCategoryId = postService.getPostByCategoryIdWithLimit(id,0,end);
			List<HashtagDTO> listHashtag = hashtagService.getAll();
			List<HashtagDTO> listBestHashtag = hashtagService.getBestHashtag();
			request.setAttribute("listBestHashtag", listBestHashtag);
			request.setAttribute("listHashtag", listHashtag);
			request.setAttribute("listPost", listPostByCategoryId);
			request.setAttribute("listCategory", listCategory);
			request.setAttribute("max", max);
		}
		if(tag != null) {
			List<HashtagDTO> listHashtag = hashtagService.getAll();
			List<CategoryDTO> listCategory = categoryService.getAll();
			List<PostDTO> listPostByHashtagIdWithoutLimit = postService.getListPostByIdHashtag(tag);
			max = listPostByHashtagIdWithoutLimit.size();
			List<PostDTO> listPostByHashtagId = postService.getListPostByIdHashtagWithLimit(tag,0,end);
			List<HashtagDTO> listBestHashtag = hashtagService.getBestHashtag();
			request.setAttribute("listBestHashtag", listBestHashtag);
			request.setAttribute("listPost", listPostByHashtagId);
			request.setAttribute("listCategory", listCategory);
			request.setAttribute("listHashtag", listHashtag);
			request.setAttribute("max", max);
			
		}
		return "user/danhsachbaiviet";
	}
	
	
	@RequestMapping(path = "listload", produces = "text/plain;charset=utf-8", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String listload(HttpServletRequest request, 
			@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "key", required = false) String key,
			@RequestParam(name = "tag", required = false) String tag,
			@RequestParam(name = "limit", required = false) int limit){
		String html = "";
		int record_per_page = 8;
		int start = (limit-1) * record_per_page;
		int end = start+record_per_page;
		int max = 0;
		 if(id != null) {
			List<CategoryDTO> listCategory = categoryService.getAll();
			List<PostDTO> listPostByCategoryIdWhitoutLimitEnd = postService.getPostByCategoryId(id);
			max = listPostByCategoryIdWhitoutLimitEnd.size();
			List<PostDTO> listPostByCategoryId = postService.getPostByCategoryIdWithLimit(id,0,end);
			for(PostDTO postDTO : listPostByCategoryId) {
					html += "<div class='col-lg-6 pd__listing-section' id='posthere'>";
						html += "<div class='section__article section__article-listing'>";
							html += "<div class='section__article-img-list'>";
								html += "<a href='detail?id="+postDTO.getId()+"'><div style='width: 100%'>"+postDTO.getImg()+"</div></a>";
							html += "</div>";
							html += "<div class='section__article-txtarticle'>";
								html += "<div class='txtarticle__title col-sm-12 mt-3'>";
									html += "<a href='detail?id="+postDTO.getId()+"'>";
										html += "<h4 id='h4_text'>"+postDTO.getTitle()+"</h4>";
									html += "</a>";
								html += "</div>";
								html += "<div class='txtarticle__language mt-2'>";
									html += "<span id='date_post'>"+postDTO.getDate()+"</span> <span id='author_post'>"+postDTO.getAuthor()+"</span>";
								html += "</div>";
								html += "<div class='txtarticle__comment'>";
									html += "<div class='txtarticle__comment-icon'>";
										html += " <a href=''>";
											html += " <span><i class='fa fa-comment-o' aria-hidden='true'></i></i></span>";
											html += "<span> "+postDTO.getSoLuongBinhLuan()+" Bình luận</span>";
											html += "</a>";
									html += "</div>";
								html += "</div>";
							html += "</div>";
						html += "</div>";
					html += "</div>";
			}		
			List<HashtagDTO> listHashtag = hashtagService.getAll();
			request.setAttribute("listHashtag", listHashtag);
			request.setAttribute("listPost", listPostByCategoryId);
			request.setAttribute("listCategory", listCategory);
			request.setAttribute("max", max);
		}
		 if(tag != null) {
			List<HashtagDTO> listHashtag = hashtagService.getAll();
			List<CategoryDTO> listCategory = categoryService.getAll();
			List<PostDTO> listPostByHashtagIdWithoutLimit = postService.getListPostByIdHashtag(tag);
			max = listPostByHashtagIdWithoutLimit.size();
			List<PostDTO> listPostByHashtagId = postService.getListPostByIdHashtagWithLimit(tag, 0, end);
			for(PostDTO postDTO : listPostByHashtagId) {
				html += "<div class='col-lg-6 pd__listing-section' id='posthere'>";
				html += "<div class='section__article section__article-listing'>";
					html += "<div class='section__article-img-list'>";
						html += "<a href='detail?id="+postDTO.getId()+"'><div style='width: 100%'>"+postDTO.getImg()+"</div></a>";
					html += "</div>";
					html += "<div class='section__article-txtarticle'>";
						html += "<div class='txtarticle__title col-sm-12 mt-3'>";
							html += "<a href='detail?id="+postDTO.getId()+"'>";
								html += "<h4 id='h4_text'>"+postDTO.getTitle()+"</h4>";
							html += "</a>";
						html += "</div>";
						html += "<div class='txtarticle__language mt-2'>";
							html += "<span id='date_post'>"+postDTO.getDate()+"</span> <span id='author_post'>"+postDTO.getAuthor()+"</span>";
						html += "</div>";
						html += "<div class='txtarticle__comment'>";
							html += "<div class='txtarticle__comment-icon'>";
								html += " <a href=''>";
									html += " <span><i class='fa fa-comment-o' aria-hidden='true'></i></i></span>";
									html += "<span> "+postDTO.getSoLuongBinhLuan()+" Bình luận</span>";
									html += "</a>";
							html += "</div>";
						html += "</div>";
					html += "</div>";
				html += "</div>";
			html += "</div>";
		}		
			request.setAttribute("listPost", listPostByHashtagId);
			request.setAttribute("listCategory", listCategory);
			request.setAttribute("listHashtag", listHashtag);
			request.setAttribute("max", max);
		}
		 if(key != null) {
			 	List<PostDTO> listPostByKeyWithoutLimit = postService.getPostByKey(key);
				max = listPostByKeyWithoutLimit.size();
				List<PostDTO> listPostByKey = postService.getPostByKeyWithLimit(key,0,end);
				for(PostDTO postDTO : listPostByKey) {
					html += "<div class='col-lg-6 pd__listing-section' id='posthere'>";
					html += "<div class='section__article section__article-listing'>";
						html += "<div class='section__article-img-list'>";
							html += "<a href='detail?id="+postDTO.getId()+"'><div style='width: 100%'>"+postDTO.getImg()+"</div></a>";
						html += "</div>";
						html += "<div class='section__article-txtarticle'>";
							html += "<div class='txtarticle__title col-sm-12 mt-3'>";
								html += "<a href='detail?id="+postDTO.getId()+"'>";
									html += "<h4 id='h4_text'>"+postDTO.getTitle()+"</h4>";
								html += "</a>";
							html += "</div>";
							html += "<div class='txtarticle__language mt-2'>";
								html += "<span id='date_post'>"+postDTO.getDate()+"</span> <span id='author_post'>"+postDTO.getAuthor()+"</span>";
							html += "</div>";
							html += "<div class='txtarticle__comment'>";
								html += "<div class='txtarticle__comment-icon'>";
									html += " <a href=''>";
										html += " <span><i class='fa fa-comment-o' aria-hidden='true'></i></i></span>";
										html += "<span> "+postDTO.getSoLuongBinhLuan()+" Bình luận</span>";
										html += "</a>";
								html += "</div>";
							html += "</div>";
						html += "</div>";
					html += "</div>";
				html += "</div>";
				}		
				List<CategoryDTO> listCategory = categoryService.getAll();
				List<HashtagDTO> listHashtag = hashtagService.getAll();
				request.setAttribute("listHashtag", listHashtag);
				request.setAttribute("listPost", listPostByKey);
				request.setAttribute("listCategory", listCategory);
				request.setAttribute("max", max);
			}
		return html;
	}
	
	
	
	
	@RequestMapping(value = "comment",produces = "text/plain;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	public String addComment(HttpServletRequest request,
			@RequestParam(name = "content", required = false) String content,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "id_post", required = false) String id_post){
		String abb = "";
		CommentDTO commentDTO = new CommentDTO(0, name, email, null, content, id_post, id_post);
		if(StringUtils.ckEmail(commentDTO.getEmail(), "^(.+)@(.+)$")) {
			if(postService.update(id_post)) {
					if(commentService.insert(commentDTO)>0) {
						System.out.println("ok r đấy ");
				}
			}
		}else {
			System.out.println("Email không hợp lệ");
		}		
		List<CommentDTO> listCommentByPostId = commentService.getListByPostId(id_post);
			int countComment = listCommentByPostId.size();
			for (CommentDTO comment : listCommentByPostId) {
				abb += "<div class='col-md-12'>";
				abb += "<div class='media g-mb-30 media-comment'>";
				abb += "<div class='media-body u-shadow-v18 g-bg-secondary g-pa-30'>";
				abb += "<div class='g-mb-15'>";
				abb += "<h6 class='h6 g-color-gray-dark-v1 mb-0'>"+comment.getName()+"</h6>";
				abb += "<span class='g-color-gray-dark-v4 g-font-size-12'>"+comment.getDate()+"</span>";
				abb += "</div>";
				abb += "<p>"+comment.getContent()+"</p>";
				abb += "</div>";
				abb += "</div>";
				abb += "</div>";
			} 
			request.setAttribute("countComment", countComment);
		return abb;
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String chitiet(HttpServletRequest request, @RequestParam(name = "id") String id){
		PostDTO postDTO = postService.getDetail(id);
		List<PostDTO> listPostRelated = postService.getListByCategoryId(postDTO.getId_category());
		List<HashtagDTO> listHash = hashtagService.getAllByPostId(id);
		List<CommentDTO> listComment = commentService.getListByPostId(id);
		int countComment = listComment.size();
		List<PostDTO> listPostRandom = postService.getRandom();
		List<CategoryDTO> listCat = categoryService.getAll();
		List<HashtagDTO> listHashtag = hashtagService.getAll();
		List<HashtagDTO> listBestHashtag = hashtagService.getBestHashtag();
		request.setAttribute("listBestHashtag", listBestHashtag);
		request.setAttribute("countComment", countComment);
		request.setAttribute("listHashtag", listHashtag);
		request.setAttribute("listCategory", listCat);
		request.setAttribute("post", postDTO);
		request.setAttribute("hashtag", listHash);
		request.setAttribute("listPostRelated", listPostRelated);
		request.setAttribute("listPostRandom", listPostRandom);
		request.setAttribute("listComment", listComment);
		return "user/chitiet";
	}
	
	@RequestMapping(value = "error", method = { RequestMethod.GET, RequestMethod.POST })
	public String error(HttpServletRequest request){
		return "user/error";
	}
	
	
}
