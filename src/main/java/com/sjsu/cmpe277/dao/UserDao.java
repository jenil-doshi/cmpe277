package com.sjsu.cmpe277.dao;

import com.sjsu.cmpe277.model.User;

public interface UserDao {

	public User insertUserType(User user);
	public User getUserType(String emailId);
}
