package com.sjsu.cmpe277.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjsu.cmpe277.dao.FavoriteDao;
import com.sjsu.cmpe277.model.Posting;

@Repository
public class FavoriteDaoImpl implements FavoriteDao{

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
	public List<Posting> getFavorite(String emailId) {
		Connection conn = null;
		List<Posting> postingList = new ArrayList<Posting>();
		
		String sql = "select * from posting inner join favorite on posting.email = favorite.emailId where favorite.emailId = ?";		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emailId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Posting posting = new Posting();
				posting.setId(rs.getInt("id"));
				posting.setOwnerName(rs.getString("ownerName"));
				posting.setPostingName(rs.getString("postingName"));
				posting.setStreet(rs.getString("street"));
				posting.setCity(rs.getString("city"));
				posting.setState(rs.getString("state"));
				posting.setZip(rs.getString("zip"));
				posting.setPropertyType(rs.getString("propertyType"));
				posting.setRoom(rs.getString("room"));
				posting.setBath(rs.getString("bath"));
				posting.setSqft(rs.getString("sqft"));
				posting.setPrice(rs.getInt("price"));
				posting.setContact(rs.getString("contact"));
				posting.setEmail(rs.getString("email"));
				posting.setDescription(rs.getString("description"));
				posting.setPicture(rs.getString("picture"));
				posting.setStatus(rs.getString("status"));
				posting.setViewCount(rs.getInt("viewCount"));
				posting.setTime(rs.getDate("time"));
				postingList.add(posting);
			}
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
		return postingList;
	
	}
}
