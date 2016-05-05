package com.sjsu.cmpe277.dao;

import com.sjsu.cmpe277.model.Posting;

public interface FavoriteDao {

	public void insertFavorite(String emailId, String postingId);
	public Posting getFavorite(String emailId);
}