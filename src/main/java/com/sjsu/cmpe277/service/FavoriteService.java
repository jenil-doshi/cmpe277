package com.sjsu.cmpe277.service;

import java.util.List;

import com.sjsu.cmpe277.model.Posting;

public interface FavoriteService {

	public void insertFavorite(String emailId, String postingId);
	public List<Posting> getFavorite(String emailId);
	public boolean deleteFavorite(String emailId, int postId);
}
