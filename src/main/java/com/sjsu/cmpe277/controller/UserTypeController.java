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
	
	 @RequestMapping(method = RequestMethod.GET, produces = "application/json")
	 public String sayHello() {
	     return "greeting Hello World from Spring 4 MVC";
	 }
	
	@RequestMapping(value = "/user/{userId}/{userType}", method = RequestMethod.GET)
	@ResponseBody
    public UserType insertUserType(@PathVariable("userId") int userId, @PathVariable("userType") String userType ) {
		System.out.println("User Id: " + userId);
		System.out.println("User Type: " + userType);
        UserType user = userTypeService.insertUserType(userId, userType);
        return user;
    }
	
}
