package com.sjsu.cmpe277.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjsu.cmpe277.model.UserType;
import com.sjsu.cmpe277.service.UserTypeService;

@Controller
public class UserTypeController {

	@Autowired
	UserTypeService userTypeService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String homepage() {
		return "{ 'response' : 'success' }";
	}

	@RequestMapping(value = "/userType", method = RequestMethod.POST, consumes="application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody UserType insertUserType(HttpServletRequest request) {
		return userTypeService.insertUserType(request.getParameter("emailId"),request.getParameter("userType"));
	}

}
