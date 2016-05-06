package com.sjsu.cmpe277.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjsu.cmpe277.model.Posting;
import com.sjsu.cmpe277.service.PostService;

@Controller
public class PostController {

	@Autowired
	PostService landlordService;
	
	@RequestMapping(value = "/posting", method = RequestMethod.POST, consumes="application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody Posting insertUserType(@RequestBody Posting posting) {
		return landlordService.insertPosting(posting);
	}

}
