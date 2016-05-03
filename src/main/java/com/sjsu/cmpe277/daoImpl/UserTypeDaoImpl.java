package com.sjsu.cmpe277.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjsu.cmpe277.dao.UserTypeDao;
import com.sjsu.cmpe277.model.UserType;

@Repository
public class UserTypeDaoImpl implements UserTypeDao {

	@Autowired
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public UserType insertUserType(String emailId, String userType) {
		
		String sql = "INSERT INTO users (emailId, userType) VALUES (?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emailId);
			ps.setString(2, userType);
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
		
		UserType user = new UserType();
		user.setEmailId(emailId);
		user.setUserType(userType);
		
		return user;
	}

}
