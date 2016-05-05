package com.sjsu.cmpe277.dao;

import com.sjsu.cmpe277.model.Posting;
import com.sjsu.cmpe277.model.Search;

public interface SearchDao {

	public Search insertsearchResult(Search search);
	public Posting getsearchResult(String searchText);
}
