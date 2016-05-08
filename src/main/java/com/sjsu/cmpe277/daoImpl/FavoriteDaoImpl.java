package com.sjsu.cmpe277.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		
		String email;
		String postId;
		Connection conn = null;
		
		String sql = "INSERT INTO favorite (emailId,postingId) VALUES (?,?)";
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			if(emailId == null)
				email = null;
			else email = emailId;
			
			if(postingId == null)
				postId = null;
			else postId = postingId;
			
			
			ps.setString(1, email);
			ps.setString(2, postId);
			
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
		
	}

	@Override
	public Posting getFavorite(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}
}
