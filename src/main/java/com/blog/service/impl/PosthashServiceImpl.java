package com.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.HashtagDao;
import com.blog.dao.PostDao;
import com.blog.dao.PosthashDao;
import com.blog.entity.Posthash;
import com.blog.model.PosthashDTO;
import com.blog.service.PosthashService;

@Service
public class PosthashServiceImpl implements PosthashService {

	@Autowired
	PostDao postDao;

	@Autowired
	PosthashDao posthashDao;

	@Autowired
	HashtagDao hashtagDao;

	@Override
	public List<PosthashDTO> getAll() {
		List<PosthashDTO> listposthashDTO = new ArrayList<PosthashDTO>();
		List<Posthash> listPosthash = posthashDao.getAll();
		for (Posthash posthash : listPosthash) {
			PosthashDTO posthashDTO = new PosthashDTO();
			posthashDTO.setId(posthash.getId());
			posthashDTO.setId_post(posthash.getId_post());
			posthashDTO.setId_hashtag(posthash.getId_hashtag());
			posthashDTO.setPost_title(posthash.getPost_title());
			posthashDTO.setHashtag_name(posthash.getHashtag_name());
			listposthashDTO.add(posthashDTO);
		}
		return listposthashDTO;
	}

	@Override
	public int insert(PosthashDTO posthashDTO) {
		Posthash posthash = new Posthash();
		posthash.setId(posthashDTO.getId());
		posthash.setId_post(posthashDTO.getId_post());
		posthash.setId_hashtag(posthashDTO.getId_hashtag());
		if (posthashDao.insert(posthash) > 0)
			return 1;
		return 0;
	}

	@Override
	public boolean update(PosthashDTO posthashDTO) {
		Posthash posthash = new Posthash();
		posthash.setId(posthashDTO.getId());
		posthash.setId_post(posthashDTO.getId_post());
		posthash.setId_hashtag(posthashDTO.getId_hashtag());
		if (posthashDao.update(posthash)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean delete(PosthashDTO posthashDTO) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		if (posthashDao.delete(id)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<PosthashDTO> getAllByPostId(String id) {
		List<PosthashDTO> posthashDTOList = new ArrayList<PosthashDTO>();
		List<Posthash> posthashList = posthashDao.getAllByPostId(id);
		for (Posthash posthash : posthashList) {
			PosthashDTO posthashDTO = new PosthashDTO();
			posthashDTO.setId(posthash.getId());
			posthashDTO.setId_post(posthash.getId_post());
			posthashDTO.setId_hashtag(posthash.getId_hashtag());
			posthashDTOList.add(posthashDTO);
		}
		return posthashDTOList;

	}

	@Override
	public PosthashDTO getDetail(int id) {
		Posthash posthash = new Posthash();
		posthash = posthashDao.getDetail(id);
		PosthashDTO posthashDTO = new PosthashDTO();
		posthashDTO.setId(posthash.getId());
		posthashDTO.setId_post(posthash.getId_post());
		posthashDTO.setId_hashtag(posthash.getId_hashtag());
		return posthashDTO;
	}

}
