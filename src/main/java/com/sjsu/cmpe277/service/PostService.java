package com.sjsu.cmpe277.service;

import com.sjsu.cmpe277.model.Posting;

public interface PostService {

	public Posting insertPosting(Posting posting);
	public Posting removePosting(String postingName);
}
