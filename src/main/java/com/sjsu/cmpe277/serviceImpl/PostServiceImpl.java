package com.sjsu.cmpe277.serviceImpl;

import java.util.List;

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
	public List<Posting> insertPosting(Posting posting) {
		return landLordDao.insertPosting(posting);
	}

	@Override
	public List<Posting> getListPosting(String emailId) {
		return landLordDao.getListPosting(emailId);
	}

}
