package com.sjsu.cmpe277.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe277.dao.PostDao;
import com.sjsu.cmpe277.model.Posting;
import com.sjsu.cmpe277.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostDao landLordDao;
	
	@Override
	public Posting insertPosting(Posting posting) {
		return landLordDao.insertPosting(posting);
	}

	@Override
	public Posting removePosting(String postingName) {
		// TODO Auto-generated method stub
		return null;
	}

}
