package com.sjsu.cmpe277.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe277.dao.FavoriteDao;
import com.sjsu.cmpe277.model.Posting;
import com.sjsu.cmpe277.service.FavoriteService;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired
	FavoriteDao favoriteDao;

	@Override
	public void insertFavorite(String emailId, String postingId) {
		favoriteDao.insertFavorite(emailId, postingId);
		
	}

	@Override
	public List<Posting> getFavorite(String emailId) {
		return favoriteDao.getFavorite(emailId);
	}

	@Override
	public boolean deleteFavorite(String emailId, int postId) {
		return favoriteDao.deleteFavorite(emailId, postId);
	}
	

}
