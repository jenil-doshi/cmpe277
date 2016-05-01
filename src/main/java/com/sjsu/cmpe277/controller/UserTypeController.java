package com.sjsu.cmpe277.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjsu.cmpe277.model.UserType;
import com.sjsu.cmpe277.service.UserTypeService;
 
@Controller
@RequestMapping("/")
public class UserTypeController {

	@Autowired
	UserTypeService userTypeService;
	
	@RequestMapping(value = "/user/{userId}/{userType}", method = RequestMethod.POST, produces = "application/json")
	
    public @ResponseBody UserType insertUserType(@PathVariable("userId") int userId, @PathVariable("userType") String userType ) {
        UserType user = userTypeService.insertUserType(userId, userType);
        if(user==null)
        	return null;
        else
        	return user;
    }
	
}
