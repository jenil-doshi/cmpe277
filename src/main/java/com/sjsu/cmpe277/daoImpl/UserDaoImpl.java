package com.sjsu.cmpe277.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjsu.cmpe277.dao.UserDao;
import com.sjsu.cmpe277.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public User insertUserType(User user) {
		
		String sql = "INSERT INTO users (emailId, userType) VALUES (?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmailId());
			ps.setString(2, user.getUserType());
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
		
		return user;
	}

	@Override
	public User getUserType(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

}
