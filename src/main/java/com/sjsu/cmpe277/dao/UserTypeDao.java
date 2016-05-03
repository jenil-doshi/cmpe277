package com.sjsu.cmpe277.dao;

import com.sjsu.cmpe277.model.UserType;

public interface UserTypeDao {

	public UserType insertUserType(String emailId, String userType);
}
