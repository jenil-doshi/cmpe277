package com.sjsu.cmpe277.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		String email;
		String frequency;
		String frequencyTime;
		String searchText;
		Connection conn = null;
		
		String sql = "INSERT INTO search (emailId,frequency,frequencyTime,searchText) VALUES (?,?,?,?)";
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			if(search.getEmailId() == null)
				email = null;
			else email = search.getEmailId();
			
			if(search.getFrequency() == null)
				frequency = null;
			else frequency = search.getFrequency();
			
			if(search.getFrequencyTime() == null)
				frequencyTime = null;
			else frequencyTime = search.getFrequencyTime();
			
			if(search.getSearchText() == null)
				searchText = null;
			else searchText = search.getSearchText();
			
			
			ps.setString(1, email);
			ps.setString(2, frequency);
			ps.setString(3, frequencyTime);
			ps.setString(4, searchText);
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return search;
	}
	

	@Override
	public Posting getsearchResult(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

}
