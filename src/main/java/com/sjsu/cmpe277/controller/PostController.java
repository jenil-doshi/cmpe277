package com.sjsu.cmpe277.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/post", method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody ResponseEntity<List<Posting>> insertPosting(@RequestBody Posting posting) {
		List<Posting> postingObj = landlordService.insertPosting(posting);
		return new ResponseEntity<List<Posting>>(postingObj, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/post/{emailId:.+}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody ResponseEntity<List<Posting>> getListPosting(@PathVariable String emailId) {
		List<Posting> postingObj = landlordService.getListPosting(emailId);
		return new ResponseEntity<List<Posting>>(postingObj, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/allPost", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody ResponseEntity<List<Posting>> getAllPosting() {
		List<Posting> postingObj = landlordService.getAllPosting();
		return new ResponseEntity<List<Posting>>(postingObj, HttpStatus.OK);
	}
	
}
