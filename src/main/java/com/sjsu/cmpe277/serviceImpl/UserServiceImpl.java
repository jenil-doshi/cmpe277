package com.sjsu.cmpe277.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe277.dao.UserDao;
import com.sjsu.cmpe277.model.User;
import com.sjsu.cmpe277.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userTypeDao;
	
	@Override
	public User insertUserType(User user) {
		return userTypeDao.insertUserType(user);
	}

	@Override
	public User getUserType(String emailId) {
		return userTypeDao.getUserType(emailId);
	}

}
