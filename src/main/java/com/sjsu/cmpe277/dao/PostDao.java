package com.sjsu.cmpe277.dao;

import java.util.List;

import com.sjsu.cmpe277.model.Posting;

public interface PostDao {

	public List<Posting> insertPosting(Posting posting);
	public List<Posting> getListPosting(String emailId);
	public List<Posting> getAllPosting();
}
