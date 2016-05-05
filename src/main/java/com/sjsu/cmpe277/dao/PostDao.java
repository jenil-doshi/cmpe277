package com.sjsu.cmpe277.dao;

import com.sjsu.cmpe277.model.Posting;

public interface PostDao {

	public Posting insertPosting(Posting posting);
	public Posting removePosting(String postingName);
}
