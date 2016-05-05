package com.sjsu.cmpe277.service;

import com.sjsu.cmpe277.model.Posting;

public interface FavoriteService {

	public void insertFavorite(String emailId, String postingId);
	public Posting getFavorite(String emailId);
}
