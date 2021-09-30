package com.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.HashtagDao;

import com.blog.entity.Hashtag;

import com.blog.model.HashtagDTO;
import com.blog.service.HashtagService;

@Service
public class HashtagServiceImpl implements HashtagService {

	@Autowired
	HashtagDao hashtagDao;

	@Override
	public List<HashtagDTO> getAll() {
		List<HashtagDTO> listhashtagDTO = new ArrayList<HashtagDTO>();
		List<Hashtag> listHashtagDTO = hashtagDao.getAll();
		for (Hashtag hashtag : listHashtagDTO) {
			HashtagDTO HashtagDTO = new HashtagDTO();
			HashtagDTO.setId(hashtag.getId());
			HashtagDTO.setName(hashtag.getName());
			listhashtagDTO.add(HashtagDTO);
		}
		return listhashtagDTO;
	}

	@Override
	public int insert(HashtagDTO hashtagDTO) {
		Hashtag hashtag = new Hashtag();
		hashtag.setName(hashtagDTO.getName());
		hashtag.setId(hashtagDTO.getId());
		if (hashtagDao.insert(hashtag) > 0)
			return 1;
		return 0;
	}

	@Override
	public boolean update(HashtagDTO hashtagDTO) {
		Hashtag hashtag = new Hashtag();
		hashtag.setName(hashtagDTO.getName());
		hashtag.setId(hashtagDTO.getId());
		if (hashtagDao.update(hashtag)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(HashtagDTO hashtagDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		if (hashtagDao.delete(id)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public HashtagDTO getDetail(String id) {
		Hashtag hashtag = new Hashtag();
		hashtag = hashtagDao.getDetail(id);
		HashtagDTO hashtagDTO = new HashtagDTO();
		hashtagDTO.setName(hashtag.getName());
		hashtagDTO.setId(hashtag.getId());
		return hashtagDTO;
	}

	@Override
	public List<HashtagDTO> getAllByPostId(String id) {
		List<HashtagDTO> listhashtagDTO = new ArrayList<HashtagDTO>();
		List<Hashtag> listHashtagDTO = hashtagDao.getAllByPostId(id);
		for (Hashtag hashtag : listHashtagDTO) {
			HashtagDTO HashtagDTO = new HashtagDTO();
			HashtagDTO.setId(hashtag.getId());
			HashtagDTO.setName(hashtag.getName());
			listhashtagDTO.add(HashtagDTO);
		}
		return listhashtagDTO;
	}

	@Override
	public List<HashtagDTO> getBestHashtag() {
		List<HashtagDTO> listhashtagDTO = new ArrayList<HashtagDTO>();
		List<Hashtag> listHashtagDTO = hashtagDao.getBestHashtag();
		for (Hashtag hashtag : listHashtagDTO) {
			HashtagDTO HashtagDTO = new HashtagDTO();
			HashtagDTO.setId(hashtag.getId());
			HashtagDTO.setName(hashtag.getName());
			listhashtagDTO.add(HashtagDTO);
		}
		return listhashtagDTO;
	}

}
