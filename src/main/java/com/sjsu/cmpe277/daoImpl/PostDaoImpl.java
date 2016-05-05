package com.sjsu.cmpe277.daoImpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjsu.cmpe277.dao.PostDao;
import com.sjsu.cmpe277.model.Posting;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Posting insertPosting(Posting posting) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Posting removePosting(String postingName) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
