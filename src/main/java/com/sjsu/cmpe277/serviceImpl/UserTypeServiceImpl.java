package com.sjsu.cmpe277.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjsu.cmpe277.dao.UserTypeDao;
import com.sjsu.cmpe277.model.UserType;
import com.sjsu.cmpe277.service.UserTypeService;

@Service
public class UserTypeServiceImpl implements UserTypeService {

	@Autowired
	UserTypeDao userTypeDao;
	
	@Override
	public UserType insertUserType(int userId, String userType) {
		return userTypeDao.insertUserType(userId, userType);
	}

}
