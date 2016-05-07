package com.sjsu.cmpe277.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjsu.cmpe277.model.User;
import com.sjsu.cmpe277.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userTypeService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String homepage() {
		return "{ 'response' : 'success' }";
	}

	@RequestMapping(value = "/userType", method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody ResponseEntity<User> insertUserType(@RequestBody User user) {
		User userObj = userTypeService.insertUserType(user);
		return new ResponseEntity<User>(userObj, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/userType/{emailId:.+}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody ResponseEntity<User> getUserType(@PathVariable String emailId) {
		User user = userTypeService.getUserType(emailId);
		System.out.println("ass: " + user.getEmailId() + ", " + user.getUserType());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
