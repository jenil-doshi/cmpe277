package com.sjsu.cmpe277.dao;

import java.util.List;

import com.sjsu.cmpe277.model.Posting;

public interface PostDao {

	public Posting insertPosting(Posting posting);
	public Posting removePosting(String postingName);
	public List<Posting> getListPosting(String emailId);
}
