package com.sjsu.cmpe277.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe277.dao.SearchDao;
import com.sjsu.cmpe277.model.Posting;
import com.sjsu.cmpe277.model.Search;
import com.sjsu.cmpe277.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	SearchDao searchDao;
	
	@Override
	public Search insertsearchResult(Search search) {
		
		return searchDao.insertsearchResult(search);
	}

	@Override
	public Posting getsearchResult(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

}
