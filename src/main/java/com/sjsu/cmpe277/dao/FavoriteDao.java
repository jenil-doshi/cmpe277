package com.sjsu.cmpe277.dao;


import java.util.List;

import com.sjsu.cmpe277.model.Posting;

public interface FavoriteDao {

	public void insertFavorite(String emailId, String postingId);
	public List<Posting> getFavorite(String emailId);
}
