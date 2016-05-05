package com.sjsu.cmpe277.daoImpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjsu.cmpe277.dao.FavoriteDao;
import com.sjsu.cmpe277.model.Posting;

@Repository
public class FavoriteDaoImpl implements FavoriteDao {

	@Autowired
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insertFavorite(String emailId, String postingId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Posting getFavorite(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}
}
