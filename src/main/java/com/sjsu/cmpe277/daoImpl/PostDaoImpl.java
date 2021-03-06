package com.sjsu.cmpe277.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjsu.cmpe277.configuration.EmailUtility;
import com.sjsu.cmpe277.dao.PostDao;
import com.sjsu.cmpe277.model.Posting;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	EmailUtility emailUtility;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Posting> insertPosting(Posting posting) {
		
		String ownerName;
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
		String sql = null;
		List<Posting> insertedList;
		List<Posting> list = getListPosting(posting.getEmail());
		if(posting.getId()==0){
			sql = "INSERT INTO posting (ownerName,postingName,street,city,state,zip,propertyType,room,"
					+ "bath,sqft,price,contact,email,description,picture,status,viewCount,time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		}
		else{
			for(int i=0; i<list.size(); i++){
				int postingId = posting.getId();
				int listPostingId = list.get(i).getId();
				if(postingId == listPostingId){
					sql = "update posting set ownerName=?,"
							+ " postingName=?,street=?,city=?,state=?,zip=?,propertyType=?,room=?,bath=?,sqft=?,price=?,"
							+ "contact=?,email=?,description=?,picture=?,status=?,viewCount=?,time=? where id=" + listPostingId;
				}
			}
		}
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			if(posting.getOwnerName() == null)
				ownerName = null;
			else ownerName = posting.getOwnerName();
			
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
			
			ps.setString(1, ownerName);
			ps.setString(2, postingName);
			ps.setString(3, street);
			ps.setString(4, city);
			ps.setString(5, state);
			ps.setString(6, zip);
			ps.setString(7, propertyType);
			ps.setString(8, room);
			ps.setString(9, bath);
			ps.setString(10, sqft);
			ps.setInt(11, price);
			ps.setString(12, contact);
			ps.setString(13, email);
			ps.setString(14, description);
			ps.setString(15, picture);
			ps.setString(16, status);
			ps.setInt(17, viewCount);
			ps.setDate(18, time);
			
			ps.executeUpdate();
			ps.close();
			
			if(posting.getId()==0){
				emailUtility.sendEmail(null, posting, "New");
			}
			else{
				for(int i=0; i<list.size(); i++){
					String newPostingStatus = posting.getStatus();
					String oldPostingStatus = list.get(i).getStatus();
					if(oldPostingStatus.equals(newPostingStatus)){
					}
					else{
						emailUtility.sendEmail(oldPostingStatus, posting, "Update");
					}
				}	
			}
			insertedList = getListPosting(posting.getEmail());
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return insertedList;
	}
	
	@Override
	public List<Posting> getListPosting(String emailId) {
		Connection conn = null;
		List<Posting> postingList = new ArrayList<Posting>();
		
		String sql = "select * from posting where email = ?";		
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

	@Override
	public List<Posting> getAllPosting() {
		Connection conn = null;
		List<Posting> postingList = new ArrayList<Posting>();
		
		String sql = "select * from posting";		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
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
