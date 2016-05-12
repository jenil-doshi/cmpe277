package com.sjsu.cmpe277.service;

import java.util.List;

import com.sjsu.cmpe277.model.Posting;

public interface PostService {

	public List<Posting> insertPosting(Posting posting);
	public List<Posting> getListPosting(String emailId);
	public List<Posting> getAllPosting();
}
