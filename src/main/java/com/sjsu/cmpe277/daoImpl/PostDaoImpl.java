package com.sjsu.cmpe277.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

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
		
		String postingName;
		String street;
		String city;
		String state;
		String zip;
		String propertyType;
		String room;
		String bath;
		String sqft;
		int price;
		String contact;
		String email;
		String description;
		String picture;
		String status;
		int viewCount;
		Date time;
		Connection conn = null;
		
		String sql = "INSERT INTO posting (postingName,street,city,state,zip,propertyType,room,"
				+ "bath,sqft,price,contact,email,description,picture,status,viewCount,time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			if(posting.getBath() == null)
				bath = null;
			else bath = posting.getBath();
			
			if(posting.getCity() == null)
				city = null;
			else city = posting.getCity();
			
			if(posting.getContact() == null)
				contact = null;
			else contact = posting.getContact();
			
			if(posting.getDescription() == null)
				description = null;
			else description = posting.getDescription();
			
			if(posting.getEmail() == null)
				email = null;
			else email = posting.getEmail();
			
			if(posting.getPicture() == null)
				picture = null;
			else picture = posting.getPicture();
			
			if(posting.getPostingName() == null)
				postingName = null;
			else postingName = posting.getPostingName();
			
			if(posting.getPrice() != 0)
				price = posting.getPrice();
			else price = 0;
			
			if(posting.getPropertyType() == null)
				propertyType = null;
			else propertyType = posting.getPropertyType();
			
			if(posting.getRoom() == null)
				room = null;
			else room = posting.getRoom();
			
			if(posting.getSqft() == null)
				sqft = null;
			else sqft = posting.getSqft();
			
			if(posting.getState() == null)
				state = null;
			else state = posting.getState();
			
			if(posting.getStreet() == null)
				street = null;
			else street = posting.getStreet();
			
			if(posting.getTime() == null)
				time = null;
			else time = posting.getTime();
			
			if(posting.getViewCount() != 0)
				viewCount = posting.getViewCount();
			else viewCount = 0;
			
			if(posting.getZip() == null)
				zip = null;
			else zip = posting.getZip();
			
			if(posting.getStatus() == null)
				status = null;
			else status = posting.getStatus();
			
			ps.setString(1, postingName);
			ps.setString(2, street);
			ps.setString(3, city);
			ps.setString(4, state);
			ps.setString(5, zip);
			ps.setString(6, propertyType);
			ps.setString(7, room);
			ps.setString(8, bath);
			ps.setString(9, sqft);
			ps.setInt(10, price);
			ps.setString(11, contact);
			ps.setString(12, email);
			ps.setString(13, description);
			ps.setString(14, picture);
			ps.setString(15, status);
			ps.setInt(16, viewCount);
			ps.setDate(17, time);
			
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
		
		return posting;
	}

	@Override
	public Posting removePosting(String postingName) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
