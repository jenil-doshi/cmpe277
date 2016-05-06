package com.sjsu.cmpe277.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(value = "/userType", method = RequestMethod.POST, consumes="application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody User insertUserType(@RequestBody User user) {
		return userTypeService.insertUserType(user);
	}

}
