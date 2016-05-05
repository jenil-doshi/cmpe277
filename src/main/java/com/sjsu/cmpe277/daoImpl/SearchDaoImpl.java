package com.sjsu.cmpe277.daoImpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe277.dao.SearchDao;
import com.sjsu.cmpe277.model.Posting;
import com.sjsu.cmpe277.model.Search;

@Service
public class SearchDaoImpl implements SearchDao {

	@Autowired
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public Search insertsearchResult(Search search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Posting getsearchResult(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

}
