package com.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.CategoryDao;
import com.blog.dao.PostDao;
import com.blog.dao.PosthashDao;
import com.blog.entity.Post;
import com.blog.model.PostDTO;
import com.blog.service.PostService;
import com.blog.utils.DateUtils;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostDao postDao;
	
	@Autowired
	PosthashDao posthashDao;
	
	@Autowired
	CategoryDao categoryDao;

	
	@Override
	public List<PostDTO> getAll() {
		List<PostDTO> listpostDTO = new ArrayList<PostDTO>();
		List<Post> listPostDTO = postDao.getAll();
		for (Post post : listPostDTO) {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setAuthor(post.getAuthor());
			postDTO.setDate(post.getDate());
			postDTO.setImg(post.getImg());
			postDTO.setId_category(post.getId_category());
			postDTO.setName_category(post.getName_category());
			postDTO.setSoLuongBinhLuan(post.getSoLuongBinhLuan());
			listpostDTO.add(postDTO);
		}		
		return listpostDTO;
	}
	
	
	//get list post relate
	@Override
	public List<PostDTO> getListByCategoryId(String id) {
		List<PostDTO> listpostDTO = new ArrayList<PostDTO>();
		List<Post> listPost = postDao.getListByCategoryId(id);
		for (Post post : listPost) {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setAuthor(post.getAuthor());
			postDTO.setDate(post.getDate());
			postDTO.setImg(post.getImg());
			postDTO.setId_category(post.getId_category());
			postDTO.setName_category(post.getName_category());
			postDTO.setSoLuongBinhLuan(post.getSoLuongBinhLuan());
			listpostDTO.add(postDTO);
		}		
		return listpostDTO;
	}
	
	//get list post relate
		@Override
		public List<PostDTO> getRandom() {
			List<PostDTO> listRandompostDTO = new ArrayList<PostDTO>();
			List<Post> listPostDTO = postDao.getRandom();
			for (Post post : listPostDTO) {
				PostDTO postDTO = new PostDTO();
				postDTO.setId(post.getId());
				postDTO.setTitle(post.getTitle());
				postDTO.setContent(post.getContent());
				postDTO.setAuthor(post.getAuthor());
				postDTO.setDate(post.getDate());
				postDTO.setImg(post.getImg());
				postDTO.setId_category(post.getId_category());
				postDTO.setName_category(post.getName_category());
				listRandompostDTO.add(postDTO);
			}		
			return listRandompostDTO;
		}

	@Override
	public int insert(PostDTO postDTO) {
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setId(postDTO.getId());
		post.setContent(postDTO.getContent());
		post.setAuthor(postDTO.getAuthor());
		post.setDate(DateUtils.getTime());
		post.setImg(postDTO.getImg());
		post.setId_category(postDTO.getId_category());
		post.setSoLuongBinhLuan(postDTO.getSoLuongBinhLuan());
		System.out.println(post);
		if(postDao.insert(post)>0) 
				return 1;
		return 0;
	}

	@Override
	public boolean update(PostDTO postDTO) {
		Post post  = new Post();
		post.setTitle(postDTO.getTitle());
		post.setId(postDTO.getId());
		post.setContent(postDTO.getContent());
		post.setAuthor(postDTO.getAuthor());
//		post.setDate(postDTO.getDate());
		post.setImg(postDTO.getImg());
		post.setId_category(postDTO.getId_category());
//		postDTO.setName_category(post.getName_category());
		if(postDao.update(post)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean delete(PostDTO postDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		if(postDao.delete(id)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public PostDTO getDetail(String id) {
		Post post = new Post();
		post = postDao.getDetail(id);
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setAuthor(post.getAuthor());
			postDTO.setDate(post.getDate());
			postDTO.setImg(post.getImg());
			postDTO.setId_category(post.getId_category());
			postDTO.setName_category(post.getName_category());
			postDTO.setSoLuongBinhLuan(post.getSoLuongBinhLuan());
			return postDTO;
	}


	@Override
	public List<PostDTO> getPostByCategoryId(String id) {
		List<PostDTO> listpostDTOByCategoryId = new ArrayList<PostDTO>();
		List<Post> listPost = postDao.getPostByCategoryId(id);
		for (Post post : listPost) {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setAuthor(post.getAuthor());
			postDTO.setDate(post.getDate());
			postDTO.setImg(post.getImg());
			postDTO.setId_category(post.getId_category());
			postDTO.setName_category(post.getName_category());
			postDTO.setSoLuongBinhLuan(post.getSoLuongBinhLuan());
			listpostDTOByCategoryId.add(postDTO);
		}		
		return listpostDTOByCategoryId;
	}


	@Override
	public List<PostDTO> getPostByKey(String key) {
		List<PostDTO> listpostkey = new ArrayList<PostDTO>();
		List<Post> listPostByKey = postDao.getPostByKey(key);
		for (Post post : listPostByKey) {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setAuthor(post.getAuthor());
			postDTO.setDate(post.getDate());
			postDTO.setImg(post.getImg());
			postDTO.setId_category(post.getId_category());
			postDTO.setName_category(post.getName_category());
			postDTO.setSoLuongBinhLuan(post.getSoLuongBinhLuan());
			listpostkey.add(postDTO);
		}		
		return listpostkey;
	}


	@Override
	public List<PostDTO> getListPostByIdHashtag(String id) {
		List<PostDTO> listpostidhashtag = new ArrayList<PostDTO>();
		List<Post> listPostByIdHashTag = postDao.getListPostByIdHashtag(id);
		for (Post post : listPostByIdHashTag) {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setAuthor(post.getAuthor());
			postDTO.setDate(post.getDate());
			postDTO.setImg(post.getImg());
			postDTO.setId_category(post.getId_category());
			postDTO.setName_category(post.getName_category());
			postDTO.setSoLuongBinhLuan(post.getSoLuongBinhLuan());
			listpostidhashtag.add(postDTO);
		}		
		return listpostidhashtag;
	}


	@Override
	public List<PostDTO> getPostByCategoryIdWithLimit(String id, int start, int end) {
		List<PostDTO> listpostDTO = new ArrayList<PostDTO>();
		List<Post> listPost = postDao.getPostByCategoryIdWithLimit(id,start,end);
		for (Post post : listPost) {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setAuthor(post.getAuthor());
			postDTO.setDate(post.getDate());
			postDTO.setImg(post.getImg());
			postDTO.setId_category(post.getId_category());
			postDTO.setName_category(post.getName_category());
			postDTO.setSoLuongBinhLuan(post.getSoLuongBinhLuan());
			listpostDTO.add(postDTO);
		}		
		return listpostDTO;
	}


	@Override
	public List<PostDTO> getPostByKeyWithLimit(String key, int start, int end) {
		List<PostDTO> listpostkey = new ArrayList<PostDTO>();
		List<Post> listPostByKey = postDao.getPostByKeyWithLimit(key,start,end);
		for (Post post : listPostByKey) {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setAuthor(post.getAuthor());
			postDTO.setDate(post.getDate());
			postDTO.setImg(post.getImg());
			postDTO.setId_category(post.getId_category());
			postDTO.setName_category(post.getName_category());
			postDTO.setSoLuongBinhLuan(post.getSoLuongBinhLuan());
			listpostkey.add(postDTO);
		}		
		return listpostkey;
	}


	@Override
	public List<PostDTO> getListPostByIdHashtagWithLimit(String id, int start, int end) {
		List<PostDTO> listpostidhashtag = new ArrayList<PostDTO>();
		List<Post> listPostByIdHashTag = postDao.getListPostByIdHashtagWithLimit(id, start, end);
		for (Post post : listPostByIdHashTag) {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setAuthor(post.getAuthor());
			postDTO.setDate(post.getDate());
			postDTO.setImg(post.getImg());
			postDTO.setId_category(post.getId_category());
			postDTO.setName_category(post.getName_category());
			postDTO.setSoLuongBinhLuan(post.getSoLuongBinhLuan());
			listpostidhashtag.add(postDTO);
		}		
		return listpostidhashtag;
	}


	@Override
	public List<PostDTO> getAllWithLimit(int start, int end) {
		List<PostDTO> listpostDTO = new ArrayList<PostDTO>();
		List<Post> listPostDTO = postDao.getAllWithLimit(start,end);
		for (Post post : listPostDTO) {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setAuthor(post.getAuthor());
			postDTO.setDate(post.getDate());
			postDTO.setImg(post.getImg());
			postDTO.setId_category(post.getId_category());
			postDTO.setName_category(post.getName_category());
			postDTO.setSoLuongBinhLuan(post.getSoLuongBinhLuan());
			listpostDTO.add(postDTO);
		}		
		return listpostDTO;
	}


	@Override
	public List<PostDTO> getNewestList() {
		List<PostDTO> listRandompostDTO = new ArrayList<PostDTO>();
		List<Post> listPostDTO = postDao.getNewestList();
		for (Post post : listPostDTO) {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setAuthor(post.getAuthor());
			postDTO.setDate(post.getDate());
			postDTO.setImg(post.getImg());
			postDTO.setId_category(post.getId_category());
			postDTO.setName_category(post.getName_category());
			listRandompostDTO.add(postDTO);
		}		
		return listRandompostDTO;
	}


	@Override
	public List<PostDTO> getChart() {
		List<PostDTO> listChart = new ArrayList<PostDTO>();
		List<Post> listPostChartDTO = postDao.getChart();
		for (Post post : listPostChartDTO) {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setAuthor(post.getAuthor());
			postDTO.setDate(post.getDate());
			postDTO.setImg(post.getImg());
			postDTO.setId_category(post.getId_category());
			postDTO.setName_category(post.getName_category());
			postDTO.setAmount(post.getAmount());
			postDTO.setMonth(post.getMonth());
			listChart.add(postDTO);
		}		
		return listChart;
	}


	@Override
	public List<PostDTO> getBestReact() {
		List<PostDTO> listChart = new ArrayList<PostDTO>();
		List<Post> listPostChartDTO = postDao.getBestReact();
		for (Post post : listPostChartDTO) {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setSoLuongBinhLuan(post.getSoLuongBinhLuan());
			listChart.add(postDTO);
		}		
		return listChart;
	}


	@Override
	public List<PostDTO> getOldestList() {
		List<PostDTO> listRandompostDTO = new ArrayList<PostDTO>();
		List<Post> listPostDTO = postDao.getOldestList();
		for (Post post : listPostDTO) {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setAuthor(post.getAuthor());
			postDTO.setDate(post.getDate());
			postDTO.setImg(post.getImg());
			postDTO.setId_category(post.getId_category());
			postDTO.setName_category(post.getName_category());
			listRandompostDTO.add(postDTO);
		}		
		return listRandompostDTO;
	}


	@Override
	public boolean update(String id) {
		if(postDao.update(id)) {
			return true;
		}else {
			return false;
		}
	}

}
