package com.sjsu.cmpe277.service;

import java.util.List;

import com.sjsu.cmpe277.model.Posting;

public interface PostService {

	public Posting insertPosting(Posting posting);
	public Posting removePosting(String postingName);
	public List<Posting> getListPosting(String emailId);
}
