package com.sjsu.cmpe277.service;

import com.sjsu.cmpe277.model.Posting;
import com.sjsu.cmpe277.model.Search;

public interface SearchService {

	public Search insertsearchResult(Search search);
	public Posting getsearchResult(String searchText);
}
