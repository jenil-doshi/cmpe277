package com.sjsu.cmpe277.dao;

import com.sjsu.cmpe277.model.User;

public interface UserDao {

	public User insertUserType(String emailId, String userType);
	public User getUserType(String emailId);
}
