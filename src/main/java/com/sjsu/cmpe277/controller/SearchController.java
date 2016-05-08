package com.sjsu.cmpe277.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjsu.cmpe277.model.Search;
import com.sjsu.cmpe277.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	SearchService searchService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody ResponseEntity<Search> insertsearchResult(@RequestBody Search search) {
		Search searchObj = searchService.insertsearchResult(search);
		return new ResponseEntity<Search>(searchObj, HttpStatus.OK);
	
}
}
