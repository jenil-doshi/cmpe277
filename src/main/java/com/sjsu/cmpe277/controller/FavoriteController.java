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

import com.sjsu.cmpe277.model.Favorite;
import com.sjsu.cmpe277.model.Posting;
import com.sjsu.cmpe277.service.FavoriteService;

@Controller
public class FavoriteController {

	@Autowired
	FavoriteService favoriteService;
	@RequestMapping(value = "/favorite", method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody ResponseEntity<Void> insertFavorite(@RequestBody Favorite favorite) {
		favoriteService.insertFavorite(favorite.getEmailId(), favorite.getPostingId());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
}
	
	@RequestMapping(value = "/favorite/{emailId:.+}", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody ResponseEntity<List<Posting>> getFavorite(@PathVariable String emailId) {
		List<Posting> postingObj = favoriteService.getFavorite(emailId);
		return new ResponseEntity<List<Posting>>(postingObj, HttpStatus.OK);
	}
}
